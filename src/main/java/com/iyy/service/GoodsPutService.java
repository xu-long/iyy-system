package com.iyy.service;

import com.iyy.service.params.GoodsPutParams;
import com.iyy.vo.ResultResponse;

/**
 * 商品上架service
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/29 11:14 上午
 */
public interface GoodsPutService {
    /**
     * 商品上架
     * @param goodsPutParams
     * @return
     * @throws Exception
     */
    public ResultResponse goodsPut(GoodsPutParams goodsPutParams) throws Exception;

    /**
     * 商品下架
     * @param goodsPutParams
     * @return
     */
    ResultResponse goodsUnPut(GoodsPutParams goodsPutParams);
}
