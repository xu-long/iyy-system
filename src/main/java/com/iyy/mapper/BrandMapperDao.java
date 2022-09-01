package com.iyy.mapper;

import com.iyy.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapperDao extends BrandMapper{
    /**
     * 查询品牌list根据品牌名称
     * @param brandName
     * @return
     */
    public List<Brand> queryBrandListByName(@Param("brandName") String brandName);

    /**
     * 查询品牌List
     * @return
     */
    public List<Brand> queryBrandList();

    /**
     * 根据品牌名称查询品牌信息
     * @param brandName
     * @return
     */
    public Brand queryBrandByBrandName(@Param("brandName") String brandName);

}