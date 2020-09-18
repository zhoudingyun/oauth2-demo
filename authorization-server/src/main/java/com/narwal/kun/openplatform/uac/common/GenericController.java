package com.narwal.kun.openplatform.uac.common;

import com.narwal.kun.openplatform.uac.exception.GenericException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhoudingyun
 * @version 1.0.0
 * @since JDK 1.8+
 */
@ControllerAdvice
public class GenericController {
    private Logger LOGGER = LoggerFactory.getLogger(GenericController.class);

    /**
     * bean注解验证异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException ex) {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        LOGGER.error("异常：非法参数：", ex);
        FieldError fieldError = ex.getFieldError();
        return Result.illegalArguments(fieldError.getDefaultMessage());
    }

    @ResponseBody
    @ExceptionHandler(GenericException.class)
    public Result handleBindException(GenericException g) {
        LOGGER.error("异常：业务异常：", g);
        return Result.custom(g.getCode(), g.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public Result exception(Throwable t) {
        LOGGER.error("系统错误：", t);
        return Result.internalError();
    }
}
