package com.iyy.mapper;

import com.iyy.entity.Stock;
import com.iyy.service.params.QueryStockListParams;
import com.iyy.vo.StockListInfo;
import java.util.List;

public interface StockMapperDao extends StockMapper{
    /**
     * 查询库存列表
     * @param queryStockListParams
     * @return
     */
    public List<StockListInfo> queryStockList(QueryStockListParams queryStockListParams);
}