package org.example.config.common.enums;

public enum ResultEnum {
    /**
     * 成功.
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * 失败
     */
    FAIL(201, "FAIL"),
    /**
     * 非法的参数
     */
    ILLEGAL_ARGUMENTS(202, "ILLEGAL_ARGUMENTS"),
    /**
     * 参数丢失
     */
    MISSING_PARAMETER(203, "MISSING_PARAMETER"),
    /**
     * 无操作权限
     */
    FORBIDDEN(403, "FORBIDDEN"),
    /**
     * 系统错误(系统内部错误).
     */
    INTERNAL_ERROR(500, "INTERNAL_ERROR");

    private int code;

    private String msg;

    /**
     * 构造。
     *
     * @param code code
     */
    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
