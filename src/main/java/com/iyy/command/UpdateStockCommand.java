package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/28 2:54 下午
 */
@Data
public class UpdateStockCommand implements Serializable {
    /**
     * 库存ID不能为空
     */
    @NotNull(message = "库存Id不能为空！")
    private Integer stockId;

    /**
     * 商品ID
     */
    @NotNull(message = "商品Id不能为空！")
    private Integer goodsId;

    /**
     * 商品重量
     */
    @NotNull(message = "商品重量不能为空！")
    private Double putinWeight;

    /**
     * 商品数量
     */
    @NotNull(message = "商品数量不能为空！")
    private Integer putinQuantity;

    /**
     * 商品采购单价
     */
    @NotNull(message = "商品采购单价不能为空")
    private BigDecimal purchasePrice;

    /**
     * 商品生产日期
     */
    @NotEmpty(message = "商品生产日期不能为空！")
    private String manufactureDate;

    /**
     * 商品过期日期
     */
    @NotEmpty(message = "商品过期日期不能为空！")
    private String overdueDate;

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;

    /**
     * 商品备注
     */
    private String remark;
}
