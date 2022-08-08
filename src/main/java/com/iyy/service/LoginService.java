package com.iyy.service;

import com.iyy.entity.User;
import com.iyy.vo.LoginInfo;

/**
 * 登录相关服务
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/8 2:29 下午
 */
public interface LoginService {
    public LoginInfo login(User user);
}
