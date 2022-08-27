package com.iyy.mapper;


import com.iyy.entity.Goods;

import java.util.List;

public interface GoodsMapperDao extends GoodsMapper{
    /**
     * 查询商品List
     * @return
     */
    List<Goods> queryGoodsList();

}