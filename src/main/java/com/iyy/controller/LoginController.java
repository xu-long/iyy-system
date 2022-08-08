package com.iyy.controller;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.User;
import com.iyy.service.LoginService;
import com.iyy.utils.exception.BussinessException;
import com.iyy.utils.tools.AesEncryptUtil;
import com.iyy.vo.LoginInfo;
import com.iyy.vo.UserLoginCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/4 11:27 上午
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登录
     * @param userLoginCommand
     * @return
     */
    @PostMapping("/login")
    public Map<String, Object> login(UserLoginCommand userLoginCommand) {
        Map<String, Object> map = new HashMap<>();
        try {

            log.info("{}用户登录请求", userLoginCommand.getUserName());
            User user = new User();
            user.setUserName(userLoginCommand.getUserName());
            user.setUserPassword(userLoginCommand.getPassWord());
            LoginInfo login = loginService.login(user);
            if(ObjectUtil.isNotEmpty(login)){
                String token = AesEncryptUtil.encrypt(JSON.toJSONString(login)).trim();
                Map<String, String> result = new HashMap<>();
                result.put("token", token);
                map.put("result", result);
                map.put("code", StatusConstant.successCode);
                map.put("msg", "登录成功！");
            }else{
                map.put("code", StatusConstant.failCode);
                map.put("msg", "登录失败！");
            }

        } catch (BussinessException e) {
            map.put("code", StatusConstant.failCode);
            map.put("msg", e.getMsg());
            e.printStackTrace();
        } catch (Exception e){
            map.put("code", StatusConstant.failCode);
            map.put("msg", e.getMessage());
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 登出
     * @param userInfo
     * @return
     */
    @PostMapping("/logout")
    public Map<String, Object> logout(UserLoginCommand userInfo) {
        Map<String, Object> map = new HashMap<>();
        try {
            System.out.println(JSON.toJSON(userInfo));

            map.put("code", "1");
            map.put("message", "退出成功");
        } catch (BussinessException e) {
            map.put("code", "0");
            map.put("msg", e.getMsg());
            e.printStackTrace();
        }
        return map;
    }

}
