package com.iyy.mapper;

import com.iyy.entity.GoodsType;
import com.iyy.entity.Unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnitMapperDao extends UnitMapper{

    /**
     * 查询单位信息根据单位Code
     * @param unitTypeCode
     * @param unitName
     * @return
     */
    public Unit queryUnitByUnitTypeCode(@Param("unitTypeCode") String unitTypeCode, @Param("unitName") String unitName);

    /**
     * 查询单位list根据单位code
     * @param unitTypeCode
     * @return
     */
    List<GoodsType> queryUnitListByCode(@Param("unitTypeCode") String unitTypeCode);

    /**
     * 查询单位List分页
     * @param unitTypeCode
     * @param unitName
     * @return
     */
    List<Unit> queryUnitListPage(@Param("unitTypeCode") String unitTypeCode, @Param("unitName") String unitName);
}