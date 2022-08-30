package com.iyy.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.iyy.command.GoodsPutCommand;
import com.iyy.command.GoodsUnPutCommand;
import com.iyy.constant.StatusConstant;
import com.iyy.service.GoodsPutService;
import com.iyy.service.params.GoodsPutParams;
import com.iyy.vo.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.enterprise.inject.spi.Bean;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品上架Controller
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/29 11:03 上午
 */
@RestController
@RequestMapping("/goodsPut")
@Slf4j
public class GoodsPutController {
    @Resource
    private GoodsPutService goodsPutService;

    @PostMapping("/goodsPut")
    public Map<String, Object> goodsPut(GoodsPutCommand goodsPutCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            log.info("goodsPut-params:{}", JSON.toJSONString(goodsPutCommand));
            GoodsPutParams goodsPutParams = new GoodsPutParams();
            BeanUtil.copyProperties(goodsPutCommand, goodsPutParams);
            ResultResponse resultResponse = goodsPutService.goodsPut(goodsPutParams);
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @PostMapping("/goodsUnPut")
    public Map<String, Object> goodsUnPut(GoodsUnPutCommand goodsUnPutCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            log.info("goodsUnPut-params:{}", JSON.toJSONString(goodsUnPutCommand));
            GoodsPutParams goodsPutParams = new GoodsPutParams();
            BeanUtil.copyProperties(goodsUnPutCommand, goodsPutParams);
            ResultResponse resultResponse = goodsPutService.goodsUnPut(goodsPutParams);
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
