package com.iyy.controller;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.User;
import com.iyy.service.LoginService;
import com.iyy.utils.exception.BussinessException;
import com.iyy.vo.LoginInfo;
import com.iyy.command.UserLoginCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
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
                Map<String, Object> result = new HashMap<>();
                result.put("token", login.getToken());
                result.put("loginUser", login);
                map.put("result", result);
                map.put("code", StatusConstant.successCode);
                map.put("message", "登录成功！");
            }else{
                map.put("code", StatusConstant.failCode);
                map.put("message", "登录失败！");
            }

        } catch (BussinessException e) {
            map.put("code", StatusConstant.failCode);
            map.put("message", e.getMsg());
            e.printStackTrace();
        } catch (Exception e){
            map.put("code", StatusConstant.failCode);
            map.put("message", e.getMessage());
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
    public Map<String, Object> logout(ServletRequest servletRequest) {
        Map<String, Object> map = new HashMap<>();
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            //获取token 验证登录
            String accessToken = request.getHeader("Access-Token");
            System.out.println(JSON.toJSON(accessToken));

            map.put("code", "1");
            map.put("message", "退出成功");
        } catch (BussinessException e) {
            map.put("code", "0");
            map.put("msg", e.getMsg());
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 验证登录失败
     * @param servletRequest
     * @return
     */
    @PostMapping("/checkTokenFailPost")
    public Map<String, Object> checkTokenFailPost(ServletRequest servletRequest) {
        log.info("进入转发方法");
        Map<String, Object> map = new HashMap<>();
        map.put("code", "10000");
        map.put("message", "验证登录失败");
        return map;
    }

    /**
     * 验证登录失败
     * @param servletRequest
     * @return
     */
    @GetMapping("/checkTokenFailGet")
    public Map<String, Object> checkTokenFailGet(ServletRequest servletRequest) {
        log.info("进入转发方法");
        Map<String, Object> map = new HashMap<>();
        map.put("code", "10000");
        map.put("message", "验证登录失败");
        return map;
    }

}
