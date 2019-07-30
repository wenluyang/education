package com.gaozhao.app_security.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 自定义的加密方式
 */
public class CustomMd5PasswordEncoder {

    /**
     *
     * @param sourcePwd 用户输入的密码
     * @param salt 加密盐值
     * @return
     */
    public static  String enPassword(String sourcePwd,String salt){
        BCryptPasswordEncoder bcry= new BCryptPasswordEncoder();
        return bcry.encode(sourcePwd+salt);
    }

    /**
     *
     * @param targetPwd 加密后的密码串
     * @param sourcePwd 用户输入的密码
     * @param salt 加密盐值
     * @return
     */
    public static boolean isPasswordValid(String targetPwd, String sourcePwd, String salt) {
        String s = enPassword(sourcePwd, salt);
        return  targetPwd==s?true:false;
    }
}
