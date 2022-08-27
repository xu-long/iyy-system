package com.iyy.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.iyy.command.QueryStockListCommand;
import com.iyy.command.SaveStockCommand;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.Stock;
import com.iyy.service.StockService;
import com.iyy.service.params.QueryStockListParams;
import com.iyy.service.params.SaveStockParams;
import com.iyy.utils.tools.ValidationUtil;
import com.iyy.vo.StockListInfo;
import com.iyy.vo.UserMenuInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存controller
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/23 8:17 下午
 */
@RestController
@RequestMapping("/stock")
@Slf4j
public class StockController {
    @Resource
    private StockService stockService;
    /**
     * 查询库存列表
     * @param queryStockListCommand
     * @return
     */
    @GetMapping("/queryStockList")
    public Map<String, Object> queryStockList(QueryStockListCommand queryStockListCommand){
        log.info("查看库存列表信息");
        log.info("queryStockListCommand:{}", JSON.toJSONString(queryStockListCommand));
        Map<String, Object> map = new HashMap<>();
        try {
            ValidationUtil.validateBean(queryStockListCommand);
            QueryStockListParams queryStockListParams = new QueryStockListParams();
            BeanUtil.copyProperties(queryStockListCommand, queryStockListParams);
            PageInfo<StockListInfo> stockPageInfo = stockService.queryStockList(queryStockListParams);
            Map<String, Object> data = new HashMap<>();
            data.put("data", stockPageInfo.getList());
            data.put("pageSize", stockPageInfo.getPageSize());
            data.put("pageNo", stockPageInfo.getPageNum());
            data.put("totalCount", stockPageInfo.getTotal());
            data.put("totalPage", stockPageInfo.getPages());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功");
            map.put("result", data);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询失败：" + e.getMessage());
        }
        log.info("queryStockListResult:{}", JSON.toJSONString(map));
        return map;
    }

    @PostMapping("/saveStock")
    public Map<String, Object> saveStock(SaveStockCommand saveStockCommand){
        Map<String, Object> map = new HashMap<>();
        log.info("新增库存params:{}", JSON.toJSONString(saveStockCommand));
        try{
            ValidationUtil.validateBean(saveStockCommand);
            SaveStockParams saveStockParams = new SaveStockParams();
            BeanUtil.copyProperties(saveStockCommand, saveStockParams);
            int rows = stockService.saveStock(saveStockParams);
            if(rows > 0){
                map.put("code", StatusConstant.successCode);
                map.put("message", "商品入库成功！");
            }else{
                throw new RuntimeException("保存失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "商品入库失败！" + e.getMessage());
        }
        return map;
    }
}
