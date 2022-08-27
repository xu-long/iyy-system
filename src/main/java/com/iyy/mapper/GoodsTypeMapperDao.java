package com.iyy.mapper;

import com.iyy.entity.GoodsType;
import java.util.List;

public interface GoodsTypeMapperDao extends GoodsTypeMapper{

    /**
     * 查询商品类别List
     * @return
     */
    public List<GoodsType> queryGoodsTypeList();

}