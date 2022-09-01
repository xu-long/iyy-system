package com.iyy.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.iyy.command.*;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.Brand;
import com.iyy.service.BrandService;
import com.iyy.service.params.SaveBrandParams;
import com.iyy.service.params.SaveStockParams;
import com.iyy.service.params.UpdateBrandParams;
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
 * 品牌Controller
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/30 2:35 下午
 */
@RestController
@RequestMapping("/brand")
@Slf4j
public class BrandController {

    @Resource
    private BrandService brandService;

    @GetMapping("/queryBrandList")
    public Map<String, Object> queryBrandList(){
        Map<String, Object> map = new HashMap<>();
        try {
            List<Brand> brands = brandService.queryBrandList();
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功");
            map.put("result", brands);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @GetMapping("/queryBrandListPage")
    public Map<String, Object> queryBrandListPage(QueryBrandListPageCommand queryBrandListPageCommand){
        Map<String, Object> map = new HashMap<>();
        try {
            PageInfo<Brand> brands = brandService.queryBrandListPage(queryBrandListPageCommand.getPageNum(), queryBrandListPageCommand.getPageSize(), queryBrandListPageCommand.getBrandName());
            Map<String, Object> data = new HashMap<>();
            data.put("data", brands.getList());
            data.put("pageSize", brands.getPageSize());
            data.put("pageNo", brands.getPageNum());
            data.put("totalCount", brands.getTotal());
            data.put("totalPage", brands.getPages());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功");
            map.put("result", data);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", e.getMessage());
        }
        return map;
    }


    /**
     * 新增品牌
     * @param saveBrandCommand
     * @return
     */
    @PostMapping("/saveBrand")
    public Map<String, Object> saveBrand(SaveBrandCommand saveBrandCommand){
        Map<String, Object> map = new HashMap<>();
        log.info("新增品牌params:{}", JSON.toJSONString(saveBrandCommand));
        try{
            ValidationUtil.validateBean(saveBrandCommand);
            SaveBrandParams saveBrandParams = new SaveBrandParams();
            BeanUtil.copyProperties(saveBrandCommand, saveBrandParams);
            int rows = brandService.saveBrand(saveBrandParams);
            if(rows > 0){
                map.put("code", StatusConstant.successCode);
                map.put("message", "品牌新增成功！");
            }else{
                map.put("code", StatusConstant.successCode);
                map.put("message", "品牌新增失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "品牌新增失败！" + e.getMessage());
        }
        return map;
    }

    /**
     * 修改品牌
     * @param saveBrandCommand
     * @return
     */
    @PostMapping("/updateBrand")
    public Map<String, Object> updateBrand(UpdateBrandCommand updateBrandCommand){
        Map<String, Object> map = new HashMap<>();
        log.info("修改品牌params:{}", JSON.toJSONString(updateBrandCommand));
        try{
            ValidationUtil.validateBean(updateBrandCommand);
            UpdateBrandParams updateBrandParams = new UpdateBrandParams();
            BeanUtil.copyProperties(updateBrandCommand, updateBrandParams);
            int rows = brandService.updateBrand(updateBrandParams);
            if(rows > 0){
                map.put("code", StatusConstant.successCode);
                map.put("message", "品牌修改成功！");
            }else{
                map.put("code", StatusConstant.successCode);
                map.put("message", "品牌修改失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "品牌修改失败！" + e.getMessage());
        }
        return map;
    }


}
