package com.gaozhao.app_security.config;


import com.gaozhao.app_security.anthentication.system.SysAuthenticationSecurityConfig;
import com.gaozhao.app_security.properties.SecurityMainProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * 配置测试
 * @author mars
 */
@Configuration
@EnableWebSecurity
@Order(1)
public class MainSecurityConf extends WebSecurityConfigurerAdapter {


    /**
     * 后台登陆认证配置
     */
    @Autowired
    private SysAuthenticationSecurityConfig sysAuthenticationSecurityConfig;

    /**
     * 自定义属性映射对象实例
     */
    @Autowired
    private SecurityMainProperties securityMainProperties;

    /**
     * 注册session的存储实现
     */
//    @Autowired
//    private SessionRegistry SessionRegistry;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    /**
     * 跨域相关配置
     */
    @Autowired
    private CorsConfigurationSource corsConfigurationSource;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .apply(sysAuthenticationSecurityConfig)
                .and()
                .authorizeRequests()
                .antMatchers(getPassableUrls())//这里面设置的url都不拦截
                .permitAll()
//                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .anyRequest()//剩下的所有请求都要认证
                .authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)//自定义拒绝访问处理器
                .authenticationEntryPoint(authenticationEntryPoint)//认证异常处理,主要处理403异常返回自定义内容，上面拒绝访问处理器没法处理
                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)//退出成功处理器
                .clearAuthentication(true)//清理掉上下文中的信息
                .invalidateHttpSession(true)//删除session仓库里的session信息，具体请看源代码
                .logoutUrl(securityMainProperties.getCommon().getLogoutUrl())
                .and()
                .sessionManagement()
                .maximumSessions(3)//最大支持两个session实例
//                .sessionRegistry(SessionRegistry)
                .and()
                .and()
                .cors().configurationSource(corsConfigurationSource)//跨域配置
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().disable();//关闭csrd


    }

    /**
     * 获取自定义属性中的不拦截的url地址
     * @return 返回的一个包含所有的不拦截的url地址的字符串数组
     */
    private String[] getPassableUrls(){
        if (securityMainProperties!=null){
            if(securityMainProperties.getCommon()!=null){
                String urls=securityMainProperties.getCommon().getPassableUrls();
                if (urls!=null){
                    if (urls.contains(",")){
                        return urls.split(",");
                    }else {
                        return new String[]{urls};
                    }
                }
            }
        }
        return new String[]{};
    }
}
