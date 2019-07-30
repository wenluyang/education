package com.gaozhao.app_system.api;


import com.gaozhao.app_common.po.Result;
import com.gaozhao.app_common.util.ResultUtil;
import com.gaozhao.app_pojo.domain.SysUser;
import com.gaozhao.app_service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * pc登录服务
 * @author mars_lv
 */
@Component
public class SysLoginComponent {


    @Autowired
    private SysUserService userS;



    /**
     * 正则：手机号（精确）
     * <p>移动：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198</p>
     * <p>联通：130、131、132、145、155、156、175、176、185、186、166</p>
     * <p>电信：133、153、173、177、180、181、189、199</p>
     * <p>全球星：1349</p>
     * <p>虚拟运营商：170</p>
     */
    private static final String REGEX_MOBILE_EXACT = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";


    /**
     *
     * @param phoneNum 需要匹配的手机号,在认证的时候也需要用到，因为用手机号的时候，用户名包装的是手机号
     * @return
     */
    public static boolean isMatch(String phoneNum){
        return StringUtils.isNotEmpty(phoneNum) && Pattern.matches(REGEX_MOBILE_EXACT,phoneNum);
    }

    /**
     * 由用户名查询用户的具体信息，这个用在springSecurity的DetailService的实现类中
     * 这个里面还需要封装这个用户的所有权限信息
     * @param userName 用户名
     * @return
     */
    public SysUser pcAuthen(String userName){
        SysUser su = new SysUser();
        if (isMatch(userName)){
            su.setPhone(Long.parseLong(userName));
        }else {
            su.setUserAccount(userName);
        }
        su.setDelStatus(0);
        return userS.selectSysUserByObj(su);
    }


    /**
     * 根据用户表的外键标识来查这个用户的所有的信息
     * @param fkCode
     * @return
     */
    public SysUser getUserByFkCode(String fkCode){
        SysUser su = new SysUser();
        su.setFkCode(Long.parseLong(fkCode));
        su.setDelStatus(0);
        return userS.selectSysUserByObj(su);
    }

    /**
     * 由用户名查询登录要返回所有的用户信息
     * @param userName 用户名
     * @return
     */
    public Result pcLogin(String userName){
        SysUser su = new SysUser();
        if (isMatch(userName)){
            su.setPhone(Long.parseLong(userName));
        }else {
            su.setUserAccount(userName);
        }
        su.setDelStatus(0);
        SysUser sysUser = userS.selectSysUserByObj(su);

        if (sysUser != null) {

            return ResultUtil.success();
        }
        return ResultUtil.error("用户名或密码错误");
    }




}
