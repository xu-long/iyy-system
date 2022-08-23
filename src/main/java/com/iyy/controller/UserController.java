package com.iyy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.iyy.command.QueryUserMenuCommand;
import com.iyy.command.UpdateUserInfoCommand;
import com.iyy.command.UpdateUserPasswordCommand;
import com.iyy.command.UserLoginCommand;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.User;
import com.iyy.service.MenuService;
import com.iyy.service.UserService;
import com.iyy.utils.tools.ValidationUtil;
import com.iyy.vo.UserMenuInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户controller
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/18 2:24 下午
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private MenuService menuService;

    /**
     * 修改用户信息
     * @param updateUserInfoCommand
     * @return
     */
    @PostMapping("/updateUserInfo")
    public Map<String, Object> updateUserInfo(UpdateUserInfoCommand updateUserInfoCommand) {
        Map<String, Object> map = new HashMap<>();
        ValidationUtil.validateBean(updateUserInfoCommand);
        User user = new User();
        BeanUtil.copyProperties(updateUserInfoCommand, user);
        try{
            int rows = userService.updateUserInfo(user);
            if(rows > 0){
                map.put("code", StatusConstant.successCode);
                map.put("message", "修改成功");
            }else{
                throw new RuntimeException("未查询到当前用户信息！");
            }

        }catch (Exception e){
            log.error("修改用户信息失败！", e);
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @PostMapping("/updateUserPassword")
    public Map<String, Object> updateUserPassword(UpdateUserPasswordCommand updateUserPasswordCommand) {
        Map<String, Object> map = new HashMap<>();
        ValidationUtil.validateBean(updateUserPasswordCommand);
        try{
            int rows = userService.updateUserPassword(updateUserPasswordCommand.getUserId(), updateUserPasswordCommand.getUserName(), updateUserPasswordCommand.getUserPassword(), updateUserPasswordCommand.getNewUserPassword());
            if(rows > 0){
                map.put("code", StatusConstant.successCode);
                map.put("message", "修改成功");
            }else{
                throw new RuntimeException("未查询到当前用户信息！");
            }

        }catch (Exception e){
            log.error("修改用户密码失败！", e);
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", e.getMessage());
        }
        return map;
    }

    @PostMapping("/queryUserMenu")
    public Map<String, Object> queryUserMenu(QueryUserMenuCommand queryUserMenuCommand){
        log.info("获取菜单路径");
        log.info("queryUserMenuCommand:{}", JSON.toJSONString(queryUserMenuCommand));
        ValidationUtil.validateBean(queryUserMenuCommand);
        //String menuStr = "{\"timestamp\": 1534844188679,\"status\": 200,\"message\": \"\",\"result\":[{\"name\": \"dashboard\",\"parentId\": 0,\"id\": 1,\"meta\": {\"icon\": \"dashboard\",\"title\": \"仪表盘\",\"show\": true},\"component\": \"RouteView\",\"redirect\": \"/dashboard/workplace\"},{\"name\": \"workplace\",\"parentId\": 1,\"id\": 7,\"meta\": {\"title\": \"工作台\",\"show\": true},\"component\": \"Workplace\"},{\"name\": \"account\",\"parentId\": 0,\"id\": 10028,\"meta\": {\"title\": \"个人页\",\"icon\": \"user\",\"show\": true},\"redirect\": \"/account/center\",\"component\": \"RouteView\"},{\"name\": \"center\",\"parentId\": 10028,\"id\": 10029,\"meta\": {\"title\": \"个人中心\",\"show\": true},\"component\": \"AccountCenter\"},{\"name\": \"settings\",\"parentId\": 10028,\"id\": 10030,\"meta\": {\"title\": \"个人设置\",\"hideHeader\": true,\"hideChildren\": true,\"show\": true},\"redirect\": \"/account/settings/basic\",\"component\": \"AccountSettings\"},{\"name\": \"BasicSettings\",\"path\": \"/account/settings/basic\",\"parentId\": 10030,\"id\": 10031,\"meta\": {\"title\": \"基本设置\",\"show\": false},\"component\": \"BasicSetting\"},{\"name\": \"SecuritySettings\",\"path\": \"/account/settings/security\",\"parentId\": 10030,\"id\": 10032,\"meta\": {\"title\": \"安全设置\",\"show\": false},\"component\": \"SecuritySettings\"}]}";
        //JSONObject jsonObject = JSONUtil.parseObj(menuStr);
        //Map map1 = jsonObject.toBean(Map.class);
        List<UserMenuInfo> userMenuInfos = menuService.queryUserMenu(queryUserMenuCommand.getUserId());
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", System.currentTimeMillis());
        map.put("status", 200);
        map.put("message", "");
        map.put("result", userMenuInfos);
        log.info("queryUserMenuController:{}", JSON.toJSONString(map));
        return map;
    }
}
