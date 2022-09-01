package com.iyy.service;

import com.github.pagehelper.PageInfo;
import com.iyy.entity.GoodsType;
import com.iyy.entity.Unit;
import com.iyy.vo.ResultResponse;

import java.util.List;

/**
 * 单位Service
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 9:10 下午
 */
public interface UnitService {

    /**
     * 新增单位
     * @param userId
     * @param unitTypeCode
     * @param unitName
     * @return
     */
    ResultResponse saveUnit(Integer userId, String unitTypeCode, String unitName);

    /**
     * 修改单位
     * @param userId
     * @param unitId
     * @param unitTypeCode
     * @param unitName
     * @return
     */
    ResultResponse updateUnit(Integer userId, Integer unitId, String unitTypeCode, String unitName);

    /**
     * 查询单位列表根据单位类别code
     * @param unitTypeCode
     * @return
     */
    List<GoodsType> queryUnitListByCode(String unitTypeCode);

    /**
     * 查询单位列表分页
     * @param pageNum
     * @param pageSize
     * @param unitTypeCode
     * @param unitName
     * @return
     */
    PageInfo<Unit> queryUnitListPage(Integer pageNum, Integer pageSize, String unitTypeCode, String unitName);
}
