package com.iyy.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品投放入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/29 11:07 上午
 */
@Data
public class GoodsPutCommand implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;

    /**
     * 库存ID
     */
    @NotNull(message = "库存ID不能为空！")
    private Integer stockId;

    /**
     * 货架ID
     */
    @NotNull(message = "货架ID不能为空！")
    private Integer goodsShelvesId;

    /**
     * 销售单价
     */
    @NotNull(message = "销售单价不能为空！")
    private BigDecimal salesPrice;

    /**
     * 上架重量
     */
    private Double putWeight;

    /**
     * 上架数量
     */
    private Integer putQuantity;
}
