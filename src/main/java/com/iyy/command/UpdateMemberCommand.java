package com.iyy.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 修改会员入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/4 8:13 下午
 */
@Data
public class UpdateMemberCommand implements Serializable {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;

    /**
     * 会员ID
     */
    @NotNull(message = "会员ID不能为空！")
    private Integer memberId;

    /**
     * 会员昵称
     */
    private String memberNickname;

    /**
     * 手机号码
     */
    private String mobileNumber;

    /**
     * 性别：男，女
     */
    private String memberGender;

    /**
     * 状态：00:禁用，10:启用，20，停用
     */
    private String status;

}
