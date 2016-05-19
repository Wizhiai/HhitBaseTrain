/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-29t下午03:01:06 实训项目目标及内容
 */
public class BaseTrainContentBean {
	/** 基地编号 */
	private Integer base_no;
	/** 制定好的实训大纲 */
	private String internship_outline;
	/** 拟指定的实训大纲 */
	private String outline_plan;
	/** 制定好的计划 */
	private String train_plan;
	/** 拟制定的计划 */
	private String new_plan;
	/** 制定好的指导书 */
	private String guide_book;
	/** 拟指定的指导书 */
	private String new_guidingbook;
	/** 已编订的实训教材 */
	private String teaching_material;
	/** 拟编订的实训教材 */
	private String new_material;
	/** 选用出版图书 */
	private String publish_book;
	/** 补强实训项目/课程名称 */
	private String train_project;
	/** 拟开拓新的实训项目 */
	private String new_project;
	/** 每个项目/课程安排的学生人数 */
	private String student_num;
	/** 实训费用 */
	private String train_price;
	/** 开发案例 */
	private String develop_case;

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public String getInternship_outline() {
		return internship_outline;
	}

	public void setInternship_outline(String internshipOutline) {
		internship_outline = internshipOutline;
	}

	public String getOutline_plan() {
		return outline_plan;
	}

	public void setOutline_plan(String outlinePlan) {
		outline_plan = outlinePlan;
	}

	public String getTrain_plan() {
		return train_plan;
	}

	public void setTrain_plan(String trainPlan) {
		train_plan = trainPlan;
	}

	public String getNew_plan() {
		return new_plan;
	}

	public void setNew_plan(String newPlan) {
		new_plan = newPlan;
	}

	public String getGuide_book() {
		return guide_book;
	}

	public void setGuide_book(String guideBook) {
		guide_book = guideBook;
	}

	public String getNew_guidingbook() {
		return new_guidingbook;
	}

	public void setNew_guidingbook(String newGuidingbook) {
		new_guidingbook = newGuidingbook;
	}

	public String getTeaching_material() {
		return teaching_material;
	}

	public void setTeaching_material(String teachingMaterial) {
		teaching_material = teachingMaterial;
	}

	public String getNew_material() {
		return new_material;
	}

	public void setNew_material(String newMaterial) {
		new_material = newMaterial;
	}

	public String getPublish_book() {
		return publish_book;
	}

	public void setPublish_book(String publishBook) {
		publish_book = publishBook;
	}

	public String getTrain_project() {
		return train_project;
	}

	public void setTrain_project(String trainProject) {
		train_project = trainProject;
	}

	public String getNew_project() {
		return new_project;
	}

	public void setNew_project(String newProject) {
		new_project = newProject;
	}

	public String getStudent_num() {
		return student_num;
	}

	public void setStudent_num(String studentNum) {
		student_num = studentNum;
	}

	public String getTrain_price() {
		return train_price;
	}

	public void setTrain_price(String trainPrice) {
		train_price = trainPrice;
	}

	public String getDevelop_case() {
		return develop_case;
	}

	public void setDevelop_case(String developCase) {
		develop_case = developCase;
	}

	@Override
	public String toString() {
		return "BaseTrainContent [base_no=" + base_no + ", develop_case="
				+ develop_case + ", guide_book=" + guide_book
				+ ", internship_outline=" + internship_outline
				+ ", new_guidingbook=" + new_guidingbook + ", new_material="
				+ new_material + ", new_plan=" + new_plan + ", new_project="
				+ new_project + ", outline_plan=" + outline_plan
				+ ", publish_book=" + publish_book + ", student_num="
				+ student_num + ", teaching_material=" + teaching_material
				+ ", train_plan=" + train_plan + ", train_price=" + train_price
				+ ", train_project=" + train_project + "]";
	}

}
