package com.accp.interceptor;

import com.accp.domain.SysUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getSession().getId());
        //存储用户 查询显示字段
        request.getSession().setAttribute("user",new SysUser().setUserId(1));
        return true;
    }
}
