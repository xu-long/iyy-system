package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 新增库存
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/27 3:07 下午
 */
@Data
public class SaveStockCommand implements Serializable {
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
