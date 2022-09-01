package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 新增商品参数
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/30 8:29 下午
 */
@Data
public class SaveGoodsCommand implements Serializable {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;

    /**
     * 商品名称
     */
    @NotEmpty(message = "商品名称不能为空！")
    private String goodsName;

    /**
     * 商品sku
     */
    @NotEmpty(message = "商品条码不能为空！")
    private String goodsSku;

    /**
     * 商品类别ID
     */
    @NotNull(message = "商品类别不能为空！")
    private Integer goodsTypeId;

    /**
     * 商品品牌ID
     */
    @NotNull(message = "商品品牌不能为空！")
    private Integer goodsBrandId;

    /**
     * 商品规格
     */
    @NotNull(message = "商品规格不能为空！")
    private String goodsSpec;

    /**
     * 商品重量
     */
    @NotNull(message = "商品重量不能为空！")
    private Double goodsWeight;

    /**
     * 商品数量
     */
    private Integer goodsQuantity = 1;

    /**
     * 商品单位
     */
    @NotEmpty(message = "商品单位不能为空！")
    private String goodsUnit;

    /**
     * 标准件重
     */
    private Double pieceWeight;

    /**
     * 商品产地
     */
    private String goodsManufacture;

    /**
     * 销售方式（10:重量，20:件数）
     */
    @NotEmpty(message = "销售方式不能为空！")
    private String salesMethod;
}
