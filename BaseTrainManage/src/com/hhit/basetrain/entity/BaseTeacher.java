/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-18t下午02:31:51
 *  基地教师实体类
 */
public class BaseTeacher {

	/** 职工号 */
	private String t_no;
	/** 姓名 */
	private String t_name;
	/** 性别 */
	private String t_sex;
	/** 联系方式 */
	private String t_phone;
	/** 基地号 */
	private Integer base_no;
	/** 职称 */
	private String t_profession;

	public String getT_no() {
		return t_no;
	}

	public void setT_no(String tNo) {
		t_no = tNo;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String tName) {
		t_name = tName;
	}

	public String getT_sex() {
		return t_sex;
	}

	public void setT_sex(String tSex) {
		t_sex = tSex;
	}

	public String getT_phone() {
		return t_phone;
	}

	public void setT_phone(String tPhone) {
		t_phone = tPhone;
	}

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public String getT_profession() {
		return t_profession;
	}

	public void setT_profession(String tProfession) {
		t_profession = tProfession;
	}

	@Override
	public String toString() {
		return "BaseTeacher [base_no=" + base_no + ", t_name=" + t_name
				+ ", t_no=" + t_no + ", t_phone=" + t_phone + ", t_profession="
				+ t_profession + ", t_sex=" + t_sex + "]";
	}

}
