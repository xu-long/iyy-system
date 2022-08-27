package com.iyy.service.params;

import lombok.Data;
import java.io.Serializable;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/23 8:32 下午
 */
@Data
public class BaseParams implements Serializable {
    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;
}
