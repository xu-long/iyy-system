package com.iyy.command;

import lombok.Data;

/**
 * 查询商品列表入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/30 9:42 下午
 */
@Data
public class QueryGoodsListCommand extends BaseCommand{
    /**
     * 商品sku
     */
    private String goodsSku;

    /**
     * 品牌ID
     */
    private String brandId;

    /**
     * 商品类别ID
     */
    private String goodsTypeId;
}
