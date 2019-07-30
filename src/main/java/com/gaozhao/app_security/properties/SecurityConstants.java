package com.gaozhao.app_security.properties;

public interface SecurityConstants {


    /**
     * 后台登录默认的请求处理的url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_SYS="/sys/login";

    /**
     *后台登录默认使用的账号参数名
     */
    String DEFAULT_SIGN_IN_PARAMETER_USERNAME_SYS="userAccount";

    /**
     * 后台登录默认使用的密码参数名
     */
    String DEFAULT_SIGN_IN_PARAMETER_PASSWORD_SYS="pwd";

    //======================================mobile config param

    /**
     * pc端登录默认的请求处理的url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_PC="/pc/login";

    /**
     * pc端默认使用的账号参数名
     */
    String DEFAULT_SIGN_IN_PARAMETER_USERNAME_PC="userAccount";

    /**
     * pc端默认使用的密码参数名
     */
    String DEFAULT_SIGN_IN_PARAMETER_PASSWORD_PC="pwd";

    //======================================mobile config param
    /**
     * 移动端登录的默认请求处理的url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_MB="/mb/login";

    /**
     * 移动端登录默认的账号参数名
     */
    String DEFAULT_SIGN_IN_PARAMETER_USERNAME_MB="userAccount";

    /**
     * 默认的移动端登录的密码参数名
     */
    String DEFAULT_SIGN_IN_PARAMETER_PASSWORD_MB="passWord";

    //=======================================es-sso config param
    /**
     * 统一登录默认拦截的地址
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_ES_SSO="/es/sso/login";

    /**
     * 统一登录使用的参数名
     */
    String DEFAULT_SIGN_IN_PARAMETER_ES_SSO="v";

    /**
     * token的key
     */
    String  COOKIE_KEY_TOKEN_ID="kid";

    /**
     * 用户的加密字符串的key
     */
    String  COOKIE_KEY_USER_ID="encact";

    /**
     * 回调地址的key
     */
    String REQUEST_KEY_CALLBACK_URL="backUrl";

}
