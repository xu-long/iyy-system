package com.iyy.service.params;

import lombok.Data;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/4 3:11 下午
 */
@Data
public class QueryMemberListParams extends BaseParams{
    /**
     * 会员昵称
     */
    private String memberNickname;

    /**
     * 手机号码
     */
    private String mobileNumber;
}
