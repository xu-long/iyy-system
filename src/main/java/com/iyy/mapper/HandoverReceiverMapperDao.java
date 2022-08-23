package com.iyy.mapper;

import com.iyy.vo.HandoverReceiverInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/16 2:42 下午
 */
public interface HandoverReceiverMapperDao extends HandoverReceiverMapper{
    List<HandoverReceiverInfo> queryUserHandoverReceiverInfo(@Param("userId") Integer userId);
}
