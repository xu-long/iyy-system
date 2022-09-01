package com.iyy.command;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 查询单位List入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 9:36 下午
 */
@Data
public class QueryUnitListCommand extends BaseCommand implements Serializable {
    /**
     * 单位类型Code
     */
    @NotEmpty(message = "单位类型code不能为空！")
    private String unitTypeCode;

    /**
     * 单位名称
     */
    private String unitName;
}
