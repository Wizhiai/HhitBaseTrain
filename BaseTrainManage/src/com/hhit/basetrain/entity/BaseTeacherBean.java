/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Mayu
 * @date 2016-5-20t上午10:39:06
 * TODO
 */
public class BaseTeacherBean {
	/** 职工号 */
	private String t_no;
	/** 姓名 */
	private String t_name;
	/** 性别 */
	private String t_sex;
	/** 联系方式 */
	private String t_phone;
	/** 基地名称 */
	private String base_name;
	/** 职称 */
	private String t_profession;
	/**
	 * @return the t_no
	 */
	public String getT_no() {
		return t_no;
	}
	/**
	 * @param tNo the t_no to set
	 */
	public void setT_no(String tNo) {
		t_no = tNo;
	}
	/**
	 * @return the t_name
	 */
	public String getT_name() {
		return t_name;
	}
	/**
	 * @param tName the t_name to set
	 */
	public void setT_name(String tName) {
		t_name = tName;
	}
	/**
	 * @return the t_sex
	 */
	public String getT_sex() {
		return t_sex;
	}
	/**
	 * @param tSex the t_sex to set
	 */
	public void setT_sex(String tSex) {
		t_sex = tSex;
	}
	/**
	 * @return the t_phone
	 */
	public String getT_phone() {
		return t_phone;
	}
	/**
	 * @param tPhone the t_phone to set
	 */
	public void setT_phone(String tPhone) {
		t_phone = tPhone;
	}
	/**
	 * @return the base_name
	 */
	public String getBase_name() {
		return base_name;
	}
	/**
	 * @param baseName the base_name to set
	 */
	public void setBase_name(String baseName) {
		base_name = baseName;
	}
	/**
	 * @return the t_profession
	 */
	public String getT_profession() {
		return t_profession;
	}
	/**
	 * @param tProfession the t_profession to set
	 */
	public void setT_profession(String tProfession) {
		t_profession = tProfession;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseTeacherBean [base_name=" + base_name + ", t_name=" + t_name
				+ ", t_no=" + t_no + ", t_phone=" + t_phone + ", t_profession="
				+ t_profession + ", t_sex=" + t_sex + "]";
	}
	
}
