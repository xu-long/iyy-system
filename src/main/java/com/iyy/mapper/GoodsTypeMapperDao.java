package com.iyy.mapper;

import com.iyy.entity.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTypeMapperDao extends GoodsTypeMapper{

    /**
     * 查询商品类别List
     * @return
     */
    public List<GoodsType> queryGoodsTypeList();

    /**
     * 查询商品列表分页
     * @param goodsTypeName
     * @return
     */
    List<GoodsType> queryGoodsTypeListByName(@Param("goodsTypeName") String goodsTypeName);

    /**
     * 查询品类信息根据品类名称
     * @param goodsTypeName
     * @return
     */
    GoodsType queryGoodsTypeByName(@Param("goodsTypeName") String goodsTypeName);
}