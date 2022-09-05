package com.iyy.service.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 修改会员参数
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/4 8:17 下午
 */
@Data
public class UpdateMemberParams {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 会员ID
     */
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
