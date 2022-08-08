package com.iyy.mapper;

import com.iyy.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息Dao
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/8 2:16 下午
 */
public interface UserMapperDao extends UserMapper{
    /**
     * 根据用户名密码查询用户信息
     * @param userName
     * @param password
     * @return
     */
    public User queryUserByUserNamePassword(@Param("userName")String userName, @Param("password")String password);
}
