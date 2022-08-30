package com.iyy.vo;

import com.iyy.entity.Stock;
import lombok.Data;
import java.io.Serializable;

/**
 * 库存列表信息vo
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/24 3:19 下午
 */
@Data
public class StockListInfo extends Stock implements Serializable {
    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品规格
     */
    private String goodsSpec;

    /**
     * 商品类别Id
     */
    private Integer goodsTypeId;

    /**
     * 销售方式
     */
    private String salesMethod;

    /**
     * 商品单位
     */
    private String goodsUnit;
}
