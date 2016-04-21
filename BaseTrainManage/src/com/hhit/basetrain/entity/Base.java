/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-19t下午02:45:22 基地实体类
 */
public class Base {

	/** 基地编号 */
	private Integer base_no;
	/** 基地名称 */
	private String base_name;
	/** 成立时间 */
	private String establish_time;
	/** 基地性质 */
	private String base_property;
	/** 基地管理机构情况 */
	private Integer manage_insitution;
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
	private Double aveage_assets;
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
	private Integer soft_demand;
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
	private Integer entironment;
	/** 安全状况 */
	private Integer safety;
	/** 制定好的实训大纲 */
	private String internship_outline;
	/** 拟指定的实训大纲 */
	private String outline_plan;
	/** 制定好的计划 */
	private String train_plan;
	/** 拟指定的实训大纲 */
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
	/** 学院指导教师 */
	private Integer school_teacher;
	/** 企业指导教师 */
	private Integer company_teacher;
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
	/** 实际使用的项目数 */
	private Integer project_inuse;
	/** 实训效果较好的项目数 */
	private Integer good_project;
	/** 企业实际产品研发项目数 */
	private Integer company_project;
	/** 基地自主研发项目数 */
	private Integer selfdevelop_project;
	/** 实训管理与考评规范 */
	private String evaluation_rule;
	/** 研究生层次 */
	private Double postgraduate_proportion;
	/** 本科生层次 */
	private Double undergraduate_proportion;
	/** 专科生层次 */
	private Double specialist_proporrtion;
	/** 学员来源：学校安排推荐 */
	private Double school_source;
	/** 学员来源：零散报道 */
	private Double trainee_source;
	/** 每年完成实训的人数 */
	private String train_finish_num;
	/** 顺利就业的学生人数 */
	private String train_employed_num;
	/** 就业范围：大型企业 */
	private Double large_enterprise;
	/** 就业范围：中型企业 */
	private Double middle_enterprise;
	/** 就业范围：小型企业 */
	private Double small_enterprise;
	/** 学生就业时起薪范围 */
	private String salary_range;
	/** 基地推荐就业 */
	private Double base_recommend;
	/** 学员自找就业 */
	private Double student_selfask;
	/** 合作开发实训项目的企业数 */
	private String cooperation_enterprise_num;
	/** 合作开发项目数 */
	private String cooperation_project_num;
	/** 加入就业联盟企业数 */
	private String employment_aliance_num;
	/** 实际从基地招生的企业数 */
	private String actual_employment_num;
	/** 就业联盟企业招生数占学生总数比例 */
	private Double employment_aliance_proportion;
	/** 与基地长期稳定合作的大中型企业名称 */
	private String cooperation_enterprise_name;
	/** 基地办学特色和优势 */
	private String base_advantage;

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public String getBase_name() {
		return base_name;
	}

	public void setBase_name(String baseName) {
		base_name = baseName;
	}

	public String getEstablish_time() {
		return establish_time;
	}

	public void setEstablish_time(String establishTime) {
		establish_time = establishTime;
	}

	public String getBase_property() {
		return base_property;
	}

	public void setBase_property(String baseProperty) {
		base_property = baseProperty;
	}

	public Integer getManage_insitution() {
		return manage_insitution;
	}

	public void setManage_insitution(Integer manageInsitution) {
		manage_insitution = manageInsitution;
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

	public Double getAveage_assets() {
		return aveage_assets;
	}

	public void setAveage_assets(Double aveageAssets) {
		aveage_assets = aveageAssets;
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

	public Integer getSoft_demand() {
		return soft_demand;
	}

	public void setSoft_demand(Integer softDemand) {
		soft_demand = softDemand;
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

	public Integer getEntironment() {
		return entironment;
	}

	public void setEntironment(Integer entironment) {
		this.entironment = entironment;
	}

	public Integer getSafety() {
		return safety;
	}

	public void setSafety(Integer safety) {
		this.safety = safety;
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

	public Integer getProject_inuse() {
		return project_inuse;
	}

	public void setProject_inuse(Integer projectInuse) {
		project_inuse = projectInuse;
	}

	public Integer getGood_project() {
		return good_project;
	}

	public void setGood_project(Integer goodProject) {
		good_project = goodProject;
	}

	public Integer getCompany_project() {
		return company_project;
	}

	public void setCompany_project(Integer companyProject) {
		company_project = companyProject;
	}

	public Integer getSelfdevelop_project() {
		return selfdevelop_project;
	}

	public void setSelfdevelop_project(Integer selfdevelopProject) {
		selfdevelop_project = selfdevelopProject;
	}

	public String getEvaluation_rule() {
		return evaluation_rule;
	}

	public void setEvaluation_rule(String evaluationRule) {
		evaluation_rule = evaluationRule;
	}

	public Double getPostgraduate_proportion() {
		return postgraduate_proportion;
	}

	public void setPostgraduate_proportion(Double postgraduateProportion) {
		postgraduate_proportion = postgraduateProportion;
	}

	public Double getUndergraduate_proportion() {
		return undergraduate_proportion;
	}

	public void setUndergraduate_proportion(Double undergraduateProportion) {
		undergraduate_proportion = undergraduateProportion;
	}

	public Double getSpecialist_proporrtion() {
		return specialist_proporrtion;
	}

	public void setSpecialist_proporrtion(Double specialistProporrtion) {
		specialist_proporrtion = specialistProporrtion;
	}

	public Double getSchool_source() {
		return school_source;
	}

	public void setSchool_source(Double schoolSource) {
		school_source = schoolSource;
	}

	public Double getTrainee_source() {
		return trainee_source;
	}

	public void setTrainee_source(Double traineeSource) {
		trainee_source = traineeSource;
	}

	public String getTrain_finish_num() {
		return train_finish_num;
	}

	public void setTrain_finish_num(String trainFinishNum) {
		train_finish_num = trainFinishNum;
	}

	public String getTrain_employed_num() {
		return train_employed_num;
	}

	public void setTrain_employed_num(String trainEmployedNum) {
		train_employed_num = trainEmployedNum;
	}

	public Double getLarge_enterprise() {
		return large_enterprise;
	}

	public void setLarge_enterprise(Double largeEnterprise) {
		large_enterprise = largeEnterprise;
	}

	public Double getMiddle_enterprise() {
		return middle_enterprise;
	}

	public void setMiddle_enterprise(Double middleEnterprise) {
		middle_enterprise = middleEnterprise;
	}

	public Double getSmall_enterprise() {
		return small_enterprise;
	}

	public void setSmall_enterprise(Double smallEnterprise) {
		small_enterprise = smallEnterprise;
	}

	public String getSalary_range() {
		return salary_range;
	}

	public void setSalary_range(String salaryRange) {
		salary_range = salaryRange;
	}

	public Double getBase_recommend() {
		return base_recommend;
	}

	public void setBase_recommend(Double baseRecommend) {
		base_recommend = baseRecommend;
	}

	public Double getStudent_selfask() {
		return student_selfask;
	}

	public void setStudent_selfask(Double studentSelfask) {
		student_selfask = studentSelfask;
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

	public String getEmployment_aliance_num() {
		return employment_aliance_num;
	}

	public void setEmployment_aliance_num(String employmentAlianceNum) {
		employment_aliance_num = employmentAlianceNum;
	}

	public String getActual_employment_num() {
		return actual_employment_num;
	}

	public void setActual_employment_num(String actualEmploymentNum) {
		actual_employment_num = actualEmploymentNum;
	}

	public Double getEmployment_aliance_proportion() {
		return employment_aliance_proportion;
	}

	public void setEmployment_aliance_proportion(
			Double employmentAlianceProportion) {
		employment_aliance_proportion = employmentAlianceProportion;
	}

	public String getCooperation_enterprise_name() {
		return cooperation_enterprise_name;
	}

	public void setCooperation_enterprise_name(String cooperationEnterpriseName) {
		cooperation_enterprise_name = cooperationEnterpriseName;
	}

	public String getBase_advantage() {
		return base_advantage;
	}

	public void setBase_advantage(String baseAdvantage) {
		base_advantage = baseAdvantage;
	}

	@Override
	public String toString() {
		return "Base [actual_employment_num=" + actual_employment_num
				+ ", aid_num=" + aid_num + ", aveage_assets=" + aveage_assets
				+ ", base_advantage=" + base_advantage + ", base_area="
				+ base_area + ", base_name=" + base_name + ", base_no="
				+ base_no + ", base_property=" + base_property
				+ ", base_qualification=" + base_qualification
				+ ", base_recommend=" + base_recommend + ", base_station="
				+ base_station + ", bed_num=" + bed_num + ", canteen_area="
				+ canteen_area + ", canteen_belong=" + canteen_belong
				+ ", canteen_seat=" + canteen_seat + ", clean_manage="
				+ clean_manage + ", company_project=" + company_project
				+ ", company_teacher=" + company_teacher
				+ ", construction_funds=" + construction_funds
				+ ", cooperation_enterprise_name="
				+ cooperation_enterprise_name + ", cooperation_enterprise_num="
				+ cooperation_enterprise_num + ", cooperation_project_num="
				+ cooperation_project_num + ", develop_case=" + develop_case
				+ ", develop_project_funding=" + develop_project_funding
				+ ", develop_project_num=" + develop_project_num
				+ ", develop_project_staff=" + develop_project_staff
				+ ", develop_project_student=" + develop_project_student
				+ ", developer_num=" + developer_num + ", development_plan="
				+ development_plan + ", dormitory_area=" + dormitory_area
				+ ", dormitory_bed=" + dormitory_bed + ", dormitory_belong="
				+ dormitory_belong + ", dormitory_price=" + dormitory_price
				+ ", education_num=" + education_num
				+ ", employment_aliance_num=" + employment_aliance_num
				+ ", employment_aliance_proportion="
				+ employment_aliance_proportion + ", entironment="
				+ entironment + ", equipment_total=" + equipment_total
				+ ", establish_time=" + establish_time + ", evaluation_rule="
				+ evaluation_rule + ", experienced_teacher="
				+ experienced_teacher + ", extension_area=" + extension_area
				+ ", financial_situation=" + financial_situation
				+ ", good_project=" + good_project + ", guide_book="
				+ guide_book + ", intermediate_num=" + intermediate_num
				+ ", internship_outline=" + internship_outline
				+ ", large_enterprise=" + large_enterprise
				+ ", machine_average=" + machine_average
				+ ", machine_situation=" + machine_situation
				+ ", machine_total=" + machine_total + ", main_rule="
				+ main_rule + ", mainstream_product=" + mainstream_product
				+ ", manage_insitution=" + manage_insitution + ", manager_num="
				+ manager_num + ", meal_num=" + meal_num
				+ ", middle_enterprise=" + middle_enterprise
				+ ", new_guidingbook=" + new_guidingbook + ", new_material="
				+ new_material + ", new_plan=" + new_plan + ", new_project="
				+ new_project + ", new_station=" + new_station
				+ ", outline_plan=" + outline_plan
				+ ", postgraduate_proportion=" + postgraduate_proportion
				+ ", project_inuse=" + project_inuse + ", publish_book="
				+ publish_book + ", research_funding=" + research_funding
				+ ", research_num=" + research_num + ", safety=" + safety
				+ ", salary_range=" + salary_range + ", school_source="
				+ school_source + ", school_teacher=" + school_teacher
				+ ", scientific_research=" + scientific_research
				+ ", selfdevelop_project=" + selfdevelop_project
				+ ", senior_num=" + senior_num + ", small_enterprise="
				+ small_enterprise + ", soft_demand=" + soft_demand
				+ ", software_selfevaluation=" + software_selfevaluation
				+ ", software_system=" + software_system
				+ ", specialist_proporrtion=" + specialist_proporrtion
				+ ", student_manage=" + student_manage + ", student_num="
				+ student_num + ", student_selfask=" + student_selfask
				+ ", teacher_num=" + teacher_num + ", teaching_material="
				+ teaching_material + ", train_employed_num="
				+ train_employed_num + ", train_finish_num=" + train_finish_num
				+ ", train_plan=" + train_plan + ", train_price=" + train_price
				+ ", train_project=" + train_project + ", trainee_source="
				+ trainee_source + ", typical_project=" + typical_project
				+ ", typical_research=" + typical_research
				+ ", undergraduate_proportion=" + undergraduate_proportion
				+ "]";
	}

}
