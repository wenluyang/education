package com.gaozhao.app_security.author.handle;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaozhao.app_common.po.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拒绝访问使用的AuthenticationEntryPoint
 * @author mars_lv
 */
@Component
public class AccessForbiddenAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Log logger = LogFactory.getLog(AccessForbiddenAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String forbidden_Status = "Forbidden";
        Result result=new Result(forbidden_Status,"访问被拒绝,状态码为403,没有权限访问,收到这种消息，请跳转到登录页!","");
        response.setStatus(403);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
