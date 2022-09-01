package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 8:19 下午
 */
@Data
public class UpdateGoodsTypeCommand implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;

    /**
     * 商品类别ID不能为空
     */
    @NotNull(message = "商品类别不能为空！")
    private Integer goodsTypeId;

    /**
     * 商品类别名称
     */
    @NotEmpty(message = "商品类别名称不能为空！")
    private String goodsTypeName;
}
