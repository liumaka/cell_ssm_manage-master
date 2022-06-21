package com.qfedu.demo.interceptor;

import com.qfedu.demo.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的URL
//        String requestURI=request.getRequestURI();
//        HttpSession session=request.getSession();
        //获取用户的信息
        Object userInfo = request.getSession().getAttribute("loginName");
        if (userInfo == null) { //表示未登录就想进入系统
            //直接重定向到登录界面
            String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/login";
            response.sendRedirect(serverPath);
            return false;
        } else {
            //登陆成功，不拦截
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("跳转后拦截");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("渲染后拦截");
    }

}
