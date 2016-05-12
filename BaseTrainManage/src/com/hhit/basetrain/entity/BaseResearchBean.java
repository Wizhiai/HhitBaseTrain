/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-29t下午03:13:39 基地科研与技术活动
 */
public class BaseResearchBean {
	/** 基地编号 */
	private Integer base_no;
	/** 科研项目总数 */
	private Integer research_num;
	/** 教育研究项目总数 */
	private Integer education_num;
	/** 科研经费总额 */
	private Double research_funding;
	/** 科教研成果 */
	private Integer scientific_research;
	/** 典型科教研成果 名称 */
	private String typical_research;
	/** 近三年开发项目总数 */
	private Integer develop_project_num;
	/** 近三年开发项目总额 */
	private Double develop_project_funding;
	/** 开发职员人数 */
	private String develop_project_staff;
	/** 参与开发的实训学生人数 */
	private String develop_project_student;
	/** 典型开发成果及效益 */
	private String typical_project;

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public Integer getResearch_num() {
		return research_num;
	}

	public void setResearch_num(Integer researchNum) {
		research_num = researchNum;
	}

	public Integer getEducation_num() {
		return education_num;
	}

	public void setEducation_num(Integer educationNum) {
		education_num = educationNum;
	}

	public Double getResearch_funding() {
		return research_funding;
	}

	public void setResearch_funding(Double researchFunding) {
		research_funding = researchFunding;
	}

	public Integer getScientific_research() {
		return scientific_research;
	}

	public void setScientific_research(Integer scientificResearch) {
		scientific_research = scientificResearch;
	}

	public String getTypical_research() {
		return typical_research;
	}

	public void setTypical_research(String typicalResearch) {
		typical_research = typicalResearch;
	}

	public Integer getDevelop_project_num() {
		return develop_project_num;
	}

	public void setDevelop_project_num(Integer developProjectNum) {
		develop_project_num = developProjectNum;
	}

	public Double getDevelop_project_funding() {
		return develop_project_funding;
	}

	public void setDevelop_project_funding(Double developProjectFunding) {
		develop_project_funding = developProjectFunding;
	}

	public String getDevelop_project_staff() {
		return develop_project_staff;
	}

	public void setDevelop_project_staff(String developProjectStaff) {
		develop_project_staff = developProjectStaff;
	}

	public String getDevelop_project_student() {
		return develop_project_student;
	}

	public void setDevelop_project_student(String developProjectStudent) {
		develop_project_student = developProjectStudent;
	}

	public String getTypical_project() {
		return typical_project;
	}

	public void setTypical_project(String typicalProject) {
		typical_project = typicalProject;
	}

	@Override
	public String toString() {
		return "BaseResearchBean [base_no=" + base_no
				+ ", develop_project_funding=" + develop_project_funding
				+ ", develop_project_num=" + develop_project_num
				+ ", develop_project_staff=" + develop_project_staff
				+ ", develop_project_student=" + develop_project_student
				+ ", education_num=" + education_num + ", research_funding="
				+ research_funding + ", research_num=" + research_num
				+ ", scientific_research=" + scientific_research
				+ ", typical_project=" + typical_project
				+ ", typical_research=" + typical_research + "]";
	}

}
