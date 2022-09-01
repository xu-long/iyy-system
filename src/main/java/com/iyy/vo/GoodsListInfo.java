package com.iyy.vo;

import com.iyy.entity.Goods;
import lombok.Data;

/**
 * 商品列表信息
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/30 1:28 下午
 */
@Data
public class GoodsListInfo extends Goods {
    /**
     * 销售方式子串
     */
    private String salesMethodStr;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 商品类别名称
     */
    private String goodsTypeName;
}
