package com.iyy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iyy.entity.Brand;
import com.iyy.entity.User;
import com.iyy.mapper.BrandMapperDao;
import com.iyy.mapper.UserMapperDao;
import com.iyy.service.BrandService;
import com.iyy.service.params.SaveBrandParams;
import com.iyy.service.params.UpdateBrandParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.misc.FDBigInteger;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/30 4:52 下午
 */
@Service
@Slf4j
public class BrandServiceImpl implements BrandService {
    @Resource
    private UserMapperDao userMapperDao;
    @Resource
    private BrandMapperDao brandMapperDao;

    @Override
    public int saveBrand(SaveBrandParams saveBrandParams) {
        Integer userId = saveBrandParams.getUserId();
        User user = userMapperDao.selectByPrimaryKey(userId);
        Brand saveBrand = new Brand();
        BeanUtil.copyProperties(saveBrandParams, saveBrand);
        saveBrand.setCreateDate(new Date());
        saveBrand.setCreateUser(user.getUserName());
        int rows = brandMapperDao.insertSelective(saveBrand);
        return rows;
    }

    @Override
    public List<Brand> queryBrandList() {
        return brandMapperDao.queryBrandList();
    }

    @Override
    public PageInfo<Brand> queryBrandListPage(Integer pageNo, Integer pageSize, String brandName) {
        PageHelper.startPage(pageNo, pageSize);
        List<Brand> brands = brandMapperDao.queryBrandListByName(brandName);
        return new PageInfo<>(brands);
    }

    @Override
    public int updateBrand(UpdateBrandParams updateBrandParams) {
        User user = userMapperDao.selectByPrimaryKey(updateBrandParams.getUserId());
        if(ObjectUtil.isEmpty(user)){
            throw new RuntimeException("用户信息为空！");
        }
        Brand brand = brandMapperDao.queryBrandByBrandName(updateBrandParams.getBrandName());
        if(ObjectUtil.isNotEmpty(brand) && brand.getBrandId() != updateBrandParams.getBrandId()){
            throw new RuntimeException("修改失败！存在同名的品牌：" + updateBrandParams.getBrandName());
        }
        Brand updateBrand = new Brand();
        BeanUtil.copyProperties(updateBrandParams, updateBrand);
        updateBrand.setModifyDate(new Date());
        updateBrand.setModifyUser(user.getUserName());
        int rows = brandMapperDao.updateByPrimaryKeySelective(updateBrand);
        return rows;
    }
}
