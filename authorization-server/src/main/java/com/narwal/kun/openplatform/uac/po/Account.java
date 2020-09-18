package com.narwal.kun.openplatform.uac.po;

import java.io.Serializable;
import java.util.Date;

/**
 * t_sys_account
 * @author generator
 * @date 2019-12-31 11:25:20
 */
public class Account implements Serializable {
    /**
     * 主键id
     */
    private String id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     */
    private String salt;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 账号未过期
     */
    private Boolean accountNonExpired;

    /**
     * 账号是否未被锁定
     */
    private Boolean accountNonLocked;

    /**
     * 凭证未过期
     */
    private Boolean credentialsNonExpired;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    /**
     * 最后修改人
     */
    private String lastModifyUser;

    /**
     * 账号过期时间
     */
    private Date accountExpiredTime;

    /**
     * 凭证过期时间
     */
    private Date credentialsExpiredTime;

    /**
     * 手机号码（登录）
     */
    private String mobile;

    /**
     * 邮箱（登录）
     */
    private String email;

    /**
     * 姓名
     */
    private String name;

    /**
     * 关联的微信的openId
     */
    private String wxOpenId;

    /**
     * 关联的微信的unionId
     */
    private String wxUnionId;

    /**
     * 头像
     */
    private byte[] picImg;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser == null ? null : lastModifyUser.trim();
    }

    public Date getAccountExpiredTime() {
        return accountExpiredTime;
    }

    public void setAccountExpiredTime(Date accountExpiredTime) {
        this.accountExpiredTime = accountExpiredTime;
    }

    public Date getCredentialsExpiredTime() {
        return credentialsExpiredTime;
    }

    public void setCredentialsExpiredTime(Date credentialsExpiredTime) {
        this.credentialsExpiredTime = credentialsExpiredTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId == null ? null : wxUnionId.trim();
    }

    public byte[] getPicImg() {
        return picImg;
    }

    public void setPicImg(byte[] picImg) {
        this.picImg = picImg;
    }
}