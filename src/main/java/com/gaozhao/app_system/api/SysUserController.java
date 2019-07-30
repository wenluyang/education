package com.gaozhao.app_system.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaozhao.app_common.po.Result;
import com.gaozhao.app_common.util.Assist;
import com.gaozhao.app_common.util.ResultUtil;
import com.gaozhao.app_common.util.SnowFlake;
import com.gaozhao.app_pojo.domain.SysUser;
import com.gaozhao.app_service.SysUserService;
import com.gaozhao.app_system.vo.SignUpForm;

import io.swagger.annotations.Api;

/**
 * 后台用户管理API
 * @author Administrator
 *
 */

@Api(tags = "后台用户管理api")
@RestController
public class SysUserController {

	@Autowired
	private SysUserService userService;
	
	
	@PostMapping("/sys/signup")
	public Result signUp(@RequestBody SignUpForm form) {
		String userAccount = form.getUserAccount();
		Assist assist = new Assist();
		assist.setRequires(Assist.andEq("user_account", userAccount));
		
		List<SysUser> selectSysUser = userService.selectSysUser(assist);
		if(selectSysUser!=null && selectSysUser.size()>0) {
			return ResultUtil.error("该管理员已经存在，请更换一个名字");
		}
		
		SysUser sUser =new SysUser();
		sUser.setUserAccount(userAccount);
		sUser.setPwd(new BCryptPasswordEncoder().encode(form.getPwd()+"c9e27455-b73c-4c7c-982a-2f56be414d3b"));
		sUser.setDelStatus(0);
		sUser.setFkCode(SnowFlake.getId());
		sUser.setUserFkCode(SnowFlake.getId());
		sUser.setCreatorFkCode(SnowFlake.getId());
		sUser.setIdentity(4);
		
		sUser.setCreateTime(new Date());
		sUser.setUpdateTime(new Date());
		
		
		int insertNonEmptySysUser = userService.insertNonEmptySysUser(sUser);
		
		return insertNonEmptySysUser>0?ResultUtil.success():ResultUtil.error("管理员账号添加失败");
	}



	
	
}
