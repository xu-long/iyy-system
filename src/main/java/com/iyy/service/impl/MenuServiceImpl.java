package com.iyy.service.impl;

import com.alibaba.fastjson.JSON;
import com.iyy.command.QueryUserMenuCommand;
import com.iyy.entity.Menu;
import com.iyy.mapper.MenuMapper;
import com.iyy.mapper.MenuMapperDao;
import com.iyy.service.MenuService;
import com.iyy.vo.MenuMetaInfo;
import com.iyy.vo.UserMenuInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单service实现
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/22 9:40 下午
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapperDao menuMapperDao;

    @Override
    public List<UserMenuInfo> queryUserMenu(Integer userId) {
        log.info("查询用户菜单信息入参:{}", userId);
        List<Menu> userMenus = menuMapperDao.queryUserMenu(userId);
        log.info("查询用户菜单信息size:{}", userMenus.size());
        List<UserMenuInfo> userMenuInfos = new ArrayList<>();
        userMenus.forEach(menu -> {
            UserMenuInfo userMenuInfo = new UserMenuInfo();
            userMenuInfo.setId(menu.getMenuId());
            userMenuInfo.setComponent(menu.getMenuComponent());
            userMenuInfo.setRedirect(menu.getMenuRedirect());
            userMenuInfo.setName(menu.getMenuName());
            userMenuInfo.setParentId(menu.getParentId());
            MenuMetaInfo menuMetaInfo = new MenuMetaInfo();
            menuMetaInfo.setShow(true);
            menuMetaInfo.setTitle(menu.getMenuTitle());
            menuMetaInfo.setIcon(menu.getMenuIcon());
            userMenuInfo.setMeta(menuMetaInfo);
            userMenuInfos.add(userMenuInfo);
        });
        log.info("查询用户{}菜单结果：{}", userId, JSON.toJSONString(userMenuInfos));
        return userMenuInfos;
    }
}
