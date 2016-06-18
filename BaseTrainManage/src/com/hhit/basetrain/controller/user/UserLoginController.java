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
 * @date 2016-4-17下午01:35:10
 * 
 */
@Controller
public class UserLoginController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Result execute(String username,String password){
		
		Result result = userService.ckeckLogIn(username, password);
		return result;
		
	}
}
