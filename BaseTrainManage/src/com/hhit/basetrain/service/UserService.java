/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Jiya
 * @date 2016-4-17下午01:38:53
 */
public interface UserService {

	/**
	 * 用户登录检查
	 * @param username
	 * @param password
	 * @return
	 */
	public Result ckeckLogIn(String username,String password);
	/**
	 * 密码修改
	 * @param username
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public Result modifyPwd(String username,String oldPwd,String newPwd);
	 
	/** 添加用户
	 * @param username
	 * @param identity
	 * @return
	 */
	public Result insertUser(String username,String identity);
	/**
	 * 删除用户
	 * @param username
	 * @return
	 */
	public Result deleteUser(String username);
	/**
	 * 通过用户名查看学生信息
	 * @param username
	 * @return
	 */
	public Result showStudentUserInfoByNo(String username);
	/**
	 * 通过用户名查看教师信息
	 * @param username
	 * @return
	 */
	public Result showCollegeTeacherUserInfoByNo(String username);
	/**
	 * 重置密码
	 * @param username
	 * @return
	 */
	public Result resetUserPwdByNo(String username);
	
}
