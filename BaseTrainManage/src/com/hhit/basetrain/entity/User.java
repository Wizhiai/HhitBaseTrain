/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-18下午03:15:52 
 * 用户实体类
 */
public class User {

	/** 用户名*/
	private String Uno;
	/** 密码 */
	private String Upwd;
	/** 身份*/
	private String Uidentity;
	public String getUno() {
		return Uno;
	}
	public void setUid(String uno) {
		Uno = uno;
	}
	public String getUpwd() {
		return Upwd;
	}
	public void setUpwd(String upwd) {
		Upwd = upwd;
	}
	public String getUidentity() {
		return Uidentity;
	}
	public void setUidentity(String uidentity) {
		Uidentity = uidentity;
	}
	@Override
	public String toString() {
		return "User [Uno=" + Uno + ", Uidentity=" + Uidentity + ", Upwd="
				+ Upwd + "]";
	}

}
