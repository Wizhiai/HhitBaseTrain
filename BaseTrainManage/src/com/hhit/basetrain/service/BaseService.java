/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:26:01
 * 
 */
public interface BaseService {

	/**
	 * 通过基地名模糊查找浏览基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimBaseInfByName(String base_name);
	/**
	 * 通过基地地址模糊查找浏览基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimBaseInfByAddress(String base_address);
	/**
	 * 通过课程模糊查找浏览基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimBaseInfByCourse(String cname);
	/**
	 * 浏览全部基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimAllBaseInf();
	/**
	 * 显示全部基地名称
	 * @param no
	 * @return
	 */
	public Result showAllBaseName();
	/**
	 * 通过基地号显示基地基本信息
	 * @param no
	 * @return
	 */
	public Result showBaseBasicInfoByNo(int base_no);
	/**
	 * 通过基地号显示基地和基地管理员基本信息
	 * @param no
	 * @return
	 */
	public Result showBaseAndBaseAdminBasicInfoByNo(int base_no);
	/**
	 * 通过基地号显示基地建设与管理状况
	 * @param no
	 * @return
	 */
	public Result showBaseBuildInfoByNo(int base_no);
	/**
	 * 通过基地号显示基地场地与设施条件
	 * @param no
	 * @return
	 */
	public Result showBaseFieldInfoByNo(int base_no);
	/**
	 * 通过基地号显示基地实训项目目标及内容
	 * @param no
	 * @return
	 */
	public Result showBaseContentInfoByNo(int base_no);
	/**
	 * 通过基地号显示基地教师与辅导队伍
	 * @param no
	 * @return
	 */
	public Result showBaseCoachInfoByNo(int base_no);
	/**
	 * 通过基地号显示基地科研与技术活动
	 * @param no
	 * @return
	 */
	public Result showBaseResearchInfoByNo(int base_no);
	/**
	 * 通过基地号显示基地实践效果与能力开发
	 * @param no
	 * @return
	 */
	public Result showBaseEffectInfoByNo(int base_no);
	/**
	 * 通过基地号显示基地企业联盟
	 * @param no
	 * @return
	 */
	public Result showBaseAllianceInfoByNo(int base_no);
	/**
	 * 通过基地号显示基地特色
	 * @param no
	 * @return
	 */
	public Result showBaseAdvantageInfoByNo(int base_no);
	/**
	 * 添加基地
	 * @param no
	 * @return
	 */
	public Result insertBase(String base_name,String base_address);
	/**
	 *删除基地
	 * @param no
	 * @return
	 */
	public Result deleteBase(int base_no);
	/**
	 *判断基地名是否存在
	 * @param no
	 * @return
	 */
	public Result isBaseExit(String base_name);
	/**
	 * 基地是否存在
	 * @param base_no
	 * @param base_name
	 * @param base_address
	 * @param establish_time
	 * @return
	 */
	public Result modifyBaseBasicInfoByNo(int base_no,String base_name,String base_address,String establish_time);
	/**
	 * 通过基地号修改基地建设与管理状况信息
	 * @param no
	 * @return
	 */
	public Result modifyBaseBuildInfoByNo(int base_no,String base_property,int manage_institution,
			String main_rule,int development_plan,double construction_funds,int financial_situation,
			int base_qualification,int teacher_num,int senior_num,int intermediate_num,int experienced_teacher,
			int manager_num,int aid_num,int developer_num);
	/**
	 * 通过基地修改基地场地与设施条件
	 * @param no
	 * @return
	 */
	public Result modifyBaseFieldInfoByNo(int base_no,String base_area,String handware,int machine_situation,
			int software_selfevaluation,int software_demand,int canteen_belong,int dormitory_belong,int student_manage,
			int clean_manage,String environment,String safety);
	/**
	 * 通过基地号修改基地实训项目目标及内容
	 * @param no
	 * @return
	 */
	public Result modifyBaseContentInfoByNo(int base_no,String internship_outline,String outline_plan,
			String train_plan,String new_plan,String guide_book,String new_guidingbook,String teaching_material,
			String new_material,String publish_book,String train_project,String new_project,
			String student_num,String train_price,String develop_case);
	/**
	 * 通过基地号修改基地教师与辅导队伍
	 * @param no
	 * @return
	 */
	public Result modifyBaseCoachInfoByNo(int base_no,int school_teacher,int company_teacher);
	/**
	 * 通过基地号修改基地科研与技术活动
	 * @param no
	 * @return
	 */
	public Result modifyBaseResearchInfoByNo(int base_no,int research_num,int education_num,
			double research_funding,int scientific_research,String typical_research,int develop_project_num,
			double develop_project_funding,String develop_project_staff,String develop_project_student,
			String typical_project);
	/**
	 * 通过基地号修改基地实践效果与能力开发
	 * @param no
	 * @return
	 */
	public Result modifyBaseEffectInfoByNo(int base_no,int project_inuse,int good_project,
			int company_project,int selfdevelop_project,String evaluation_rule,double postgraduate_proportion,
			double undergraduate_proportion,double specialist_proportion,double school_source,
			double trainee_source,String train_finish_num,String train_employed_num,double large_enterprise,
			double middle_enterprise,double small_enterprise,String salary_range,double base_recommend,
			double student_selfask);
	/**
	 * 通过基地号修改基地企业联盟
	 * @param no
	 * @return
	 */
	public Result modifyBaseAllianceInfoByNo(int base_no,String cooperation_enterprise_num,
			String cooperation_project_num,String employment_alliance_num,String actual_employment_num,
			double employment_alliance_proportion,String cooperation_enterprise_name);
	/**
	 * 通过基地号修改基地特色
	 * @param no
	 * @return
	 */
	public Result modifyBaseAdvantageInfoByNo(int base_no,String base_advantage);
}
