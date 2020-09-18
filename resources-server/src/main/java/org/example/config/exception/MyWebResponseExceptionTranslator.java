package org.example.config.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class MyWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyWebResponseExceptionTranslator.class);

    @Override
    public ResponseEntity translate(Exception e) {
        LOGGER.error("", e);
        ResponseEntity responseEntity;
        /*Result result = null;
        if (e instanceof InvalidGrantException) {
            if (msg.contains("Invalid refresh token")) {
                // 刷新token时，如果token无效会走这case
                result = Result.custom(LoginEnum.INVALID_REFRESH_TOKEN.getCode(), LoginEnum.INVALID_REFRESH_TOKEN.getMsg());
            } else {
                result = Result.custom(LoginEnum.USERNAME_NOT_FOUND.getCode(), LoginEnum.USERNAME_NOT_FOUND.getMsg());
            }
        } else if (e.getCause() instanceof DisabledException) {
            result = Result.custom(LoginEnum.DISABLED.getCode(), LoginEnum.DISABLED.getMsg());
        } else if (e.getCause() instanceof AccountExpiredException) {
            result = Result.custom(LoginEnum.ACCOUNT_EXPIRED.getCode(), LoginEnum.ACCOUNT_EXPIRED.getMsg());
        } else if (e.getCause() instanceof LockedException) {
            result = Result.custom(LoginEnum.LOCKED.getCode(), LoginEnum.LOCKED.getMsg());
        } else if (e.getCause() instanceof CredentialsExpiredException) {
            result = Result.custom(LoginEnum.CREDENTIALS_EXPIRED.getCode(), LoginEnum.CREDENTIALS_EXPIRED.getMsg());
        } else if (msg.contains("invalid_token")) {
            result = Result.custom(LoginEnum.INVALID_TOKEN.getCode(), LoginEnum.INVALID_TOKEN.getMsg());
        } else if (e instanceof InsufficientAuthenticationException) {
            result = Result.custom(LoginEnum.INVALID_TOKEN.getCode(), LoginEnum.INVALID_TOKEN.getMsg());
        } else {
            result = Result.custom(LoginEnum.UNKNOW.getCode(), LoginEnum.UNKNOW.getMsg());
        }
*/

        HttpHeaders headers = new HttpHeaders();
        List<Charset> acceptableCharsets = new ArrayList<>();
        acceptableCharsets.add(Charset.forName("UTF-8"));
        headers.setAcceptCharset(acceptableCharsets);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        responseEntity = new ResponseEntity("ok", HttpStatus.OK);

        //LOGGER.error("返回数据：{}", result.toString());
        return responseEntity;
    }
}
