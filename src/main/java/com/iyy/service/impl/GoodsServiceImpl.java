package com.iyy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.Goods;
import com.iyy.entity.GoodsType;
import com.iyy.entity.User;
import com.iyy.mapper.GoodsMapperDao;
import com.iyy.mapper.GoodsTypeMapperDao;
import com.iyy.mapper.UserMapperDao;
import com.iyy.service.GoodsService;
import com.iyy.service.params.QueryGoodsListParams;
import com.iyy.service.params.SaveGoodsParams;
import com.iyy.service.params.UpdateGoodsParams;
import com.iyy.vo.GoodsListInfo;
import com.iyy.vo.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private UserMapperDao userMapperDao;

    @Override
    public PageInfo<Goods> queryGoodsList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goods = goodsMapperDao.queryGoodsList();
        log.info("查询商品列表size：{}", goods.size());
        return new PageInfo<Goods>(goods);
    }

    @Override
    public PageInfo<GoodsListInfo> queryGoodsInfoList(QueryGoodsListParams queryGoodsListParams) {
        PageHelper.startPage(queryGoodsListParams.getPageNum(), queryGoodsListParams.getPageSize());
        List<GoodsListInfo> goodsListInfos = goodsMapperDao.queryGoodsInfoList(queryGoodsListParams);
        log.info("查询商品信息列表size：{}", goodsListInfos.size());
        return new PageInfo<GoodsListInfo>(goodsListInfos);
    }

    @Override
    public ResultResponse saveGoods(SaveGoodsParams saveGoodsParams) throws Exception {
        ResultResponse resultResponse = new ResultResponse();
        Integer userId = saveGoodsParams.getUserId();
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            throw new RuntimeException("未找到用户信息！");
        }
        Goods goods = goodsMapperDao.queryGoodsBySku(saveGoodsParams.getGoodsSku());
        if(ObjectUtil.isNotEmpty(goods)){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("存在相同条码的商品：" + goods.getGoodsName() );
            return resultResponse;
        }
        Goods saveGoods = new Goods();
        BeanUtil.copyProperties(saveGoodsParams, saveGoods);
        saveGoods.setPieceWeight(saveGoods.getGoodsWeight());
        saveGoods.setCreateDate(new Date());
        saveGoods.setCreateUser(user.getUserName());
        int rows = goodsMapperDao.insertSelective(saveGoods);
        if(rows > 0){
            resultResponse.setCode(StatusConstant.successCode);
            resultResponse.setMessage("商品新增成功！");
        }else{
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("商品新增失败！");
        }
        return resultResponse;
    }

    @Override
    public List<GoodsType> queryGoodsTypeList() {
        List<GoodsType> goodsTypes = goodsTypeMapperDao.queryGoodsTypeList();
        log.info("查询商品类别size：{}", goodsTypes.size());
        return goodsTypes;
    }

    @Override
    public ResultResponse updateGoods(UpdateGoodsParams updateGoodsParams) {
        ResultResponse resultResponse = new ResultResponse();
        Integer userId = updateGoodsParams.getUserId();
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            throw new RuntimeException("未找到用户信息！");
        }
        Goods goods = goodsMapperDao.queryGoodsBySku(updateGoodsParams.getGoodsSku());
        if(ObjectUtil.isNotEmpty(goods) && goods.getGoodsId() != updateGoodsParams.getGoodsId()){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("存在相同条码的商品：" + goods.getGoodsName() );
            return resultResponse;
        }
        Goods saveGoods = new Goods();
        BeanUtil.copyProperties(updateGoodsParams, saveGoods);
        saveGoods.setPieceWeight(saveGoods.getGoodsWeight());
        int rows = goodsMapperDao.updateByPrimaryKeySelective(saveGoods);
        if(rows > 0){
            resultResponse.setCode(StatusConstant.successCode);
            resultResponse.setMessage("商品新增成功！");
        }else{
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("商品新增失败！");
        }
        return resultResponse;
    }

    @Override
    public PageInfo<GoodsType> queryGoodsTypeListPage(Integer pageNum, Integer pageSize, String goodsTypeName) {
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsType> goodsTypes = goodsTypeMapperDao.queryGoodsTypeListByName(goodsTypeName);
        log.info("分页查询商品列表size:{}", goodsTypes.size());
        return new PageInfo<>(goodsTypes);
    }

    @Override
    public ResultResponse saveGoodsType(Integer userId, String goodsTypeName) {
        ResultResponse resultResponse = new ResultResponse();
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("未找到用户信息");
            return resultResponse;
        }
        GoodsType goodsTypeBean = goodsTypeMapperDao.queryGoodsTypeByName(goodsTypeName);
        if(ObjectUtil.isNotEmpty(goodsTypeBean)){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("品类名称已存在");
            return resultResponse;
        }
        GoodsType goodsType = new GoodsType();
        goodsType.setGoodsTypeName(goodsTypeName);
        goodsType.setCreateDate(new Date());
        goodsType.setCreateUser(user.getUserName());
        int rows = goodsTypeMapperDao.insertSelective(goodsType);
        if(rows > 0){
            resultResponse.setCode(StatusConstant.successCode);
            resultResponse.setMessage("新增成功");
        }else{
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("新增失败");
        }
        return resultResponse;
    }

    @Override
    public ResultResponse updateGoodsType(Integer userId, Integer goodsTypeId, String goodsTypeName) {
        ResultResponse resultResponse = new ResultResponse();
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("未找到用户信息");
            return resultResponse;
        }
        GoodsType goodsTypeBean = goodsTypeMapperDao.queryGoodsTypeByName(goodsTypeName);
        if(ObjectUtil.isNotEmpty(goodsTypeBean) && goodsTypeBean.getGoodsTypeId() != goodsTypeId){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("品类名称已存在");
            return resultResponse;
        }
        GoodsType goodsType = new GoodsType();
        goodsType.setGoodsTypeId(goodsTypeId);
        goodsType.setGoodsTypeName(goodsTypeName);
        int rows = goodsTypeMapperDao.updateByPrimaryKeySelective(goodsType);
        if(rows > 0){
            resultResponse.setCode(StatusConstant.successCode);
            resultResponse.setMessage("修改成功");
        }else{
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("修改失败");
        }
        return resultResponse;
    }

}
