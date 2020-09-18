/*
 * Copyright (c) 2019 Hengruitong (Fujian) Information Technology Co., Ltd. and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package com.narwal.kun.openplatform.uac.exception;

/**
 * 通用异常类
 *
 * @author zhoudingyun
 * @version 1.0.0
 * @since JDK 1.8+
 */
public class GenericException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int code;
    private String msg;

    public GenericException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GenericException(String message, int code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable cause, int code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericException(Throwable cause, int code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public GenericException(Throwable cause) {
        super(cause);
    }

    public GenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String msg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }

    public GenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
