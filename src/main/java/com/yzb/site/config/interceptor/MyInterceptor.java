package com.yzb.site.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 管理后台身份认证拦截器
 */

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.startsWith("/admin") && null==request.getSession().getAttribute("adminId")){
            response.sendRedirect(request.getContextPath()+"/admin/login");
            return false;
        }
        else if(uri.startsWith("/user") && null==request.getSession().getAttribute("userId")){
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }
        else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
