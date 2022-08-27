package com.iyy.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/23 8:20 下午
 */
@Data
public class QueryStockListCommand extends BaseCommand{
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
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
