/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-18下午03:15:52 用户实体类
 */
public class User {

	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	/** 身份 */
	private String identity;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Override
	public String toString() {
		return "User [identity=" + identity + ", password=" + password
				+ ", username=" + username + "]";
	}

}
