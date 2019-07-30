package com.gaozhao.app_security.properties;

/**
 * 后台环境配置项目
 */
public class SysProperties {


    /**
     * session过期时间，默认是30分钟
     */
    private Integer sessionExpireTime=30*60;

    /**
     * "记住我" 功能的有效时间，默认1小时
     */
    private Integer rememberMeSecond=3600;

    /**+++++++
     * 登录访问的url
     */
    private String signInUrl=SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_SYS;

    /**
     * 登录请求中，账号对应参数名
     */
    private String signInAccountParamName=SecurityConstants.DEFAULT_SIGN_IN_PARAMETER_USERNAME_SYS;

    /**
     * 登录请求中，密码对应的参数名
     */
    private String signInPwdParamName=SecurityConstants.DEFAULT_SIGN_IN_PARAMETER_PASSWORD_SYS;

    /**
     * 登录成功时跳转的url
     */
    private String signInSuccessUrl;

    /**
     * 退出成功时跳转的url
     */
    private String signOutSuccessUrl;


    public Integer getSessionExpireTime() {
        return sessionExpireTime;
    }

    public void setSessionExpireTime(Integer sessionExpireTime) {
        this.sessionExpireTime = sessionExpireTime;
    }

    public Integer getRememberMeSecond() {
        return rememberMeSecond;
    }

    public void setRememberMeSecond(Integer rememberMeSecond) {
        this.rememberMeSecond = rememberMeSecond;
    }

    public String getSignInUrl() {
        return signInUrl;
    }

    public void setSignInUrl(String signInUrl) {
        this.signInUrl = signInUrl;
    }

    public String getSignInSuccessUrl() {
        return signInSuccessUrl;
    }

    public void setSignInSuccessUrl(String signInSuccessUrl) {
        this.signInSuccessUrl = signInSuccessUrl;
    }

    public String getSignOutSuccessUrl() {
        return signOutSuccessUrl;
    }

    public void setSignOutSuccessUrl(String signOutSuccessUrl) {
        this.signOutSuccessUrl = signOutSuccessUrl;
    }

    public String getSignInAccountParamName() {
        return signInAccountParamName;
    }

    public void setSignInAccountParamName(String signInAccountParamName) {
        this.signInAccountParamName = signInAccountParamName;
    }

    public String getSignInPwdParamName() {
        return signInPwdParamName;
    }

    public void setSignInPwdParamName(String signInPwdParamName) {
        this.signInPwdParamName = signInPwdParamName;
    }
}
