package com.iyy.service;

import com.iyy.command.QueryUserMenuCommand;
import com.iyy.vo.UserMenuInfo;
import java.util.List;

/**
 * 用户菜单service
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/22 9:24 下午
 */
public interface MenuService {

    /**
     * 查询用户菜单信息
     * @param userId
     * @return
     */
    public List<UserMenuInfo> queryUserMenu(Integer userId);
}
