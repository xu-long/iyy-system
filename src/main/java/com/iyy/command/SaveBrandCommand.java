package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 新增品牌信息入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/30 2:36 下午
 */
@Data
public class SaveBrandCommand implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;

    /**
     * 品牌名称
     */
    @NotEmpty(message = "品牌名称不能为空！")
    private String brandName;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 手机号码
     */
    @NotEmpty(message = "手机号码不能为空！")
    private String phoneNumber;

    /**
     * 联系人
     */
    @NotEmpty(message = "联系人不能为空！")
    private String contacts;

    /**
     * 地址
     */
    @NotEmpty(message = "地址不能为空！")
    private String address;

    /**
     * 备注
     */
    private String remark;
}
