package com.iyy.filter;

import com.alibaba.fastjson.JSON;
import com.iyy.utils.tools.TokenUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 权限验证
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/5 3:31 下午
 */
@Slf4j
public class PermissionCheck implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        List<String> noCheckUris = new ArrayList<>();
        noCheckUris.add("/");
        noCheckUris.add("/login/logout");
        noCheckUris.add("/login/login");
        boolean bool = false;
        if(noCheckUris.contains(request.getRequestURI())){
            bool = true;
        }else {
            log.info("请求路径：{}", JSON.toJSONString(request.getRequestURI()));
            //获取token 验证登录
            String accessToken = request.getHeader("Access-Token");
            log.info("过滤器Access-Token:{}", JSON.toJSONString(accessToken));
            bool =TokenUtil.checkToken(accessToken);
        }
        if(bool){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            response.setStatus(404);
        }
    }

    @Override
    public void destroy() {

    }
}
