package com.iyy.service;

import com.github.pagehelper.PageInfo;
import com.iyy.entity.Brand;
import com.iyy.service.params.SaveBrandParams;
import com.iyy.service.params.UpdateBrandParams;

import java.util.List;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/30 4:52 下午
 */
public interface BrandService {
    /**
     * 新增品牌
     * @param saveBrandParams
     * @return
     */
    public int saveBrand(SaveBrandParams saveBrandParams);

    /**
     * 查询品牌list
     * @return
     */
    public List<Brand> queryBrandList();

    /**
     * 查询品牌list
     * @param pageNo
     * @param pageSize
     * @param brandName
     * @return
     */
    public PageInfo<Brand> queryBrandListPage(Integer pageNo, Integer pageSize, String brandName);

    /**
     * 修改品牌信息
     * @param updateBrandParams
     * @return
     */
    int updateBrand(UpdateBrandParams updateBrandParams);
}
