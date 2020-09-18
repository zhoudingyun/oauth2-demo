package com.narwal.kun.openplatform.uac.service;

import com.narwal.kun.openplatform.uac.common.utils.Pbkdf2Sha256PasswordEncoder;
import com.narwal.kun.openplatform.uac.common.utils.Pbkdf2Sha256Utils;
import com.narwal.kun.openplatform.uac.po.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Map;

/**
 * UserDetailsService 实现类
 *
 * @author zhoudingyun
 * @see AbstractUserDetailsAuthenticationProvider
 * @see org/springframework/security/messages.properties(spring-security-core-5.1.5.RELEASE.jar)
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    @Qualifier(value = "jdbcTemplate2")
    private JdbcTemplate jdbcTemplate;

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    public UserDetails loadUserByUsername(String username) {

        if (StringUtils.isEmpty(username)) {
            LOGGER.info("{}不存在 ", username);
            throw new UsernameNotFoundException(messages.getMessage(
                    "DigestAuthenticationFilter.usernameNotFound", "username"));
        }

        Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM user WHERE mobile=? LIMIT 1", username);
        Account account = new Account();
        account.setUsername(map.get("mobile").toString());
        account.setPassword((String) map.get("password"));
        account.setId(map.get("uuid").toString());
        account.setAccountNonExpired(true);
        account.setEnabled(true);
        account.setAccountNonLocked(true);
        account.setCredentialsNonExpired(true);
       /* // 账号被禁用
        if (!account.getEnabled()) {
            LOGGER.info("{}账号被禁用 ", username);
            throw new DisabledException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.disabled",
                    "User is disabled"));
        }

        // 账号被锁定
        if (!account.getAccountNonLocked()) {
            LOGGER.info("{}帐号被锁定 ", username);
            throw new LockedException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.locked",
                    "User account is locked"));
        }

        // 账号过期
        if (!account.getAccountNonExpired()) {
            LOGGER.info("{}帐号已过期 ", username);
            throw new AccountExpiredException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.expired",
                    "User account has expired"));
        }

        // 密码过期
        if (!account.getCredentialsNonExpired()) {
            LOGGER.info("{}密码已过期 ", username);
            throw new CredentialsExpiredException(messages.getMessage(
                    "LdapAuthenticationProvider.credentialsExpired",
                    "User credentials have expired"));
        }*/

        MyUserdetails userdetails = new MyUserdetails(
                account.getUsername(),
                account.getEmail(),
                account.getMobile(),
                account.getPassword(),
                account.getName(),
                account.getEnabled(),
                account.getAccountNonLocked(),
                account.getAccountNonExpired(),
                account.getCredentialsNonExpired(),
                Collections.emptyList());

        return userdetails;
    }
}
