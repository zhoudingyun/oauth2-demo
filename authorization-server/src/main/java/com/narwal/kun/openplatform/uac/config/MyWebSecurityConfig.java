package com.narwal.kun.openplatform.uac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;

/**
 * spring security安全配置类
 */
@Configuration
//@EnableWebSecurity
//@Order(1) // 可以尝试order去掉不同情况
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthenticationProvider authenticationProvider;

    /**
     * 注入 Spring 容器中, 在授权服务器中密码模式下,验证用户密码正确性
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.portMapper().http(80).mapsTo(443);
        http.requiresChannel().anyRequest().requiresSecure();*/
        http.csrf().disable();
        http.authorizeRequests()
            // 不拦截的controller请求
            .antMatchers("/actuator/health", "/login**", "/error**", "/logout1**", "/me**", "/account/**", "/accountApplication/**", "/application/**").permitAll()
            .anyRequest().authenticated().and().formLogin().loginPage("/login1").loginProcessingUrl("/login2");

  /*      http.formLogin().loginPage("/login1").loginProcessingUrl("/login2").permitAll().and()
                .authorizeRequests()
                .mvcMatchers("/login1", "/login2", "/oauth/token").permitAll()
                .antMatchers("/login1", "/login2", "/oauth/token").permitAll()
                .anyRequest().authenticated();*/
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 不拦截静态资源请求
        web.ignoring().antMatchers("/css/**", "/font/**", "/favicon.ico");
    }

}
