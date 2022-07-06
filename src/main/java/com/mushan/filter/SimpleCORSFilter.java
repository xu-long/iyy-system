package com.mushan.filter;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/28 0:03
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SimpleCORSFilter implements Filter {
    private boolean isCross = false;

    private final List<String> allowedOrigin = Arrays.asList("*");

    @Override
    public void destroy() {
        isCross = false;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(isCross){
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            String origin = request.getHeader("Origin");

            response.setHeader("Access-Control-Allow-Origin", allowedOrigin.contains(origin) ?origin:"");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Allow-Headers",
                    "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
            response.setHeader("Access-Control-Max-Age", "0");
            response.setHeader("Access-Control-Allow-Credentials" , "true");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String isCrossStr = filterConfig.getInitParameter("isCross");
        isCross = isCrossStr.equals("true");
    }
}
