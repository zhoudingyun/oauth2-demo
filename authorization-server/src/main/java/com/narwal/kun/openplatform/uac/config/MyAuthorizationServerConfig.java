package com.narwal.kun.openplatform.uac.config;

import com.narwal.kun.openplatform.uac.exception.MyWebResponseExceptionTranslator;
import com.narwal.kun.openplatform.uac.service.MyUserDetailService;
import com.narwal.kun.openplatform.uac.service.MyUserdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Oauth2 配置类
 */
@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier(value = "dataBase1DataSource")
    private DataSource dataSource;

    @Autowired
    private AuthenticationManager authenticationManagerBean;

    @Autowired
    MyUserDetailService myUserDetailService;

    //默认token失效时间
    @Value("${accessTokenValiditySeconds}")
    private int accessTokenValiditySeconds = 15;

    //JDBC存储令牌
    private JdbcClientDetailsService clientDetailsService = null;

    @Bean("bCryptPasswordEncoder")
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置客户端信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clientDetailsService = new JdbcClientDetailsService(dataSource);
        clientDetailsService.setPasswordEncoder(bCryptPasswordEncoder());
        clients.withClientDetails(clientDetailsService);
    }

    @Bean
    public TokenStore tokenStore() {
        TokenStore tokenStore = new JdbcTokenStore(this.dataSource);
        return tokenStore;
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(this.dataSource);
    }

    @Bean
    public ApprovalStore approvalStore() {
        return new JdbcApprovalStore(this.dataSource);
    }

    /**
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        // 将增强的token设置到增强链中, 向token增加额外的信息
        endpoints
                /**
                 * 配置AccessToken的存储方式：此处使用Redis存储
                 * Token的可选存储方式
                 * 1、InMemoryTokenStore
                 * 2、JdbcTokenStore
                 * 3、JwtTokenStore
                 * 4、RedisTokenStore
                 * 5、JwkTokenStore
                 */
                .tokenStore(tokenStore())
                .authenticationManager(authenticationManagerBean)
                // 该字段设置设置refresh token是否重复使用,true:reuse;false:no reuse.
                .reuseRefreshTokens(false)
                .userDetailsService(myUserDetailService)
                // 认证异常处理
                .exceptionTranslator(new MyWebResponseExceptionTranslator());

        // 配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        //管理令牌方式:redis方式保存令牌
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setAuthenticationManager(authenticationManagerBean);
        //是否支持token 刷新
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setReuseRefreshToken(false);
        tokenServices.setClientDetailsService(clientDetailsService);
        //设置token有效时间
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(accessTokenValiditySeconds));
        endpoints.tokenServices(tokenServices);
        endpoints.approvalStore(approvalStore());
        endpoints.authorizationCodeServices(authorizationCodeServices());
    }


    /**
     * 都要设置（很重要）
     * @param oauthServer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()");
        oauthServer.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()");
    }
}
