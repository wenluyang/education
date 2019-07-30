package com.gaozhao.app_security.author.handle;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaozhao.app_common.po.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义拒绝访问处理器
 * @author mars_lv
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (!response.isCommitted()) {
            String forbidden_Status = "Forbidden";
            Result result=new Result(forbidden_Status,"访问被拒绝,没有权限访问,收到这种消息，请跳转到登录页!","");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        }
    }
}
