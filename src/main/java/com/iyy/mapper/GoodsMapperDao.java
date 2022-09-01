package com.iyy.mapper;


import com.iyy.entity.Goods;
import com.iyy.service.params.QueryGoodsListParams;
import com.iyy.vo.GoodsListInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapperDao extends GoodsMapper{
    /**
     * 查询商品List
     * @return
     */
    List<Goods> queryGoodsList();

    /**
     * 查询商品信息list
     * @param queryGoodsListParams
     * @return
     */
    List<GoodsListInfo> queryGoodsInfoList(QueryGoodsListParams queryGoodsListParams);

    /**
     * 根据sku查询商品信息
     * @param goodsSku
     * @return
     */
    Goods queryGoodsBySku(@Param("goodsSku") String goodsSku);
}