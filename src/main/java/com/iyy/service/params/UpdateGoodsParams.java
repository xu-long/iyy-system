package com.iyy.service.params;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 修改商品参数
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/31 5:27 下午
 */
@Data
public class UpdateGoodsParams {
    /**
     * 商品ID不能为空
     */
    private Integer goodsId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品sku
     */
    private String goodsSku;

    /**
     * 商品类别ID
     */
    private Integer goodsTypeId;

    /**
     * 商品品牌ID
     */
    private Integer goodsBrandId;

    /**
     * 商品规格
     */
    private String goodsSpec;

    /**
     * 商品重量
     */
    private Double goodsWeight;

    /**
     * 商品数量
     */
    private Integer goodsQuantity = 1;

    /**
     * 商品单位
     */
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
    private String salesMethod;
}
