package com.gaozhao.app_security.service;

import com.gaozhao.app_security.pojo.SysCustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gaozhao.app_pojo.domain.SysUser;
import com.gaozhao.app_service.SysUserService;
import org.springframework.stereotype.Component;


@Component
public class SysUserDetailService implements UserDetailsService {

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SysUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.info("==用户提交的用户名=="+username);
		//检查用户名是否在数据库中存在
		SysUser sUser = new SysUser();
		sUser.setUserAccount(username);
		sUser.setDelStatus(0);


		
		SysUser selectSysUserByObj = userService.selectSysUserByObj(sUser);

		logger.info(selectSysUserByObj.toString());
		return new SysCustomUserDetails(username, selectSysUserByObj.getPwd(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"),selectSysUserByObj.getSalt());
	}

}
