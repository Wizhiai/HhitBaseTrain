/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Jiya
 * @date 2016-4-17下午01:38:53
 * TODO
 */
public interface UserService {

	public Result ckeckLogIn(String username,String password,String identity);
}
