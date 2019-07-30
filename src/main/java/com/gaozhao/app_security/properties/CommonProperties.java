package com.gaozhao.app_security.properties;

/**
 * 通用的属性配置
 * @author mars_lv
 */
public class CommonProperties {

    /**
     * 可通过的url
     * 多个的情况下，使用','分割
     */
    private String passableUrls;

    /**
     * sessionId对应的header的key的名字，在登录成功后，从头里面去取的key名字
     * 不配置的话，默认是"x-auth-token",可以通过配置文件设置，设置的属性为
     * es.security.common.authTokenName
     */
    private String authTokenName="x-auth-token";

    /**
     * 退出需要拦截的地址,我们默认退出的拦截url设置为"/common/logout"
     * 在配置文件中，可以自定义url,设置的属性为es.security.common.logoutUrl
     */
    private String logoutUrl="/common/logout";

    /**
     * httpSession过期时间，默认是30分钟
     */
    private int sessionTimeOutSecond=1800;

    /**
     * 是否开启密码salt加密方式，默认是不开启的
     */
    private boolean useSaltEncode=false;

    public String getPassableUrls() {
        return passableUrls;
    }

    public void setPassableUrls(String passableUrls) {
        this.passableUrls = passableUrls;
    }

    public String getAuthTokenName() {
        return authTokenName;
    }

    public void setAuthTokenName(String authTokenName) {
        this.authTokenName = authTokenName;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public int getSessionTimeOutSecond() {
        return sessionTimeOutSecond;
    }

    public void setSessionTimeOutSecond(int sessionTimeOutSecond) {
        this.sessionTimeOutSecond = sessionTimeOutSecond;
    }

    public boolean isUseSaltEncode() {
        return useSaltEncode;
    }

    public void setUseSaltEncode(boolean useSaltEncode) {
        this.useSaltEncode = useSaltEncode;
    }
}
