package com.iyy.service;

import com.github.pagehelper.PageInfo;
import com.iyy.entity.Goods;
import com.iyy.entity.GoodsType;

import java.util.List;

/**
 * 商品service
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/25 10:31 上午
 */
public interface GoodsService {

    /**
     * 查询商品list
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Goods> queryGoodsList(Integer pageNum, Integer pageSize);

    /**
     * 查询商品类别List
     * @return
     */
    public List<GoodsType> queryGoodsTypeList();
}
