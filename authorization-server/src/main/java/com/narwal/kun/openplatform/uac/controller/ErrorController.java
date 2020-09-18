/*
package com.narwal.kun.openplatform.uac.controller;

import com.narwal.kun.openplatform.uac.common.GenericController;
import com.narwal.kun.openplatform.uac.common.Result;
import com.narwal.kun.openplatform.uac.common.enums.LoginEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorController extends GenericController {
    private Logger LOGGER = LoggerFactory.getLogger(GenericController.class);

    public ErrorController() {
    }

    @ResponseBody
    @ExceptionHandler({BadCredentialsException.class})
    public Result exception(BadCredentialsException t) {
        this.LOGGER.error("登入帐号未发现：", t);
        return Result.custom(LoginEnum.USERNAME_NOT_FOUND.getCode(), LoginEnum.USERNAME_NOT_FOUND.getMsg());
    }

    @ResponseBody
    @ExceptionHandler({DisabledException.class})
    public Result exception(DisabledException t) {
        this.LOGGER.error("帐号已经被禁用：", t);
        return Result.custom(LoginEnum.DISABLED.getCode(), LoginEnum.DISABLED.getMsg());
    }

    @ResponseBody
    @ExceptionHandler({AccountExpiredException.class})
    public Result exception(AccountExpiredException t) {
        this.LOGGER.error("登入帐号已过期：", t);
        return Result.custom(LoginEnum.ACCOUNT_EXPIRED.getCode(), LoginEnum.ACCOUNT_EXPIRED.getMsg());
    }

    @ResponseBody
    @ExceptionHandler({LockedException.class})
    public Result exception(LockedException t) {
        this.LOGGER.error("登入帐号被锁定：", t);
        return Result.custom(LoginEnum.LOCKED.getCode(), LoginEnum.LOCKED.getMsg());
    }


    @ResponseBody
    @ExceptionHandler({CredentialsExpiredException.class})
    public Result exception(CredentialsExpiredException t) {
        this.LOGGER.error("登入密码已过期：", t);
        return Result.custom(LoginEnum.CREDENTIALS_EXPIRED.getCode(), LoginEnum.CREDENTIALS_EXPIRED.getMsg());
    }

    @ResponseBody
    @ExceptionHandler({InvalidTokenException.class})
    public Result exception(InvalidTokenException t) {
        this.LOGGER.error("无效的token：", t);
        return Result.custom(LoginEnum.INVALID_TOKEN.getCode(), LoginEnum.INVALID_TOKEN.getMsg());
    }

    @ResponseBody
    @ExceptionHandler({Throwable.class})
    public Result exception(Throwable t) {
        this.LOGGER.error("系统错误：", t);
        return Result.internalError();
    }
}
*/
