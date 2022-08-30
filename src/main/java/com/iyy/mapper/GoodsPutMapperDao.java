package com.iyy.mapper;

import com.iyy.entity.Goods;
import com.iyy.entity.GoodsPut;
import com.iyy.service.params.GoodsPutParams;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsPutMapperDao extends GoodsPutMapper{

    /**
     * 查询库存上架信息
     * @param stockId
     * @return
     */
    public GoodsPut queryGoodsPutByStockId(@Param("stockId") Integer stockId);

    /**
     * 查询商品所有库存上架信息
     * @param goodsId
     * @return
     */
    public List<GoodsPut> queryGoodsPutByGoodsId(@Param("goodsId") Integer goodsId);

    /**
     * 修改商品上架销售价格
     * @param salesPrice
     * @param goodsPutIds
     * @return
     */
    public int updateGoodsPutSalesPrice(@Param("salesPrice")BigDecimal salesPrice, @Param("goodsPutIds") List<Integer> goodsPutIds);

    /**
     * 修改商品上架信息以及库存信息
     * @param goodsPutParams
     * @return
     */
    public int updateGoodsPutAndStock(GoodsPutParams goodsPutParams);

}