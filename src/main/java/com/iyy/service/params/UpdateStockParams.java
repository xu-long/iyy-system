package com.iyy.service.params;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 库存修改参数
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/27 3:30 下午
 */
@Data
public class UpdateStockParams {
    /**
     * 库存ID
     */
    private Integer stockId;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 商品重量
     */
    private Double putinWeight;

    /**
     * 商品数量
     */
    private Integer putinQuantity;

    /**
     * 商品采购单价
     */
    private BigDecimal purchasePrice;

    /**
     * 商品生产日期
     */
    private String manufactureDate;

    /**
     * 商品过期日期
     */
    private String overdueDate;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 商品备注
     */
    private String remark;
}
