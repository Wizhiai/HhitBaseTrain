/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-18t下午02:53:22 
 * 学生实体类
 */
public class Student {

	/** 学号 */
	private String stuno;
	/** 姓名 */
	private String stu_name;
	/** 性别 */
	private String stu_sex;
	/** 班级 */
	private String stu_class;
	/** 专业 */
	private String marjor;
	/** 联系方式 */
	private String phone;
	/** 入学年份 */
	private Integer enter_year;
	/** 出生日期 */
	private String birthday;
	/** 家庭住址 */
	private String address;

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stuName) {
		stu_name = stuName;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stuSex) {
		stu_sex = stuSex;
	}

	public String getStu_class() {
		return stu_class;
	}

	public void setStu_class(String stuClass) {
		stu_class = stuClass;
	}

	public String getMarjor() {
		return marjor;
	}

	public void setMarjor(String marjor) {
		this.marjor = marjor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getEnter_year() {
		return enter_year;
	}

	public void setEnter_year(Integer enterYear) {
		enter_year = enterYear;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [address=" + address + ", birthday=" + birthday
				+ ", enter_year=" + enter_year + ", marjor=" + marjor
				+ ", phone=" + phone + ", stu_class=" + stu_class
				+ ", stu_name=" + stu_name + ", stu_sex=" + stu_sex
				+ ", stuno=" + stuno + "]";
	}

}
