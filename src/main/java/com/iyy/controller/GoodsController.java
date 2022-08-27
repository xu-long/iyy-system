package com.iyy.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.iyy.command.BaseCommand;
import com.iyy.command.SaveStockCommand;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.Goods;
import com.iyy.entity.GoodsType;
import com.iyy.service.GoodsService;
import com.iyy.utils.tools.ValidationUtil;
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
}
