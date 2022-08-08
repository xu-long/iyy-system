package com.iyy.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录信息
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/5 5:35 下午
 */
@Data
public class LoginInfo implements Serializable {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 登录时间
     */
    private Date loginDate;

    /**
     * token
     */
    private String token;
}
