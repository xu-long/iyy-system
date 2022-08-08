package com.iyy.constant;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/5 5:00 下午
 */
@Data
public class StatusConstant implements Serializable {
    /**
     * 成功
     */
    public static final String successCode = "1";

    /**
     * 失败
     */
    public static final String failCode = "0";
}
