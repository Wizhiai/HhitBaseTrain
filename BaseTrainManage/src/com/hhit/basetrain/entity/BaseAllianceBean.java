/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-29t下午03:24:57 基地企业联盟实体类
 */
public class BaseAllianceBean {

	/** 基地编号 */
	private Integer base_no;
	/** 合作开发实训项目的企业数 */
	private String cooperation_enterprise_num;
	/** 合作开发项目数 */
	private String cooperation_project_num;
	/** 加入就业联盟企业数 */
	private String employment_alliance_num;
	/** 实际从基地招生的企业数 */
	private String actual_employment_num;
	/** 就业联盟企业招生数占学生总数比例 */
	private Double employment_alliance_proportion;
	/** 与基地长期稳定合作的大中型企业名称 */
	private String cooperation_enterprise_name;

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public String getCooperation_enterprise_num() {
		return cooperation_enterprise_num;
	}

	public void setCooperation_enterprise_num(String cooperationEnterpriseNum) {
		cooperation_enterprise_num = cooperationEnterpriseNum;
	}

	public String getCooperation_project_num() {
		return cooperation_project_num;
	}

	public void setCooperation_project_num(String cooperationProjectNum) {
		cooperation_project_num = cooperationProjectNum;
	}

	public String getEmployment_alliance_num() {
		return employment_alliance_num;
	}

	public void setEmployment_alliance_num(String employmentAllianceNum) {
		employment_alliance_num = employmentAllianceNum;
	}

	public String getActual_employment_num() {
		return actual_employment_num;
	}

	public void setActual_employment_num(String actualEmploymentNum) {
		actual_employment_num = actualEmploymentNum;
	}

	public Double getEmployment_alliance_proportion() {
		return employment_alliance_proportion;
	}

	public void setEmployment_alliance_proportion(
			Double employmentAllianceProportion) {
		employment_alliance_proportion = employmentAllianceProportion;
	}

	public String getCooperation_enterprise_name() {
		return cooperation_enterprise_name;
	}

	public void setCooperation_enterprise_name(String cooperationEnterpriseName) {
		cooperation_enterprise_name = cooperationEnterpriseName;
	}

	@Override
	public String toString() {
		return "BaseAllianceBean [actual_employment_num="
				+ actual_employment_num + ", base_no=" + base_no
				+ ", cooperation_enterprise_name="
				+ cooperation_enterprise_name + ", cooperation_enterprise_num="
				+ cooperation_enterprise_num + ", cooperation_project_num="
				+ cooperation_project_num + ", employment_alliance_num="
				+ employment_alliance_num + ", employment_alliance_proportion="
				+ employment_alliance_proportion + "]";
	}

}
