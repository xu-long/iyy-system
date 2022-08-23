package com.iyy.service;

import com.iyy.entity.User;

/**
 * 用户相关服务
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/8 2:28 下午
 */
public interface UserService {

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 修改用户密码
     * @param userId
     * @param userName
     * @param userPassword
     * @param newUserPassword
     * @return
     */
    int updateUserPassword(Integer userId, String userName, String userPassword, String newUserPassword);
}
