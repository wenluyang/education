package com.gaozhao.app_security.anthentication.system;

import com.gaozhao.app_security.common.CustomMd5PasswordEncoder;
import com.gaozhao.app_security.pojo.SysCustomUserDetails;
import com.gaozhao.app_security.service.SysUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SysAuthenticationProvider implements AuthenticationProvider {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	/**
	 * 是否启用密码salt的密码加密方式,默认不启用
	 */
	private boolean useSalt = false;

	@Autowired
	private SysUserDetailService sysUserDetailService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		SysAuthenticationToken authenticationToken = (SysAuthenticationToken) authentication;
		// 获取登录的的用户信息
		UserDetails userDetails = sysUserDetailService.loadUserByUsername((String) authenticationToken.getPrincipal());

		if (userDetails == null) {
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}
		
		//这里向下转型一下，子类包含了密码salt
        SysCustomUserDetails sysCustomUserDetails;
        if (userDetails instanceof SysCustomUserDetails){
			sysCustomUserDetails= (SysCustomUserDetails) userDetails;
        }else {
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }

        logger.info("用户输入的密码"+(String) authentication.getCredentials());
        logger.info("数据库里的密码"+sysCustomUserDetails.getPassword());

        //用户输入的密码与salt链接一下
		String sourcePassword=(String) authentication.getCredentials()+sysCustomUserDetails.getSalt();

        //这里面还需要验证密码，密码验证这里只做一个简单的比较，后面加上密码加密比对
        boolean status=new BCryptPasswordEncoder().matches(sourcePassword,sysCustomUserDetails.getPassword());


        if (!status){
            throw new InternalAuthenticationServiceException("用户密码错误");
        }

		//验证成功，我们返回重新封装的token，这时候用户信息就是一个完整的信息，就不是只包含有用户名了
		//通过调用这个构造器会调父类的set方法将认证状态设置成true,以为着这个token就是认证通过的
		SysAuthenticationToken authenticationResult=new SysAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		authenticationResult.setDetails(authenticationToken.getDetails());

		return authenticationResult;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return SysAuthenticationToken.class.isAssignableFrom(authentication);
	}

	/**
	 * 密码比对，这里涉及到密码加密的方式
	 * @param sourcePwd 从前端输入的密码
	 * @param targetPwd 数据库存的加密后的密码
	 * @param salt 加密用的密码salt
	 * @return
	 */
	private boolean comparePwd(String sourcePwd,String targetPwd,String salt){
		if (useSalt){
			//使用slat加密，需要在生成账号的时候把密码使用salt加密一遍
			return CustomMd5PasswordEncoder.isPasswordValid(targetPwd,sourcePwd,salt);
		}else {
			//如果不使用密码salt加密
			return sourcePwd.equals(targetPwd);
		}
	}

	public void setUseSalt(boolean useSalt) {
		this.useSalt = useSalt;
	}

	public void setSysUserDetailService(SysUserDetailService sysUserDetailService) {
		this.sysUserDetailService = sysUserDetailService;
	}
}
