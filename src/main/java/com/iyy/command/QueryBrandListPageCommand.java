package com.iyy.command;

import lombok.Data;
import java.io.Serializable;

/**
 * 查询品牌list入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/1 3:03 下午
 */
@Data
public class QueryBrandListPageCommand extends BaseCommand implements Serializable {
    /**
     * 品牌名称
     */
    private String brandName;
}
