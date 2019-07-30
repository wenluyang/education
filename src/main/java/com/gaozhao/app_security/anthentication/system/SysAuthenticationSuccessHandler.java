package com.gaozhao.app_security.anthentication.system;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaozhao.app_common.po.Result;
import com.gaozhao.app_pojo.domain.SysUser;
import com.gaozhao.app_security.common.RedisUtils;
import com.gaozhao.app_security.properties.SecurityConstants;
import com.gaozhao.app_system.api.SysLoginComponent;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * 后台认证成功处理器
 * @author mars_lv
 */
@Component
public class SysAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final Logger logger=LoggerFactory.getLogger(SysAuthenticationSuccessHandler.class);

    private RedisUtils redisUtils;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SysLoginComponent sysLoginComponent;

//    @Autowired
//    private SysLoginLogCustomService sysLoginLogCustomService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("===============后台登陆认证成功处理器执行==================");
        //从authentication令牌拿到已经认证的用户名，查这个用户名登录成功后返回的信息

//        String SUCCESS_STATUS = "OK";
//        Result result=new Result(SUCCESS_STATUS,"登录成功!",authentication);
        SysAuthenticationToken authenticationToken=null;
        if (authentication instanceof SysAuthenticationToken){
            authenticationToken= (SysAuthenticationToken) authentication;
        }

        UserDetails userDetails=null;
        if (authenticationToken!=null) {
            //我们在验证成功的时候，把userDetail封装到了用户的信息中
             userDetails = (UserDetails) authenticationToken.getPrincipal();
        }
        if (userDetails!=null) {
            Result result = sysLoginComponent.pcLogin(userDetails.getUsername());
            //如果账号是手机号，这里单独处理
            String userName=userDetails.getUsername();
            if (SysLoginComponent.isMatch(userDetails.getUsername())){
                //重新查一下用户账号
                SysUser sysUser =sysLoginComponent.pcAuthen(userDetails.getUsername());
                userName=sysUser.getUserAccount();
            }






//            sysLoginLogCustomService.insertSysLoginLog(0,userName,request);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(result));
        }

    }


}
