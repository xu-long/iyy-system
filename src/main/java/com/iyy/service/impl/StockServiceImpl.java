package com.iyy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iyy.constant.StockConstant;
import com.iyy.entity.Goods;
import com.iyy.entity.Stock;
import com.iyy.entity.User;
import com.iyy.mapper.GoodsMapperDao;
import com.iyy.mapper.StockMapperDao;
import com.iyy.mapper.UserMapperDao;
import com.iyy.service.StockService;
import com.iyy.service.params.QueryStockListParams;
import com.iyy.service.params.SaveStockParams;
import com.iyy.service.params.UpdateStockParams;
import com.iyy.vo.StockListInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.iyy.constant.StockConstant.STANDARD_AMOUNT_SCALE;

/**
 * 库存service
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/23 8:54 下午
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService {
    @Resource
    private StockMapperDao stockMapperDao;

    @Resource
    private UserMapperDao userMapperDao;

    @Resource
    private GoodsMapperDao goodsMapperDao;

    @Override
    public PageInfo<StockListInfo> queryStockList(QueryStockListParams queryStockListParams) {
        log.info("查询库存列表信息list-param:{}", JSON.toJSONString(queryStockListParams));
        PageHelper.startPage(queryStockListParams.getPageNum(), queryStockListParams.getPageSize());
        List<StockListInfo> stocks = stockMapperDao.queryStockList(queryStockListParams);
        log.info("查询库存列表信息list-size:{}", stocks.size());
        return new PageInfo<>(stocks);
    }

    @Override
    public int saveStock(SaveStockParams saveStockParams) throws Exception{
        Integer userId = saveStockParams.getUserId();
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            throw new IllegalArgumentException("用户信息为空！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date manufactureDate = sdf.parse(saveStockParams.getManufactureDate());
        Date overdueDate = sdf.parse(saveStockParams.getOverdueDate());
        Goods goods = goodsMapperDao.selectByPrimaryKey(saveStockParams.getGoodsId());
        validSaveStockInfo(saveStockParams, goods);
        Stock saveStock = new Stock();
        BeanUtil.copyProperties(saveStockParams, saveStock);
        BeanUtil.copyProperties(goods, saveStock);
        saveStock.setShopId(user.getShopId());
        saveStock.setCreateDate(new Date());
        saveStock.setCreateUser(user.getUserName());
        saveStock.setManufactureDate(manufactureDate);
        saveStock.setOverdueDate(overdueDate);
        saveStock.setStockWeight(saveStock.getPutinWeight());
        saveStock.setStockQuantity(saveStock.getPutinQuantity());
        String salesMethod = goods.getSalesMethod();
        BigDecimal purchaseAmount = BigDecimal.ZERO;
        switch (salesMethod){
            case StockConstant.SALES_METHOD_WEIGHT :
                purchaseAmount = saveStock.getPurchasePrice().multiply(new BigDecimal(saveStock.getPutinWeight())).setScale(STANDARD_AMOUNT_SCALE, BigDecimal.ROUND_HALF_UP);
                break;
            case StockConstant.SALESMETHOD_QUANTITY :
                purchaseAmount = saveStock.getPurchasePrice().multiply(new BigDecimal(saveStock.getPutinQuantity())).setScale(STANDARD_AMOUNT_SCALE, BigDecimal.ROUND_HALF_UP);
                break;
        }
        saveStock.setPurchaseAmount(purchaseAmount);
        int rows = stockMapperDao.insertSelective(saveStock);
        log.info("新增库存结果：{}", rows);
        return rows;
    }

    @Override
    public int updateStock(UpdateStockParams updateStockParams) throws Exception{
        Integer userId = updateStockParams.getUserId();
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            throw new IllegalArgumentException("用户信息为空！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date manufactureDate = sdf.parse(updateStockParams.getManufactureDate());
        Date overdueDate = sdf.parse(updateStockParams.getOverdueDate());
        Goods goods = goodsMapperDao.selectByPrimaryKey(updateStockParams.getGoodsId());
        Stock updateStock = new Stock();
        BeanUtil.copyProperties(updateStockParams, updateStock);
        BeanUtil.copyProperties(goods, updateStock);
        updateStock.setModifyDate(new Date());
        updateStock.setModifyUser(user.getUserName());
        updateStock.setManufactureDate(manufactureDate);
        updateStock.setOverdueDate(overdueDate);
        updateStock.setStockWeight(updateStock.getPutinWeight());
        updateStock.setStockQuantity(updateStock.getPutinQuantity());
        String salesMethod = goods.getSalesMethod();
        BigDecimal purchaseAmount = BigDecimal.ZERO;
        switch (salesMethod){
            case StockConstant.SALES_METHOD_WEIGHT :
                purchaseAmount = updateStock.getPurchasePrice().multiply(new BigDecimal(updateStock.getPutinWeight())).setScale(STANDARD_AMOUNT_SCALE, BigDecimal.ROUND_HALF_UP);
                break;
            case StockConstant.SALESMETHOD_QUANTITY :
                purchaseAmount = updateStock.getPurchasePrice().multiply(new BigDecimal(updateStock.getPutinQuantity())).setScale(STANDARD_AMOUNT_SCALE, BigDecimal.ROUND_HALF_UP);
                break;
        }
        updateStock.setPurchaseAmount(purchaseAmount);
        int rows = stockMapperDao.updateByPrimaryKeySelective(updateStock);
        log.info("修改库存结果：{}", rows);
        return rows;
    }

    private void validSaveStockInfo(SaveStockParams saveStockParams, Goods goods){
        String salesMethod = goods.getSalesMethod();
        Double pieceWeight = goods.getPieceWeight();
        switch (salesMethod){
            case StockConstant.SALES_METHOD_WEIGHT :
                //称重模式默认1件
                saveStockParams.setPutinQuantity(1);
                break;
            case StockConstant.SALESMETHOD_QUANTITY :
                if(saveStockParams.getPutinQuantity() * pieceWeight != saveStockParams.getPutinWeight()){
                    throw new RuntimeException("按件销售入库重量与数量不符，请检查件重");
                }
                break;
        }
    }
}
