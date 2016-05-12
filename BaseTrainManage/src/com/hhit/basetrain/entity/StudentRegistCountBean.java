/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-5-9t下午06:49:46
 * 
 */
public class StudentRegistCountBean {
	private String major;
	private String base_name;
	private Integer num;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getBase_name() {
		return base_name;
	}

	public void setBase_name(String baseName) {
		base_name = baseName;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "StudentRegistCountBean [base_name=" + base_name + ", major="
				+ major + ", num=" + num + "]";
	}

}
