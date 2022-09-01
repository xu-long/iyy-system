package com.iyy.service.params;

import lombok.Data;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/30 9:06 下午
 */
@Data
public class SaveGoodsParams {
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
    private Integer goodsQuantity;

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
