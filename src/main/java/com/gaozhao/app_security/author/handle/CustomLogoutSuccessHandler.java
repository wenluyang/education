package com.gaozhao.app_security.author.handle;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaozhao.app_common.po.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出成功时调用的处理器
 * @author mars_Lv
 */
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //如果有认证信息，就返回退出成功的信息，如果没有分两种情况
        if (authentication!=null){
            //如果有认证信息，返回退出成功，
            Result result=new Result("OK","退出成功，已经注销当前token,请跳转到登录页!","");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(new ObjectMapper().writeValueAsString(result));


        }else {
            //如果没有认证信息，返回退出失败，退出时，当前的session信息无效
            Result result=new Result("OK","退出成功，当前token已经失效或者调用退出接口没有带上token(请带上token访问，注销当前token),如果是当前token失效，直接跳转到登录页！","");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        }
    }
}
