/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-29t下午03:18:42 实践效果与能力开发
 */
public class BaseTrainEffectBean {

	/** 基地编号 */
	private Integer base_no;
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
	private Double specialist_proportion;
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

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
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

	public Double getSpecialist_proportion() {
		return specialist_proportion;
	}

	public void setSpecialist_proportion(Double specialistProportion) {
		specialist_proportion = specialistProportion;
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

	@Override
	public String toString() {
		return "BaseTrainEffectBean [base_no=" + base_no + ", base_recommend="
				+ base_recommend + ", company_project=" + company_project
				+ ", evaluation_rule=" + evaluation_rule + ", good_project="
				+ good_project + ", large_enterprise=" + large_enterprise
				+ ", middle_enterprise=" + middle_enterprise
				+ ", postgraduate_proportion=" + postgraduate_proportion
				+ ", project_inuse=" + project_inuse + ", salary_range="
				+ salary_range + ", school_source=" + school_source
				+ ", selfdevelop_project=" + selfdevelop_project
				+ ", small_enterprise=" + small_enterprise
				+ ", specialist_proportion=" + specialist_proportion
				+ ", student_selfask=" + student_selfask
				+ ", train_employed_num=" + train_employed_num
				+ ", train_finish_num=" + train_finish_num
				+ ", trainee_source=" + trainee_source
				+ ", undergraduate_proportion=" + undergraduate_proportion
				+ "]";
	}

}
