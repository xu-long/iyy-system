package com.iyy.command;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 用户信息
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/4 12:56 下午
 */

public class UserLoginCommand implements Serializable {
    /**
     * 用户名称
     */
    @NotEmpty(message = "用户名不能为空！")
    private String userName;

    /**
     * 用户密码
     */
    @NotEmpty(message = "用户密码不能为空！")
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
