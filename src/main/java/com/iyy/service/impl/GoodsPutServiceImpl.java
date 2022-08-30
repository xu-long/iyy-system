package com.iyy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.iyy.constant.StatusConstant;
import com.iyy.constant.StockConstant;
import com.iyy.entity.Goods;
import com.iyy.entity.GoodsPut;
import com.iyy.entity.Stock;
import com.iyy.entity.User;
import com.iyy.mapper.GoodsMapperDao;
import com.iyy.mapper.GoodsPutMapperDao;
import com.iyy.mapper.StockMapperDao;
import com.iyy.mapper.UserMapperDao;
import com.iyy.service.GoodsPutService;
import com.iyy.service.params.GoodsPutParams;
import com.iyy.vo.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/29 11:19 上午
 */
@Service
@Slf4j
public class GoodsPutServiceImpl implements GoodsPutService {
    @Resource
    private UserMapperDao userMapperDao;

    @Resource
    private StockMapperDao stockMapperDao;

    @Resource
    private GoodsMapperDao goodsMapperDao;

    @Resource
    private GoodsPutMapperDao goodsPutMapperDao;

    @Override
    @Transactional
    public ResultResponse goodsPut(GoodsPutParams goodsPutParams) throws Exception {
        User user = userMapperDao.selectByPrimaryKey(goodsPutParams.getUserId());
        Stock stock = stockMapperDao.selectByPrimaryKey(goodsPutParams.getStockId());
        if(ObjectUtil.isEmpty(user)){
            throw new RuntimeException("未找到用户信息");
        }
        if(ObjectUtil.isEmpty(stock)){
            throw new RuntimeException("未找到库存信息");
        }
        Goods goods = goodsMapperDao.selectByPrimaryKey(stock.getGoodsId());
        GoodsPut goodsPut = goodsPutMapperDao.queryGoodsPutByStockId(stock.getStockId());
        List<GoodsPut> goodsPuts = goodsPutMapperDao.queryGoodsPutByGoodsId(stock.getGoodsId());
        if(ObjectUtil.isEmpty(goods)){
            throw new RuntimeException("未找到商品信息");
        }
        //上架校验
        validGoodsPutParams(goodsPutParams, stock, goods, goodsPut);
        if(CollectionUtil.isNotEmpty(goodsPuts)){
            List<Integer> goodsPutIds = goodsPuts.stream().map(bean -> bean.getGoodsPutId()).collect(Collectors.toList());
            int updateRows = goodsPutMapperDao.updateGoodsPutSalesPrice(goodsPutParams.getSalesPrice(), goodsPutIds);
            log.info("updateGoodsPutSalesPrice.rows:{}", updateRows);
        }

        if(ObjectUtil.isNotEmpty(goodsPut)){
            int updateRows = goodsPutMapperDao.updateGoodsPutAndStock(goodsPutParams);
            if(updateRows == 0){
                throw new RuntimeException("修改库存信息失败！");
            }
        }else{
            GoodsPut goodsPutBean = new GoodsPut();
            BeanUtil.copyProperties(goodsPutParams, goodsPutBean);
            goodsPutBean.setCanSalesQuantity(goodsPutParams.getPutQuantity());
            goodsPutBean.setCanSalesWeight(goodsPutParams.getPutWeight());
            goodsPutBean.setShopId(user.getShopId());
            goodsPutBean.setGoodsId(goods.getGoodsId());
            goodsPutBean.setPutDate(new Date());
            goodsPutBean.setCreateDate(new Date());
            goodsPutBean.setPutUser(user.getUserName());
            goodsPutBean.setCreateUser(user.getUserName());
            int inserGoodsPutRows = goodsPutMapperDao.insertSelective(goodsPutBean);
            if(inserGoodsPutRows == 0){
                throw new RuntimeException("新增上架信息失败！");
            }
            Stock updateStock = new Stock();
            updateStock.setStockId(stock.getStockId());
            updateStock.setPutWeight(goodsPutParams.getPutWeight());
            updateStock.setPutQuantity(goodsPutParams.getPutQuantity());
            int updatStockRows = stockMapperDao.updateStockPutWeight(updateStock);
            if(updatStockRows == 0){
                throw new RuntimeException("新增上架修改库存失败！");
            }
        }
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(StatusConstant.successCode);
        resultResponse.setMessage("上架成功");
        return resultResponse;
    }

    @Override
    public ResultResponse goodsUnPut(GoodsPutParams goodsPutParams) {
        User user = userMapperDao.selectByPrimaryKey(goodsPutParams.getUserId());
        Stock stock = stockMapperDao.selectByPrimaryKey(goodsPutParams.getStockId());
        if(ObjectUtil.isEmpty(user)){
            throw new RuntimeException("未找到用户信息");
        }
        if(ObjectUtil.isEmpty(stock)){
            throw new RuntimeException("未找到库存信息");
        }
        Goods goods = goodsMapperDao.selectByPrimaryKey(stock.getGoodsId());
        GoodsPut goodsPut = goodsPutMapperDao.queryGoodsPutByStockId(stock.getStockId());
        if(ObjectUtil.isEmpty(goods)){
            throw new RuntimeException("未找到商品信息");
        }
        //上架校验
        validGoodsUnPutParams(goodsPutParams, goodsPut, goods);
        int updateRows = goodsPutMapperDao.updateGoodsPutAndStock(goodsPutParams);
        if (updateRows == 0) {
            throw new RuntimeException("修改库存信息失败！");
        }

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(StatusConstant.successCode);
        resultResponse.setMessage("上架成功");
        return resultResponse;
    }

    /**
     * 校验商品上架参数
     * @param goodsPutParams
     * @param stock
     * @param goods
     */
    private void validGoodsPutParams(GoodsPutParams goodsPutParams, Stock stock, Goods goods, GoodsPut goodsPut){
        String salesMethod = goods.getSalesMethod();
        Double totPutWeight = ObjectUtil.defaultIfNull(goodsPutParams.getPutWeight(), 0.0);
        Integer totPutQuantity = ObjectUtil.defaultIfNull(goodsPutParams.getPutQuantity(), 0);
        if(ObjectUtil.isNotEmpty(goodsPut)){
            totPutWeight = totPutWeight + ObjectUtil.defaultIfNull(goodsPut.getCanSalesWeight(), 0.0);
            totPutQuantity = totPutQuantity + ObjectUtil.defaultIfNull(goodsPut.getCanSalesQuantity(), 0);
        }
        //称重
        if(StockConstant.SALES_METHOD_WEIGHT.equals(salesMethod)){
            if(totPutWeight > stock.getStockWeight()){
                throw new RuntimeException("上架重量超出可上架重量！");
            }
            goodsPutParams.setPutQuantity(ObjectUtil.isEmpty(goodsPut) ? 1 : 0);
        }
        //按件数购买
        if(StockConstant.SALESMETHOD_QUANTITY.equals(salesMethod)){
            if(totPutQuantity > stock.getStockQuantity()){
                throw new RuntimeException("上架数量超出可上架数量！");
            }
            goodsPutParams.setPutWeight(goods.getPieceWeight() * totPutQuantity);
        }
    }

    /**
     * 校验商品下架参数
     * @param goodsPutParams
     * @param stock
     * @param goods
     */
    private void validGoodsUnPutParams(GoodsPutParams goodsPutParams, GoodsPut goodsPut, Goods goods){
        String salesMethod = goods.getSalesMethod();
        Double totPutWeight = ObjectUtil.defaultIfNull(goodsPutParams.getPutWeight(), 0.0);
        Integer totPutQuantity = ObjectUtil.defaultIfNull(goodsPutParams.getPutQuantity(), 0);

        //称重
        if(StockConstant.SALES_METHOD_WEIGHT.equals(salesMethod)){
            if(totPutWeight > goodsPut.getCanSalesWeight()){
                throw new RuntimeException("下架重量超出可下架重量！");
            }
            goodsPutParams.setPutWeight(goodsPutParams.getPutWeight() * -1);
            goodsPutParams.setPutQuantity(-1);
        }
        //按件数购买
        if(StockConstant.SALESMETHOD_QUANTITY.equals(salesMethod)){
            if(totPutQuantity > goodsPut.getCanSalesQuantity()){
                throw new RuntimeException("下架数量超出可下架数量！");
            }
            goodsPutParams.setPutQuantity(goodsPutParams.getPutQuantity() * -1);
            goodsPutParams.setPutWeight(goods.getPieceWeight() * totPutQuantity * -1);
        }
    }
}
