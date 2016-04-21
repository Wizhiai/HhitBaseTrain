/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-18t上午09:33:20
 *  管理员实体类
 */
public class Admin {

	/** 职工号 */
	private String no;
	/** 姓名 */
	private String name;
	/** 联系方式 */
	private String phone;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", no=" + no + ", phone=" + phone + "]";
	}
}
