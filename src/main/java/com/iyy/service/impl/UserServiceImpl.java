package com.iyy.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.iyy.entity.User;
import com.iyy.mapper.UserMapperDao;
import com.iyy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/19 2:55 下午
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapperDao userMapperDao;


    @Override
    public int updateUserInfo(User user) {
        log.info("修改用户信息入参：{}", JSON.toJSONString(user));
        int rows = userMapperDao.updateByPrimaryKeySelective(user);
        log.info("修改用户信息结果：{}", rows);
        return rows;
    }

    @Override
    public int updateUserPassword(Integer userId, String userName, String userPassword, String newUserPassword) {
        log.info("修改用户密码参数：userId:{},userName:{}, newUserPassword:{}", userId, userName, newUserPassword);
        User user = userMapperDao.queryUserByUserNamePassword(userName, userPassword);
        int rows = 0;
        log.info("修改用户密码获取用户信息：{}", JSON.toJSONString(user));
        if(ObjectUtil.isNotEmpty(user)){
            User updateUser = new User();
            updateUser.setUserId(user.getUserId());
            updateUser.setUserPassword(user.getUserPassword());
            rows = userMapperDao.updateByPrimaryKeySelective(updateUser);
        }
        log.info("修改用户密码结果：{}", rows);
        return rows;
    }
}
