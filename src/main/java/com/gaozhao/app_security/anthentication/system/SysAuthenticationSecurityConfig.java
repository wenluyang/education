package com.gaozhao.app_security.anthentication.system;


import com.gaozhao.app_security.properties.SecurityMainProperties;
import com.gaozhao.app_security.service.SysUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * 后台登陆认证配置
 * @author mars_lv
 */
@Component
public class SysAuthenticationSecurityConfig  extends SecurityConfigurerAdapter<DefaultSecurityFilterChain,HttpSecurity> {

    @Autowired
    private SysUserDetailService sysUserDetailService;

    @Autowired
    private SysAuthenticationSuccessHandler sysAuthenticationSuccessHandler;

    @Autowired
    private SysAuthenticationFailureHandler sysAuthenticationFailureHandler;

    @Autowired
    private SecurityMainProperties mainProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        //认证过滤器拦截url，支持配置文件配置
        SysAuthenticationFilter sysAuthenticationFilter=new SysAuthenticationFilter(mainProperties.getSys().getSignInUrl());
        //设置认证管理器，默认使用的实现类是ProviderManager
        sysAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        sysAuthenticationFilter.setAuthenticationSuccessHandler(sysAuthenticationSuccessHandler);
        sysAuthenticationFilter.setAuthenticationFailureHandler(sysAuthenticationFailureHandler);
        //设置过滤器需要提取的账号和密码字段名，支持配置文件配置
        sysAuthenticationFilter.setUsernameParameter(mainProperties.getSys().getSignInAccountParamName());
        sysAuthenticationFilter.setPasswordParameter(mainProperties.getSys().getSignInPwdParamName());

        SysAuthenticationProvider sysAuthenticationProvider=new SysAuthenticationProvider();
        sysAuthenticationProvider.setSysUserDetailService(sysUserDetailService);
        //设置加密salt开关
        sysAuthenticationProvider.setUseSalt(mainProperties.getCommon().isUseSaltEncode());


        http.authenticationProvider(sysAuthenticationProvider)
                .addFilterAfter(sysAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);

    }
}
