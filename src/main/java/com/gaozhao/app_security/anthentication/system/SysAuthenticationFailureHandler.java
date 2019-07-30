package com.gaozhao.app_security.anthentication.system;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaozhao.app_common.po.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * pc端认证失败回调的处理器
 * @author mars_lv
 */
@Component
public class SysAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final Logger logger=LoggerFactory.getLogger(SysAuthenticationFailureHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        logger.info("=================后台认证失败回调处理器调用================");
        String UNAUTHORIZED_STATUS = "ERROR";
        Result result=new Result(UNAUTHORIZED_STATUS,"对应的状态是401。登录失败,用户或者密码错误!",null);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
