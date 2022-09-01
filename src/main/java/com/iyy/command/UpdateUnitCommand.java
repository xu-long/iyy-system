package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 修改单位入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 9:25 下午
 */
@Data
public class UpdateUnitCommand implements Serializable {
    /**
     * 单位ID
     */
    @NotNull(message = "单位ID不能为空！")
    private Integer unitId;

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
