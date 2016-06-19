/**
 * 
 */
package com.hhit.basetrain.service;

import java.util.List;

import com.hhit.basetrain.entity.BaseBean;
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
	
	public Result findAllUser() ;
	public Result findByNames(String userName) ;
	
	/**
	 * @param type
	 * @return
	 */
	public Result findByType(String type);
}
