package com.iyy.controller;

import com.github.pagehelper.PageInfo;
import com.iyy.command.*;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.GoodsType;
import com.iyy.entity.Unit;
import com.iyy.service.UnitService;
import com.iyy.utils.tools.ValidationUtil;
import com.iyy.vo.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 8:58 下午
 */
@RestController
@RequestMapping("/unit")
@Slf4j
public class UnitController {
    @Resource
    private UnitService unitService;

    @PostMapping("/saveUnit")
    public Map<String, Object> saveUnit(SaveUnitCommand saveGoodsUnitCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            ValidationUtil.validateBean(saveGoodsUnitCommand);
            ResultResponse resultResponse = unitService.saveUnit(saveGoodsUnitCommand.getUserId(), saveGoodsUnitCommand.getUnitTypeCode(), saveGoodsUnitCommand.getUnitName());
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "新增失败！" + e.getMessage());
        }
        return map;
    }

    @PostMapping("/updateUnit")
    public Map<String, Object> updateUnit(UpdateUnitCommand updateGoodsUnitCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            ValidationUtil.validateBean(updateGoodsUnitCommand);
            ResultResponse resultResponse = unitService.updateUnit(updateGoodsUnitCommand.getUserId(), updateGoodsUnitCommand.getUnitId(), updateGoodsUnitCommand.getUnitTypeCode(), updateGoodsUnitCommand.getUnitName());
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "修改失败！" + e.getMessage());
        }
        return map;
    }

    @GetMapping("/queryUnitList")
    public Map<String, Object> queryUnitList(QueryUnitListCommand queryUnitListCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            ValidationUtil.validateBean(queryUnitListCommand);
            List<GoodsType> goodsTypes = unitService.queryUnitListByCode(queryUnitListCommand.getUnitTypeCode());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功！");
            map.put("result", goodsTypes);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询单位列表失败！" + e.getMessage());
        }
        return map;
    }

    @GetMapping("/queryUnitListPage")
    public Map<String, Object> queryUnitListPage(QueryUnitListCommand queryUnitListCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            ValidationUtil.validateBean(queryUnitListCommand);
            PageInfo<Unit> unitPageInfo = unitService.queryUnitListPage(queryUnitListCommand.getPageNum(),
                    queryUnitListCommand.getPageSize(),
                    queryUnitListCommand.getUnitTypeCode(),
                    queryUnitListCommand.getUnitName());
            Map<String, Object> data = new HashMap<>();
            data.put("data", unitPageInfo.getList());
            data.put("pageSize", unitPageInfo.getPageSize());
            data.put("pageNo", unitPageInfo.getPageNum());
            data.put("totalCount", unitPageInfo.getTotal());
            data.put("totalPage", unitPageInfo.getPages());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功");
            map.put("result", data);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询单位列表失败！" + e.getMessage());
        }
        return map;
    }
}
