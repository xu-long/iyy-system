package com.iyy.service.params;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 10:23 上午
 */
@Data
public class UpdateBrandParams {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 品牌ID
     */
    private Integer brandId;

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
