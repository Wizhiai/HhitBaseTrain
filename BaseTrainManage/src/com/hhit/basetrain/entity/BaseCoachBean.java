/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-29t下午03:09:49 基地教师与辅导队伍
 */
public class BaseCoachBean {
	/** 基地编号 */
	private Integer base_no;
	/** 学院指导教师 */
	private Integer school_teacher;
	/** 企业指导教师 */
	private Integer company_teacher;

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public Integer getSchool_teacher() {
		return school_teacher;
	}

	public void setSchool_teacher(Integer schoolTeacher) {
		school_teacher = schoolTeacher;
	}

	public Integer getCompany_teacher() {
		return company_teacher;
	}

	public void setCompany_teacher(Integer companyTeacher) {
		company_teacher = companyTeacher;
	}

	@Override
	public String toString() {
		return "BaseCoachBean [base_no=" + base_no + ", company_teacher="
				+ company_teacher + ", school_teacher=" + school_teacher + "]";
	}

}
