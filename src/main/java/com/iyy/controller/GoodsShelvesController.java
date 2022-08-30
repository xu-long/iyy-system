package com.iyy.controller;

import com.alibaba.fastjson.JSON;
import com.iyy.command.QueryGoodsShelvesListCommand;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.GoodsShelves;
import com.iyy.service.GoodsShelvesService;
import com.iyy.utils.tools.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 货架controller
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/28 10:08 下午
 */
@RestController
@RequestMapping("/goodsShelves")
@Slf4j
public class GoodsShelvesController {
    @Resource
    private GoodsShelvesService goodsShelvesService;

    /**
     * 查询货架list
     * @param queryGoodsShelvesListCommand
     * @return
     */
    @GetMapping("/queryGoodsShelvesList")
    public Map<String, Object> queryGoodsShelvesList(QueryGoodsShelvesListCommand queryGoodsShelvesListCommand){
        log.info("queryGoodsShelvesListCommand:{}", JSON.toJSONString(queryGoodsShelvesListCommand));
        Map<String, Object> map = new HashMap<>();
        try {
            ValidationUtil.validateBean(queryGoodsShelvesListCommand);
            List<GoodsShelves> goodsShelvesList = goodsShelvesService.quyerGoodsShelvesList(queryGoodsShelvesListCommand.getUserId());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功");
            map.put("result", goodsShelvesList);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询失败：" + e.getMessage());
        }
        return map;
    }
}
