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
	/**
	 * 插入基地教师
	 * @param username
	 * @param password
	 * @param identity
	 * @return
	 */
	public Result InputInfo(String username,String password,String identity);
}
