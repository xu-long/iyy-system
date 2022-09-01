package com.iyy.service;

import com.github.pagehelper.PageInfo;
import com.iyy.entity.Goods;
import com.iyy.entity.GoodsType;
import com.iyy.service.params.QueryGoodsListParams;
import com.iyy.service.params.SaveGoodsParams;
import com.iyy.service.params.UpdateGoodsParams;
import com.iyy.vo.GoodsListInfo;
import com.iyy.vo.ResultResponse;

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
     * 查询商品信息list
     * @return
     */
    public PageInfo<GoodsListInfo> queryGoodsInfoList(QueryGoodsListParams queryGoodsListParams);

    /**
     * 新增商品
     * @param saveGoodsParams
     * @return
     * @throws Exception
     */
    public ResultResponse saveGoods(SaveGoodsParams saveGoodsParams) throws Exception;

    /**
     * 查询商品类别List
     * @return
     */
    public List<GoodsType> queryGoodsTypeList();

    /**
     * 修改商品信息
     * @param updateGoodsParams
     * @return
     */
    public ResultResponse updateGoods(UpdateGoodsParams updateGoodsParams);

    /**
     * 查询商品类别List分页
     * @param pageNum
     * @param pageSize
     * @param goodsTypeName
     * @return
     */
    public PageInfo<GoodsType> queryGoodsTypeListPage(Integer pageNum, Integer pageSize, String goodsTypeName);

    /**
     * 新增品类信息
     * @param userId
     * @param goodsTypeName
     * @return
     */
    ResultResponse saveGoodsType(Integer userId, String goodsTypeName);

    /**
     * 修改品类信息
     * @param userId
     * @param goodsTypeId
     * @param goodsTypeName
     * @return
     */
    ResultResponse updateGoodsType(Integer userId, Integer goodsTypeId, String goodsTypeName);
}
