/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-18t下午02:36:13 
 * 学校教师实体类
 */
public class CollegeTeacher {

	/** 职工号 */
	private String ct_no;
	/** 姓名 */
	private String ct_name;
	/** 出生日期 */
	private String ct_birthday;
	/** 性别 */
	private String ct_sex;
	/** 学院号 */
	private String academy_no;
	/** 联系方式 */
	private String ct_phone;
	/** 职称 */
	private String ct_profession;

	public String getCt_no() {
		return ct_no;
	}

	public void setCt_no(String ctNo) {
		ct_no = ctNo;
	}

	public String getCt_name() {
		return ct_name;
	}

	public void setCt_name(String ctName) {
		ct_name = ctName;
	}

	public String getCt_birthday() {
		return ct_birthday;
	}

	public void setCt_birthday(String ctBirthday) {
		ct_birthday = ctBirthday;
	}

	public String getCt_sex() {
		return ct_sex;
	}

	public void setCt_sex(String ctSex) {
		ct_sex = ctSex;
	}

	public String getAcademy_no() {
		return academy_no;
	}

	public void setAcademy_no(String academyNo) {
		academy_no = academyNo;
	}

	public String getCt_phone() {
		return ct_phone;
	}

	public void setCt_phone(String ctPhone) {
		ct_phone = ctPhone;
	}

	public String getCt_profession() {
		return ct_profession;
	}

	public void setCt_profession(String ctProfession) {
		ct_profession = ctProfession;
	}

	@Override
	public String toString() {
		return "CollegeTeacher [academy_no=" + academy_no + ", ct_birthday="
				+ ct_birthday + ", ct_name=" + ct_name + ", ct_no=" + ct_no
				+ ", ct_phone=" + ct_phone + ", ct_profession=" + ct_profession
				+ ", ct_sex=" + ct_sex + "]";
	}

}
