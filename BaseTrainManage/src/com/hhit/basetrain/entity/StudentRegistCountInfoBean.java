/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-5-9t下午06:49:46
 * 
 */
public class StudentRegistCountInfoBean {
	private String stu_name;
	private String major;
	private String stu_class;
	private String base_name;
	private String cname;

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stuName) {
		stu_name = stuName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStu_class() {
		return stu_class;
	}

	public void setStu_class(String stuClass) {
		stu_class = stuClass;
	}

	public String getBase_name() {
		return base_name;
	}

	public void setBase_name(String baseName) {
		base_name = baseName;
	}
	

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "StudentRegistCountInfoBean [base_name=" + base_name
				+ ", cname=" + cname + ", major=" + major + ", stu_class="
				+ stu_class + ", stu_name=" + stu_name + "]";
	}

}
