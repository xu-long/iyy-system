package com.iyy.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.iyy.command.*;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.Goods;
import com.iyy.entity.GoodsType;
import com.iyy.service.GoodsService;
import com.iyy.service.params.QueryGoodsListParams;
import com.iyy.service.params.SaveGoodsParams;
import com.iyy.service.params.UpdateGoodsParams;
import com.iyy.utils.tools.ValidationUtil;
import com.iyy.vo.GoodsListInfo;
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
 * 商品信息controller
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/25 10:54 上午
 */
@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    /**
     * 查询商品list
     * @param baseCommand
     * @return
     */
    @GetMapping("/getGoodsList")
    public Map<String, Object> queryGoodsList(BaseCommand baseCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            PageInfo<Goods> goodsPageInfo = goodsService.queryGoodsList(baseCommand.getPageNum(), baseCommand.getPageSize());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功！");
            map.put("result", goodsPageInfo.getList());
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询商品列表失败！" + e.getMessage());
        }
        return map;
    }

    @GetMapping("/queryGoodsInfoList")
    public Map<String, Object> queryGoodsInfoList(QueryGoodsListCommand queryGoodsListCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            QueryGoodsListParams queryGoodsListParams = new QueryGoodsListParams();
            BeanUtil.copyProperties(queryGoodsListCommand, queryGoodsListParams);
            PageInfo<GoodsListInfo> goodsPageInfo = goodsService.queryGoodsInfoList(queryGoodsListParams);
            Map<String, Object> data = new HashMap<>();
            data.put("data", goodsPageInfo.getList());
            data.put("pageSize", goodsPageInfo.getPageSize());
            data.put("pageNo", goodsPageInfo.getPageNum());
            data.put("totalCount", goodsPageInfo.getTotal());
            data.put("totalPage", goodsPageInfo.getPages());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功");
            map.put("result", data);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询商品列表失败！" + e.getMessage());
        }
        return map;
    }

    @GetMapping("/queryGoodsTypeList")
    public Map<String, Object> queryGoodsTypeList(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<GoodsType> goodsTypes = goodsService.queryGoodsTypeList();
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功！");
            map.put("result", goodsTypes);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询商品类别列表失败！" + e.getMessage());
        }
        return map;
    }

    @GetMapping("/queryGoodsTypeListPage")
    public Map<String, Object> queryGoodsTypeListPage(QueryGoodsTypeListPageCommand queryGoodsTypeListPageCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            PageInfo<GoodsType> goodsTypePageInfo = goodsService.queryGoodsTypeListPage(queryGoodsTypeListPageCommand.getPageNum(),
                    queryGoodsTypeListPageCommand.getPageSize(),
                    queryGoodsTypeListPageCommand.getGoodsTypeName());
            Map<String, Object> data = new HashMap<>();
            data.put("data", goodsTypePageInfo.getList());
            data.put("pageSize", goodsTypePageInfo.getPageSize());
            data.put("pageNo", goodsTypePageInfo.getPageNum());
            data.put("totalCount", goodsTypePageInfo.getTotal());
            data.put("totalPage", goodsTypePageInfo.getPages());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功");
            map.put("result", data);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询商品类别列表失败！" + e.getMessage());
        }
        return map;
    }

    @PostMapping("/saveGoods")
    public Map<String, Object> saveGoods(SaveGoodsCommand saveGoodsCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            log.info("saveGoods-params:{}", JSON.toJSONString(saveGoodsCommand));
            ValidationUtil.validateBean(saveGoodsCommand);
            SaveGoodsParams saveGoodsParams = new SaveGoodsParams();
            BeanUtil.copyProperties(saveGoodsCommand, saveGoodsParams);
            ResultResponse resultResponse = goodsService.saveGoods(saveGoodsParams);
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "新增商品失败！" + e.getMessage());
        }
        return map;
    }

    @PostMapping("/saveGoodsType")
    public Map<String, Object> saveGoodsType(SaveGoodsTypeCommand saveGoodsTypeCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            ValidationUtil.validateBean(saveGoodsTypeCommand);
            ResultResponse resultResponse = goodsService.saveGoodsType(saveGoodsTypeCommand.getUserId(), saveGoodsTypeCommand.getGoodsTypeName());
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            map.put("code", StatusConstant.failCode);
            map.put("message", "新增失败！" + e.getMessage());
        }
        return map;
    }

    @PostMapping("/updateGoodsType")
    public Map<String, Object> updateGoodsType(UpdateGoodsTypeCommand updateGoodsTypeCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            ValidationUtil.validateBean(updateGoodsTypeCommand);
            ResultResponse resultResponse = goodsService.updateGoodsType(updateGoodsTypeCommand.getUserId(), updateGoodsTypeCommand.getGoodsTypeId(), updateGoodsTypeCommand.getGoodsTypeName());
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            map.put("code", StatusConstant.failCode);
            map.put("message", "新增失败！" + e.getMessage());
        }

        return map;
    }

    @PostMapping("/updateGoods")
    public Map<String, Object> updateGoods(UpdateGoodsCommand updateGoodsCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            log.info("updateGoods-params:{}", JSON.toJSONString(updateGoodsCommand));
            ValidationUtil.validateBean(updateGoodsCommand);
            UpdateGoodsParams updateGoodsParams = new UpdateGoodsParams();
            BeanUtil.copyProperties(updateGoodsCommand, updateGoodsParams);
            ResultResponse resultResponse = goodsService.updateGoods(updateGoodsParams);
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "新增商品失败！" + e.getMessage());
        }
        return map;
    }
}
