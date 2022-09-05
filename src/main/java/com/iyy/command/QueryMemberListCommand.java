package com.iyy.command;

import lombok.Data;
import java.io.Serializable;

/**
 * 查询会员信息list入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/4 2:54 下午
 */
@Data
public class QueryMemberListCommand extends BaseCommand implements Serializable {
    /**
     * 会员昵称
     */
    private String memberNickname;

    /**
     * 手机号码
     */
    private String mobileNumber;
}
