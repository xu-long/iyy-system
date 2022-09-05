package com.iyy.service.params;

import lombok.Data;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/4 8:01 下午
 */
@Data
public class SaveMemberParams {
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
     * 第三方应用ID
     */
    private String openId;
}
