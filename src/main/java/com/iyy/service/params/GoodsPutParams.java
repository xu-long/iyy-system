package com.iyy.service.params;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 商品投放参数
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/29 11:17 上午
 */
@Data
public class GoodsPutParams {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 库存ID
     */
    private Integer stockId;

    /**
     * 货架ID
     */
    private Integer goodsShelvesId;

    /**
     * 销售单价
     */
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
