package com.iyy.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 查询货架入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/28 10:11 下午
 */
@Data
public class QueryGoodsShelvesListCommand implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Integer userId;
}
