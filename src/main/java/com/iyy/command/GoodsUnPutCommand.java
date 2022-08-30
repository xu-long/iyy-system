package com.iyy.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品下架入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/29 5:29 下午
 */
@Data
public class GoodsUnPutCommand implements Serializable {
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
     * 下架重量
     */
    private Double putWeight;

    /**
     * 下架数量
     */
    private Integer putQuantity;
}
