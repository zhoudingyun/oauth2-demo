package org.example.config.common.enums;

public enum LoginEnum {
    USERNAME_NOT_FOUND(1000001, "帐号或密码错误"),
    DISABLED(1000002, "帐号被禁用"),
    ACCOUNT_EXPIRED(1000003, "帐号已过期"),
    LOCKED(1000004, "帐号被锁定"),
    CREDENTIALS_EXPIRED(1000005, "凭证已过期"),
    INVALID_TOKEN(1000006, "token过期或者无效"),
    INVALID_REFRESH_TOKEN(1000007, "刷新token失败"),
    UNKNOW(1000008, "token认证异常，但是没有正确处理"),
    NOT_FOUND_CLIENTID(1000009, "clientId不存在"),
    BAD_CLIENTSECRET(1000010, "clientSecret不匹配"),
    BAD_APPID(1000086, "应用id不存在");

    LoginEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
