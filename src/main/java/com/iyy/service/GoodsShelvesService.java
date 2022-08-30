package com.iyy.service;

import com.iyy.entity.GoodsShelves;

import java.util.List;

/**
 * 货架service
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/28 10:14 下午
 */
public interface GoodsShelvesService {
    /**
     * 查询货架List
     * @param userId
     * @return
     */
    List<GoodsShelves> quyerGoodsShelvesList(Integer userId);
}
