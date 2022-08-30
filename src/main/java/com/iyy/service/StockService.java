package com.iyy.service;

import com.github.pagehelper.PageInfo;
import com.iyy.entity.Stock;
import com.iyy.service.params.QueryStockListParams;
import com.iyy.service.params.SaveStockParams;
import com.iyy.service.params.UpdateStockParams;
import com.iyy.vo.StockListInfo;

/**
 * 库存service
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/23 8:52 下午
 */
public interface StockService {
    /**
     * 查询库存列表
     * @param queryStockListParams
     * @return
     */
    public PageInfo<StockListInfo> queryStockList (QueryStockListParams queryStockListParams);

    /**
     * 新增库存
     * @param saveStockParams
     * @return
     * @throws Exception
     */
    public int saveStock(SaveStockParams saveStockParams) throws Exception;

    /**
     * 修改库存
     * @param updateStockParams
     * @return
     */
    int updateStock(UpdateStockParams updateStockParams) throws Exception;
}
