package com.eternal.design.web.interceptor;

import com.eternal.design.common.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();

        boolean hasLogin = httpServletRequest.getSession().getAttribute(Constants.SYSTEM_LOGIN_USER_KEY) != null;
        boolean isLoginUrl = "/login.htm".equals(url);

        if(!hasLogin && !isLoginUrl) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.htm");
            return false;
        }

        if(hasLogin && isLoginUrl) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
