package com.iyy.mapper;

import com.iyy.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/22 9:05 下午
 */
public interface MenuMapperDao extends MenuMapper{
    /**
     * 查询用户按钮
     * @param userId
     * @return
     */
    public List<Menu> queryUserMenu(@Param("userId") Integer userId);
}
