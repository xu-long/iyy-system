package com.iyy.vo;

import lombok.Data;
import java.io.Serializable;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/5 3:43 下午
 */
@Data
public class MemberInfo implements Serializable {
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
     * 性别
     */
    private String memberGender;

    /**
     * 积分
     */
    private Integer memberIntegral;
}
