package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 新增商品类别入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 8:08 下午
 */
@Data
public class SaveGoodsTypeCommand implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    /**
     * 商品类别名称
     */
    @NotEmpty(message = "商品类别不能为空！")
    private String goodsTypeName;
}
