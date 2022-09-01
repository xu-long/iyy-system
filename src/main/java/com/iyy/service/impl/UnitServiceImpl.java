package com.iyy.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.GoodsType;
import com.iyy.entity.Unit;
import com.iyy.entity.User;
import com.iyy.mapper.UnitMapperDao;
import com.iyy.mapper.UserMapperDao;
import com.iyy.service.UnitService;
import com.iyy.vo.ResultResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 单位service实现
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 9:10 下午
 */
@Service
public class UnitServiceImpl implements UnitService {
    @Resource
    private UnitMapperDao unitMapperDao;

    @Resource
    private UserMapperDao userMapperDao;

    @Override
    public ResultResponse saveUnit(Integer userId, String unitTypeCode, String unitName) {
        ResultResponse resultResponse = new ResultResponse();
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("未找到用户信息！");
            return resultResponse;
        }
        Unit unit = unitMapperDao.queryUnitByUnitTypeCode(unitTypeCode, unitName);
        if(ObjectUtil.isNotEmpty(unit)){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("单位信息已存在！");
            return resultResponse;
        }
        Unit saveUnit = new Unit();
        saveUnit.setUnitTypeCode(unitTypeCode);
        saveUnit.setUnitName(unitName);
        saveUnit.setCreateDate(new Date());
        saveUnit.setCreateUser(user.getUserName());
        int rows = unitMapperDao.insertSelective(saveUnit);
        if(rows > 0){
            resultResponse.setCode(StatusConstant.successCode);
            resultResponse.setMessage("新增成功！");
        }else {
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("新增失败！");
        }
        return resultResponse;
    }

    @Override
    public ResultResponse updateUnit(Integer userId, Integer unitId, String unitTypeCode, String unitName) {
        ResultResponse resultResponse = new ResultResponse();
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("未找到用户信息！");
            return resultResponse;
        }
        Unit unit = unitMapperDao.queryUnitByUnitTypeCode(unitTypeCode, unitName);
        if(ObjectUtil.isNotEmpty(unit) && unit.getUnitId() != unitId){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("单位信息已存在！");
            return resultResponse;
        }
        Unit updateUnit = new Unit();
        updateUnit.setUnitId(unitId);
        updateUnit.setUnitTypeCode(unitTypeCode);
        updateUnit.setUnitName(unitName);
        int rows = unitMapperDao.updateByPrimaryKeySelective(updateUnit);
        if(rows > 0){
            resultResponse.setCode(StatusConstant.successCode);
            resultResponse.setMessage("修改成功！");
        }else {
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("修改失败！");
        }
        return resultResponse;
    }

    @Override
    public List<GoodsType> queryUnitListByCode(String unitTypeCode) {
        List<GoodsType> goodsTypes = unitMapperDao.queryUnitListByCode(unitTypeCode);
        return goodsTypes;
    }

    @Override
    public PageInfo<Unit> queryUnitListPage(Integer pageNum, Integer pageSize, String unitTypeCode, String unitName) {
        PageHelper.startPage(pageNum, pageSize);
        List<Unit> unitList = unitMapperDao.queryUnitListPage(unitTypeCode, unitName);
        return new PageInfo<>(unitList);
    }
}
