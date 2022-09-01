package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 查询商品类别入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 7:32 下午
 */
@Data
public class QueryGoodsTypeListPageCommand extends BaseCommand implements Serializable {
    /**
     * 商品类别名称
     */
    @NotEmpty(message = "商品类别名称不能为空！")
    private String goodsTypeName;
}
