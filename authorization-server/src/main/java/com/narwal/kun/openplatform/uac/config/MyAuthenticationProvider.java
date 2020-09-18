package com.narwal.kun.openplatform.uac.config;

import com.narwal.kun.openplatform.uac.common.utils.Pbkdf2Sha256Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * 自定义密码加密验证登录
 *
 * @author frank
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    @Qualifier(value = "jdbcTemplate2")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM user WHERE mobile=? LIMIT 1", username);

        //加密过程在这里体现
        if (Pbkdf2Sha256Utils.verification((String) map.get("password"), password)) {
            throw new DisabledException("Wrong password.");
        }

        return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
