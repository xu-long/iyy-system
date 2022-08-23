package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 修改用户密码入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/20 10:53 上午
 */
@Data
public class UpdateUserPasswordCommand implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;

    @NotEmpty(message = "用户名不能为空！")
    private String userName;

    /**
     * 用户密码
     */
    @NotEmpty(message = "用户密码不能为空！")
    private String userPassword;

    /**
     * 用户新密码
     */
    @NotEmpty(message = "用户新密码不能为空！")
    private String newUserPassword;
}
