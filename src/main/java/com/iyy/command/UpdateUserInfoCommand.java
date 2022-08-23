package com.iyy.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 更新用户信息入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/18 2:26 下午
 */
@Data
public class UpdateUserInfoCommand implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户手机号
     */
    private String userMobile;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 备注
     */
    private String remarks;
}
