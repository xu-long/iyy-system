package com.iyy.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.iyy.entity.GoodsShelves;
import com.iyy.entity.User;
import com.iyy.mapper.GoodsShelvesMapperDao;
import com.iyy.mapper.UserMapperDao;
import com.iyy.service.GoodsShelvesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 货架serviceImpl
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/28 10:14 下午
 */
@Service
@Slf4j
public class GoodsShelvesServiceImpl implements GoodsShelvesService {
    @Resource
    private UserMapperDao userMapperDao;
    @Resource
    private GoodsShelvesMapperDao goodsShelvesMapperDao;

    @Override
    public List<GoodsShelves> quyerGoodsShelvesList(Integer userId) {
        log.info("查询货架信息入参：{}", userId);
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            throw new RuntimeException("未找到用户信息");
        }
        List<GoodsShelves> goodsShelves = goodsShelvesMapperDao.queryGoodsShelvesList(user.getShopId());
        log.info("查询货架信息结果：{}", goodsShelves.size());
        return goodsShelves;
    }
}
