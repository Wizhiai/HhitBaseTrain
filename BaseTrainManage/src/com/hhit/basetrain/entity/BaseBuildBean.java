/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-29t下午02:39:35 基地建设与管理状况实体类
 */
public class BaseBuildBean {

	/** 基地编号 */
	private Integer base_no;
	/** 基地性质 */
	private String base_property;
	/** 基地管理机构情况 */
	private Integer manage_institution;
	/** 主要规章制度 */
	private String main_rule;
	/** 建设发展计划 */
	private Integer development_plan;
	/** 建设经费总额 */
	private Double construction_funds;
	/** 经费状况 */
	private Integer financial_situation;
	/** 基地资格 */
	private Integer base_qualification;
	/** 教师人数 */
	private Integer teacher_num;
	/** 高级职称 */
	private Integer senior_num;
	/** 中级职称 */
	private Integer intermediate_num;
	/** 企业、项目经验丰富的指导教师人数 */
	private Integer experienced_teacher;
	/** 管理人员数 */
	private Integer manager_num;
	/** 基辅助人员数 */
	private Integer aid_num;
	/** 实训项目开发人员数 */
	private Integer developer_num;

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public String getBase_property() {
		return base_property;
	}

	public void setBase_property(String baseProperty) {
		base_property = baseProperty;
	}

	public Integer getManage_institution() {
		return manage_institution;
	}

	public void setManage_institution(Integer manageInstitution) {
		manage_institution = manageInstitution;
	}

	public String getMain_rule() {
		return main_rule;
	}

	public void setMain_rule(String mainRule) {
		main_rule = mainRule;
	}

	public Integer getDevelopment_plan() {
		return development_plan;
	}

	public void setDevelopment_plan(Integer developmentPlan) {
		development_plan = developmentPlan;
	}

	public Double getConstruction_funds() {
		return construction_funds;
	}

	public void setConstruction_funds(Double constructionFunds) {
		construction_funds = constructionFunds;
	}

	public Integer getFinancial_situation() {
		return financial_situation;
	}

	public void setFinancial_situation(Integer financialSituation) {
		financial_situation = financialSituation;
	}

	public Integer getBase_qualification() {
		return base_qualification;
	}

	public void setBase_qualification(Integer baseQualification) {
		base_qualification = baseQualification;
	}

	public Integer getTeacher_num() {
		return teacher_num;
	}

	public void setTeacher_num(Integer teacherNum) {
		teacher_num = teacherNum;
	}

	public Integer getSenior_num() {
		return senior_num;
	}

	public void setSenior_num(Integer seniorNum) {
		senior_num = seniorNum;
	}

	public Integer getIntermediate_num() {
		return intermediate_num;
	}

	public void setIntermediate_num(Integer intermediateNum) {
		intermediate_num = intermediateNum;
	}

	public Integer getExperienced_teacher() {
		return experienced_teacher;
	}

	public void setExperienced_teacher(Integer experiencedTeacher) {
		experienced_teacher = experiencedTeacher;
	}

	public Integer getManager_num() {
		return manager_num;
	}

	public void setManager_num(Integer managerNum) {
		manager_num = managerNum;
	}

	public Integer getAid_num() {
		return aid_num;
	}

	public void setAid_num(Integer aidNum) {
		aid_num = aidNum;
	}

	public Integer getDeveloper_num() {
		return developer_num;
	}

	public void setDeveloper_num(Integer developerNum) {
		developer_num = developerNum;
	}

	@Override
	public String toString() {
		return "BaseBuildBean [aid_num=" + aid_num + ", base_no=" + base_no
				+ ", base_property=" + base_property + ", base_qualification="
				+ base_qualification + ", construction_funds="
				+ construction_funds + ", developer_num=" + developer_num
				+ ", development_plan=" + development_plan
				+ ", experienced_teacher=" + experienced_teacher
				+ ", financial_situation=" + financial_situation
				+ ", intermediate_num=" + intermediate_num + ", main_rule="
				+ main_rule + ", manage_institution=" + manage_institution
				+ ", manager_num=" + manager_num + ", senior_num=" + senior_num
				+ ", teacher_num=" + teacher_num + "]";
	}

}
