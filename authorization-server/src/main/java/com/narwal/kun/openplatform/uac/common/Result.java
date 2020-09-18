package com.narwal.kun.openplatform.uac.common;

import com.narwal.kun.openplatform.uac.common.enums.ResultEnum;

/**
 * @author zhoudingyun
 * @version 1.0.0
 * @since JDK 1.8+
 */
public class Result {
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误描述
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    /**
     * 构造.
     */
    public Result() {
    }

    /**
     * 构造.
     *
     * @param code
     */
    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造.
     *
     * @param code 错误码
     * @param msg 错误描述
     * @param data 返回数据
     */
    public Result(int code, String msg, Object data) {
        this.code = code;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功。
     *
     * @return Result Result
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    /**
     * 成功。
     *
     * @param data 数据
     * @return Result Result
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 失败
     *
     * @return Result
     */
    public static Result fail() {
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMsg(ResultEnum.FAIL.getMsg());
        return result;
    }

    /**
     * 失败
     *
     * @param data 返回数据
     * @return Result
     */
    public static Result fail(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMsg(ResultEnum.FAIL.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 系统内部错误。
     *
     * @return Result Result
     */
    public static Result internalError() {
        Result result = new Result();
        result.setCode(ResultEnum.INTERNAL_ERROR.getCode());
        result.setMsg(ResultEnum.INTERNAL_ERROR.getMsg());
        return result;
    }

    /**
     * 系统内部错误。
     *
     * @return Result Result
     */
    public static Result internalError(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.INTERNAL_ERROR.getCode());
        result.setMsg(ResultEnum.INTERNAL_ERROR.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 非法的参数。
     *
     * @return Result Result
     */
    public static Result illegalArguments(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.ILLEGAL_ARGUMENTS.getCode());
        result.setMsg(ResultEnum.ILLEGAL_ARGUMENTS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 非法的参数。
     *
     * @return Result Result
     */
    public static Result illegalArguments() {
        Result result = new Result();
        result.setCode(ResultEnum.ILLEGAL_ARGUMENTS.getCode());
        result.setMsg(ResultEnum.ILLEGAL_ARGUMENTS.getMsg());
        return result;
    }

    /**
     * 参数丢失。
     *
     * @return Result Result
     */
    public static Result missingParameter(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.MISSING_PARAMETER.getCode());
        result.setMsg(ResultEnum.MISSING_PARAMETER.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 无权访问。
     *
     * @return Result Result
     */
    public static Result forbidden() {
        Result result = new Result();
        result.setCode(ResultEnum.FORBIDDEN.getCode());
        result.setMsg(ResultEnum.FORBIDDEN.getMsg());
        return result;
    }

    /**
     * 自定义
     *
     * @param code 错误码
     * @param msg 错误描述
     * @return Result
     */
    public static Result custom(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 自定义
     *
     * @param code 错误码
     * @param msg 错误描述
     * @param data 返回数据
     * @return Result
     */
    public static Result custom(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }
}
