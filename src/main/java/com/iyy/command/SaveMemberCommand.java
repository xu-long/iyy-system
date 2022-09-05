package com.iyy.command;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/4 5:02 下午
 */

@Data
public class SaveMemberCommand implements Serializable {

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
