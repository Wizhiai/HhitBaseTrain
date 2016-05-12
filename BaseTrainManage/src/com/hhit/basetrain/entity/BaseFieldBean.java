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
	/** 实训场地面积 */
	private Double base_area;
	/** 实训工位数 */
	private Integer base_station;
	/** 计划扩建面积 */
	private Double extension_area;
	/** 新扩实训工位数 */
	private Integer new_station;
	/** 仪器设备总额 */
	private Double equipment_total;
	/** 台套总数 */
	private Integer machine_total;
	/** 生均资产额 */
	private Double average_assets;
	/** 生均台套数 */
	private String machine_average;
	/** 主流产品及型号 */
	private String mainstream_product;
	/** 设备使用状况 */
	private Integer machine_situation;
	/** 正版软件系统 */
	private String software_system;
	/** 软件先进度自我评价 */
	private Integer software_selfevaluation;
	/** 软件实训需求情况 */
	private Integer software_demand;
	/** 食堂面积 */
	private Double canteen_area;
	/** 食堂座位数 */
	private Integer canteen_seat;
	/** 每日提供的餐数 */
	private Integer meal_num;
	/** 食堂归属 */
	private Integer canteen_belong;
	/** 宿舍面积 */
	private Double dormitory_area;
	/** 床位数 */
	private Integer bed_num;
	/** 每个宿舍床位 */
	private String dormitory_bed;
	/** 宿舍每月价格 */
	private String dormitory_price;
	/** 宿舍归属 */
	private Integer dormitory_belong;
	/** 学生管理现状 */
	private Integer student_manage;
	/** 清洁卫生 */
	private Integer clean_manage;
	/** 环境状况 */
	private Integer environment;
	/** 安全状况 */
	private Integer safety;

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public Double getBase_area() {
		return base_area;
	}

	public void setBase_area(Double baseArea) {
		base_area = baseArea;
	}

	public Integer getBase_station() {
		return base_station;
	}

	public void setBase_station(Integer baseStation) {
		base_station = baseStation;
	}

	public Double getExtension_area() {
		return extension_area;
	}

	public void setExtension_area(Double extensionArea) {
		extension_area = extensionArea;
	}

	public Integer getNew_station() {
		return new_station;
	}

	public void setNew_station(Integer newStation) {
		new_station = newStation;
	}

	public Double getEquipment_total() {
		return equipment_total;
	}

	public void setEquipment_total(Double equipmentTotal) {
		equipment_total = equipmentTotal;
	}

	public Integer getMachine_total() {
		return machine_total;
	}

	public void setMachine_total(Integer machineTotal) {
		machine_total = machineTotal;
	}

	public Double getAverage_assets() {
		return average_assets;
	}

	public void setAverage_assets(Double averageAssets) {
		average_assets = averageAssets;
	}

	public String getMachine_average() {
		return machine_average;
	}

	public void setMachine_average(String machineAverage) {
		machine_average = machineAverage;
	}

	public String getMainstream_product() {
		return mainstream_product;
	}

	public void setMainstream_product(String mainstreamProduct) {
		mainstream_product = mainstreamProduct;
	}

	public Integer getMachine_situation() {
		return machine_situation;
	}

	public void setMachine_situation(Integer machineSituation) {
		machine_situation = machineSituation;
	}

	public String getSoftware_system() {
		return software_system;
	}

	public void setSoftware_system(String softwareSystem) {
		software_system = softwareSystem;
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

	public void setSoftware_demand(Integer softWareDemand) {
		software_demand = softWareDemand;
	}

	public Double getCanteen_area() {
		return canteen_area;
	}

	public void setCanteen_area(Double canteenArea) {
		canteen_area = canteenArea;
	}

	public Integer getCanteen_seat() {
		return canteen_seat;
	}

	public void setCanteen_seat(Integer canteenSeat) {
		canteen_seat = canteenSeat;
	}

	public Integer getMeal_num() {
		return meal_num;
	}

	public void setMeal_num(Integer mealNum) {
		meal_num = mealNum;
	}

	public Integer getCanteen_belong() {
		return canteen_belong;
	}

	public void setCanteen_belong(Integer canteenBelong) {
		canteen_belong = canteenBelong;
	}

	public Double getDormitory_area() {
		return dormitory_area;
	}

	public void setDormitory_area(Double dormitoryArea) {
		dormitory_area = dormitoryArea;
	}

	public Integer getBed_num() {
		return bed_num;
	}

	public void setBed_num(Integer bedNum) {
		bed_num = bedNum;
	}

	public String getDormitory_bed() {
		return dormitory_bed;
	}

	public void setDormitory_bed(String dormitoryBed) {
		dormitory_bed = dormitoryBed;
	}

	public String getDormitory_price() {
		return dormitory_price;
	}

	public void setDormitory_price(String dormitoryPrice) {
		dormitory_price = dormitoryPrice;
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

	public Integer getEnvironment() {
		return environment;
	}

	public void setEnvironment(Integer environment) {
		this.environment = environment;
	}

	public Integer getSafety() {
		return safety;
	}

	public void setSafety(Integer safety) {
		this.safety = safety;
	}

	@Override
	public String toString() {
		return "BaseFieldBean [average_assets=" + average_assets + ", base_area="
				+ base_area + ", base_no=" + base_no + ", base_station="
				+ base_station + ", bed_num=" + bed_num + ", canteen_area="
				+ canteen_area + ", canteen_belong=" + canteen_belong
				+ ", canteen_seat=" + canteen_seat + ", clean_manage="
				+ clean_manage + ", dormitory_area=" + dormitory_area
				+ ", dormitory_bed=" + dormitory_bed + ", dormitory_belong="
				+ dormitory_belong + ", dormitory_price=" + dormitory_price
				+ ", environment=" + environment + ", equipment_total="
				+ equipment_total + ", extension_area=" + extension_area
				+ ", machine_average=" + machine_average
				+ ", machine_situation=" + machine_situation
				+ ", machine_total=" + machine_total + ", mainstream_product="
				+ mainstream_product + ", meal_num=" + meal_num
				+ ", new_station=" + new_station + ", safety=" + safety
				+ ", software_demand=" + software_demand + ", software_selfevaluation="
				+ software_selfevaluation + ", software_system="
				+ software_system + ", student_manage=" + student_manage + "]";
	}

}
