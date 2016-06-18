/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-29t下午02:52:23 实训场地与设施条件实体类
 */
public class BaseFieldBean {
	/** 基地编号 */
	private Integer base_no;
	/** 实训场地 */
	private String base_area;
	/** 硬件设备 */
	private String handware;
	/** 设备使用状况 */
	private Integer machine_situation;
	/** 软件先进度自我评价 */
	private Integer software_selfevaluation;
	/** 软件实训需求情况 */
	private Integer software_demand;
	/** 食堂归属 */
	private Integer canteen_belong;
	/** 宿舍归属 */
	private Integer dormitory_belong;
	/** 学生管理现状 */
	private Integer student_manage;
	/** 清洁卫生 */
	private Integer clean_manage;
	/** 环境状况 */
	private String environment;
	/** 安全状况 */
	private String safety;

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public Integer getMachine_situation() {
		return machine_situation;
	}

	public void setMachine_situation(Integer machineSituation) {
		machine_situation = machineSituation;
	}

	public Integer getSoftware_selfevaluation() {
		return software_selfevaluation;
	}

	public void setSoftware_selfevaluation(Integer softwareSelfevaluation) {
		software_selfevaluation = softwareSelfevaluation;
	}

	public Integer getSoftware_demand() {
		return software_demand;
	}

	public void setSoftware_demand(Integer softwareDemand) {
		software_demand = softwareDemand;
	}

	public Integer getCanteen_belong() {
		return canteen_belong;
	}

	public void setCanteen_belong(Integer canteenBelong) {
		canteen_belong = canteenBelong;
	}

	public Integer getDormitory_belong() {
		return dormitory_belong;
	}

	public void setDormitory_belong(Integer dormitoryBelong) {
		dormitory_belong = dormitoryBelong;
	}

	public Integer getStudent_manage() {
		return student_manage;
	}

	public void setStudent_manage(Integer studentManage) {
		student_manage = studentManage;
	}

	public Integer getClean_manage() {
		return clean_manage;
	}

	public void setClean_manage(Integer cleanManage) {
		clean_manage = cleanManage;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getSafety() {
		return safety;
	}

	public void setSafety(String safety) {
		this.safety = safety;
	}

	public String getBase_area() {
		return base_area;
	}

	public void setBase_area(String baseArea) {
		base_area = baseArea;
	}

	public String getHandware() {
		return handware;
	}

	public void setHandware(String handware) {
		this.handware = handware;
	}

	@Override
	public String toString() {
		return "BaseFieldBean [base_area=" + base_area + ", base_no=" + base_no
				+ ", canteen_belong=" + canteen_belong + ", clean_manage="
				+ clean_manage + ", dormitory_belong=" + dormitory_belong
				+ ", environment=" + environment + ", handware=" + handware
				+ ", machine_situation=" + machine_situation + ", safety="
				+ safety + ", software_demand=" + software_demand
				+ ", software_selfevaluation=" + software_selfevaluation
				+ ", student_manage=" + student_manage + "]";
	}

}
