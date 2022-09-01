package com.iyy.service.params;

import lombok.Data;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 10:03 上午
 */
@Data
public class SaveBrandParams {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;
}
