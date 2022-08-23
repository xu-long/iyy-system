package com.iyy.service;

import com.github.pagehelper.PageInfo;
import com.iyy.vo.HandoverReceiverInfo;

/**
 * 交接记录service
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/16 2:24 下午
 */
public interface HandoverReceiverService {
    /**
     * 获取用户交接记录
     * @param userId
     * @return
     */
    public PageInfo<HandoverReceiverInfo> queryUserHandoverReceiverInfo(Integer userId, Integer pageNum, Integer pageSize);
}
