/**
 * 
 */
package com.hhit.basetrain.dao;

import com.hhit.basetrain.entity.User;

/**
 * @author Jiya
 * @date 2016-4-20tÏÂÎç02:59:52
 */
public interface UserDao {

	public User findByName(String username);
}
