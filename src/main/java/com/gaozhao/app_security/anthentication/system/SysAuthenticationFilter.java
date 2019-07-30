package com.gaozhao.app_security.anthentication.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaozhao.app_security.properties.SecurityConstants;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * 后台登陆认证过滤器
 */
public class SysAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    /**
     * 请求参数中的用户名参数名
     */
    private String usernameParameter = SecurityConstants.DEFAULT_SIGN_IN_PARAMETER_USERNAME_SYS;

    /**
     * 请求参数中的密码参数名
     */
    private String passwordParameter = SecurityConstants.DEFAULT_SIGN_IN_PARAMETER_PASSWORD_SYS;

    /**
     * post请求的状态值
     */
    private boolean postOnly = true;

    // ~ constructors
    //=====================

    /**
     * 可以自定义拦截的匹配器，匹配器封装了url和请求的方法
     * @param matcher
     */
    public SysAuthenticationFilter(RequestMatcher matcher) {
        //调用父类构造器，设置认证拦截url
        super(matcher);
    }

    /**
     * 默认的构造器，默认拦截SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_SYS的属性值，
     * 方法为post请求
     */
    public SysAuthenticationFilter() {
        //调用父类构造器，设置认证拦截url
        super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_SYS, "POST"));
    }

    /**
     *
     * @param sysLoginUrl 后台登录拦截的url
     */
    public SysAuthenticationFilter(String sysLoginUrl) {
        //调用父类构造器，设置认证拦截url
        super(new AntPathRequestMatcher(sysLoginUrl, "POST"));
    }


    //~ Method
    //======================


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        //解析用户名和密码
        String username="";
        String password="";
        Map<String,String> paramMap=this.obtainParameter(request);
        if (paramMap!=null) {
            username = paramMap.get(usernameParameter);
            if (username==null){
                username="";
            }
            password = paramMap.get(passwordParameter);
            if (password==null){
                password="";
            }
        }

        username = username.trim();
        SysAuthenticationToken authRequest=new SysAuthenticationToken(username,password);
        this.setDetails(request, authRequest);
        //认证管理器找一个认证提供者来认证token,认证提供者里面包含UserDetailsService实例
        //这里面可以加入密码解析等功能
        //AuthenticationManager系统默认使用的是org.springframework.security.authentication.ProviderManager
        return this.getAuthenticationManager().authenticate(authRequest);

    }

    private Map<String,String> obtainParameter(HttpServletRequest request) {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
            StringBuilder sb = new StringBuilder();
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            //json字符串
            String params = sb.toString();
            //把这个json字符串解析成map
            ObjectMapper objectMapper=new ObjectMapper();
            return objectMapper.readValue(params,Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setDetails(HttpServletRequest request, SysAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }


    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public String getUsernameParameter() {
        return usernameParameter;
    }

    public void setUsernameParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.usernameParameter = usernameParameter;
    }

    public String getPasswordParameter() {
        return passwordParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
        this.passwordParameter = passwordParameter;
    }
}
