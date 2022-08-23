package com.iyy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.iyy.entity.User;
import com.iyy.mapper.UserMapperDao;
import com.iyy.service.LoginService;
import com.iyy.utils.tools.TokenUtil;
import com.iyy.vo.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/8 2:33 下午
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapperDao userMapperDao;
    
    
    @Override
    public LoginInfo login(User userParam) {
        log.info("loginUserParam:{}", JSON.toJSONString(userParam));
        LoginInfo loginInfo = null;
        User user = userMapperDao.queryUserByUserNamePassword(userParam.getUserName(), userParam.getUserPassword());
        if(ObjectUtil.isNotEmpty(user)){
            loginInfo = new LoginInfo();
            BeanUtil.copyProperties(user, loginInfo);
            loginInfo.setLoginDate(new Date());
            String token = TokenUtil.createToken(user);
            loginInfo.setToken(token);
            log.info("createToken:{}", token);
        }
        log.info("loginUserResult:{}", JSON.toJSONString(loginInfo));
        return loginInfo;
    }
}
