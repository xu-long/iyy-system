package com.iyy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iyy.entity.HandoverReceiver;
import com.iyy.mapper.HandoverReceiverMapper;
import com.iyy.mapper.HandoverReceiverMapperDao;
import com.iyy.service.HandoverReceiverService;
import com.iyy.vo.HandoverReceiverInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/16 2:41 下午
 */
@Service
@Slf4j
public class HandoverReceiverServiceImpl implements HandoverReceiverService {

    @Resource
    private HandoverReceiverMapperDao handoverReceiverMapperDao;


    @Override
    public PageInfo<HandoverReceiverInfo> queryUserHandoverReceiverInfo(Integer userId, Integer pageNum, Integer pageSize) {
        log.info("queryUserHandoverReceiverInfo-param:userId:{},pageNum:{},pageSize:{}", userId, pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<HandoverReceiverInfo> handoverReceiverInfoPageInfo = handoverReceiverMapperDao.queryUserHandoverReceiverInfo(userId);
        log.info("queryUserHandoverReceiverInfo-size:{}", handoverReceiverInfoPageInfo.size());
        return  new PageInfo<>(handoverReceiverInfoPageInfo);
    }
}
