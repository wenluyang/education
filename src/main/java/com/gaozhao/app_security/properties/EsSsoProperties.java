package com.gaozhao.app_security.properties;

/**
 * es统一门户使用的sso相关的属性配置
 * @author mars_lv
 */
public class EsSsoProperties {
    /**
     * 统一平台登录使用的请求url,设置了默认值
     */
    private String signInUrl=SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_ES_SSO;

    /**
     * 存令牌的字段名，设置了默认值
     */
    private String tokenName=SecurityConstants.DEFAULT_SIGN_IN_PARAMETER_ES_SSO;

    /**
     * 获取基础平台用户信息的api
     */
    private String userInforUrl="/uniapi/sso/getuser";

    /**
     * 使用ticket换取用户信息，不需要访问令牌
     */
    private String userInforUrlByTicket="/uniapi/sso/getmgruser";

    /**
     * 基础平台的域名
     */
    private String uniApiBaseUrl="http://172.20.20.100:8070";

    /**
     * 管理平台访问主页
     */
    private String manageLoginUrl="http://schoolcloud.ys100.com";

    /**
     * 排课系统回调地址,这个地址填第三方回调地址(晓羊排课回调地址)
     */
    private String arrangeCoursesCallbackUrl="http://127.0.0.1:8082/es/management/courses/arrange";


    /**
     * 排课系统回调地址,这个地址填第三方回调地址(万鹏排课回调地址)
     */
    private String arrangeCoursesOfWpCallbackUrl="";


    /**
     * 评测系统回调地址，这个地址填第三方回调地址
     */
    private String ceeEvaluatingCallbackUrl="";

    /**
     * 科大讯飞电子班牌的后台管理系统的回调地址
     */
    private String elePlateClassCallbackUrl="";

    /**
     * 获取用户的ticket并重定向到指定的回调地址上面
     */
    private String getTicketAndRedirectUrl="/uniapi/sso/pageLogin";

    public String getSignInUrl() {
        return signInUrl;
    }

    public void setSignInUrl(String signInUrl) {
        this.signInUrl = signInUrl;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }


    public String getUserInforUrl() {
        return userInforUrl;
    }

    public void setUserInforUrl(String userInforUrl) {
        this.userInforUrl = userInforUrl;
    }

    public String getUniApiBaseUrl() {
        return uniApiBaseUrl;
    }

    public void setUniApiBaseUrl(String uniApiBaseUrl) {
        this.uniApiBaseUrl = uniApiBaseUrl;
    }

    public String getManageLoginUrl() {
        return manageLoginUrl;
    }

    public void setManageLoginUrl(String manageLoginUrl) {
        this.manageLoginUrl = manageLoginUrl;
    }

    public String getArrangeCoursesCallbackUrl() {
        return arrangeCoursesCallbackUrl;
    }

    public void setArrangeCoursesCallbackUrl(String arrangeCoursesCallbackUrl) {
        this.arrangeCoursesCallbackUrl = arrangeCoursesCallbackUrl;
    }

    public String getGetTicketAndRedirectUrl() {
        return getTicketAndRedirectUrl;
    }

    public void setGetTicketAndRedirectUrl(String getTicketAndRedirectUrl) {
        this.getTicketAndRedirectUrl = getTicketAndRedirectUrl;
    }

    public String getUserInforUrlByTicket() {
        return userInforUrlByTicket;
    }

    public void setUserInforUrlByTicket(String userInforUrlByTicket) {
        this.userInforUrlByTicket = userInforUrlByTicket;
    }


    public String getCeeEvaluatingCallbackUrk() {
        return ceeEvaluatingCallbackUrl;
    }

    public void setCeeEvaluatingCallbackUrk(String ceeEvaluatingCallbackUrl) {
        this.ceeEvaluatingCallbackUrl = ceeEvaluatingCallbackUrl;
    }

    public String getCeeEvaluatingCallbackUrl() {
        return ceeEvaluatingCallbackUrl;
    }

    public void setCeeEvaluatingCallbackUrl(String ceeEvaluatingCallbackUrl) {
        this.ceeEvaluatingCallbackUrl = ceeEvaluatingCallbackUrl;
    }

    public String getElePlateClassCallbackUrl() {
        return elePlateClassCallbackUrl;
    }

    public void setElePlateClassCallbackUrl(String elePlateClassCallbackUrl) {
        this.elePlateClassCallbackUrl = elePlateClassCallbackUrl;
    }

    public String getArrangeCoursesOfWpCallbackUrl() {

        return arrangeCoursesOfWpCallbackUrl;
    }

    public void setArrangeCoursesOfWpCallbackUrl(String arrangeCoursesOfWpCallbackUrl) {
        this.arrangeCoursesOfWpCallbackUrl = arrangeCoursesOfWpCallbackUrl;
    }
}
