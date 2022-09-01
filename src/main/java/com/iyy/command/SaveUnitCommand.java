package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 新增单位参数
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 9:01 下午
 */
@Data
public class SaveUnitCommand implements Serializable {
    /**
     * 单位类别code
     */
    @NotEmpty(message = "单位类别code不能为空！")
    private String unitTypeCode;

    /**
     * 单位名称
     */
    @NotEmpty(message = "单位名称不能为空！")
    private String unitName;

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空！")
    private Integer userId;
}
