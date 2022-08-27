package com.iyy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iyy.entity.Goods;
import com.iyy.entity.GoodsType;
import com.iyy.mapper.GoodsMapperDao;
import com.iyy.mapper.GoodsTypeMapperDao;
import com.iyy.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品serviceImpl
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/25 10:37 上午
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapperDao goodsMapperDao;

    @Resource
    private GoodsTypeMapperDao goodsTypeMapperDao;

    @Override
    public PageInfo<Goods> queryGoodsList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goods = goodsMapperDao.queryGoodsList();
        log.info("查询商品列表size：{}", goods.size());
        return new PageInfo<Goods>(goods);
    }

    @Override
    public List<GoodsType> queryGoodsTypeList() {
        List<GoodsType> goodsTypes = goodsTypeMapperDao.queryGoodsTypeList();
        log.info("查询商品类别size：{}", goodsTypes.size());
        return goodsTypes;
    }

}
