package com.iyy.entity;

import java.util.Date;

public class User {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户手机号
     */
    private String userMobile;

    /**
     * 用户状态（00:停用，10:启用）
     */
    private String userState;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 用户头像
     */
    private byte[] userImg;

    /**
     * 获取用户ID
     * @return user_id 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名称
     * @return user_name 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户密码
     * @return user_password 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置用户密码
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * 获取用户手机号
     * @return user_mobile 用户手机号
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 设置用户手机号
     * @param userMobile 用户手机号
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     * 获取用户状态（00:停用，10:启用）
     * @return user_state 用户状态（00:停用，10:启用）
     */
    public String getUserState() {
        return userState;
    }

    /**
     * 设置用户状态（00:停用，10:启用）
     * @param userState 用户状态（00:停用，10:启用）
     */
    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    /**
     * 获取用户昵称
     * @return user_nickname 用户昵称
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 设置用户昵称
     * @param userNickname 用户昵称
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    /**
     * 获取创建用户
     * @return create_user 创建用户
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建用户
     * @param createUser 创建用户
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 获取创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取备注
     * @return remarks 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取用户头像
     * @return user_img 用户头像
     */
    public byte[] getUserImg() {
        return userImg;
    }

    /**
     * 设置用户头像
     * @param userImg 用户头像
     */
    public void setUserImg(byte[] userImg) {
        this.userImg = userImg;
    }
}