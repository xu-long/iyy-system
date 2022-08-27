package com.iyy.service.params;

import lombok.Data;
import java.io.Serializable;

/**
 * 查询库存列表入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/23 8:30 下午
 */
@Data
public class QueryStockListParams extends BaseParams implements Serializable {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 商品码
     */
    private String goodsSku;

    /**
     * 投放状态（默认全部，10：未投放 20：部分投放 30：已投放）
     */
    private Integer putStatus;

    /**
     * 入库时间
     */
    private String putinDate;

}
