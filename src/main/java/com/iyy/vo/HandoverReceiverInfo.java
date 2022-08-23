package com.iyy.vo;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 交接记录信息
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/16 2:35 下午
 */
@Data
public class HandoverReceiverInfo implements Serializable {
    /**
     * 记录ID
     */
    private Integer recordId;

    /**
     * 交接人
     */
    private String handoverUser;

    /**
     * 接收人
     */
    private String receiverUser;

    /**
     * 交接金额
     */
    private BigDecimal handoverAmount;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createDate;
}
