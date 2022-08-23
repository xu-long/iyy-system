package com.iyy.vo;

import lombok.Data;
import java.io.Serializable;

/**
 * 用户菜单信息
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/22 9:25 下午
 */
@Data
public class UserMenuInfo implements Serializable {
    /**
     * 菜单id
     */
    private Integer id;

    /**
     * 父菜单id
     */
    private Integer parentId;

    /**
     * 定向地址
     */
    private String redirect;

    /**
     * 菜单vue组件名称
     */
    private String component;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单信息
     */
    private MenuMetaInfo meta;
}
