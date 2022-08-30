package com.iyy.vo;

import lombok.Data;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/29 11:15 上午
 */
@Data
public class ResultResponse {
    /**
     * 状态码（0：失败，1：成功）
     */
    private String code;

    /**
     * 消息串
     */
    private String message;
}
