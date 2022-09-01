package com.iyy.service.params;

import lombok.Data;

/**
 * 查询商品list参数
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/30 9:45 下午
 */
@Data
public class QueryGoodsListParams extends BaseParams{
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
