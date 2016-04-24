/**
 * 
 */
package com.hhit.basetrain.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.UserService;

/**
 * @author Jiya
 * @date 2016-4-23t下午03:06:33
 * 密码修改
 */
@Controller
public class PwdModifyController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/mofifyPwd")
	@ResponseBody
	public Result exectue(String username,String oldPwd,String newPwd){
		
		Result result = userService.modifyPwd(username, oldPwd, newPwd);
		return result;
	}
}
