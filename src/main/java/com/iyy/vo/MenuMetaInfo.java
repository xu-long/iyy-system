package com.iyy.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 菜单信息
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/22 10:21 下午
 */
@Data
public class MenuMetaInfo implements Serializable {
    /**
     * 菜单标题
     */
    private String title;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 是否显示
     */
    private Boolean show;
}
