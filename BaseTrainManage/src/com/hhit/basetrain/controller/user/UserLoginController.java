/**
 * 
 */
package com.hhit.basetrain.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	@RequestMapping("/user/addUser")
	@ResponseBody
	public Result addUser(String username,String identity){
		
		Result result = userService.insertUser(username, identity);
		return result;
		
	}
	@RequestMapping("/user/deleteUser")
	@ResponseBody
	public Result deleteUser(String username){
		
		Result result = userService.deleteUser(username);
		return result;
		
	}
	@RequestMapping("/user/searchCollegeTeacherUserInfo")
	@ResponseBody
	public Result searchCollegeTeacherUserInfo(String username){
		
		Result result = userService.showCollegeTeacherUserInfoByNo(username);
		return result;
		
	}
	@RequestMapping("/user/searchStudentUserInfo")
	@ResponseBody
	public Result searchStudentUserInfo(String username){
		
		Result result = userService.showStudentUserInfoByNo(username);
		return result;
		
	}
}
