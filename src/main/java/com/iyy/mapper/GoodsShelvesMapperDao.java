package com.iyy.mapper;

import com.iyy.entity.GoodsShelves;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface GoodsShelvesMapperDao extends GoodsShelvesMapper{
    /**
     * 查询货架list
     * @param shopId
     * @return
     */
    List<GoodsShelves> queryGoodsShelvesList(@Param("shopId") Integer shopId);
}