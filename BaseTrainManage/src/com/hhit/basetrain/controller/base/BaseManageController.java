/**
 * 
 */
package com.hhit.basetrain.controller.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseService;

/**
 * @author Jiya
 * @date 2016-5-14t上午10:35:12
 * 
 */
@Controller
public class BaseManageController {
	@Resource
	private BaseService baseService;
	
	@RequestMapping("/base/addBase")
	@ResponseBody
	public Result addBase(String base_name,String base_address){
		Result result = baseService.insertBase(base_name, base_address);
		return result;
	}
	
	@RequestMapping("/base/deleteBase")
	@ResponseBody
	public Result deleteBase(int base_no){
		Result result = baseService.deleteBase(base_no);
		return result;
	}
	
	@RequestMapping("/base/isBaseExitByName")
	@ResponseBody
	public Result isBaseExit(String base_name){
		Result result = baseService.isBaseExit(base_name);
		return result;
	}
	@RequestMapping("/base/modifyBuildByBaseNo")
	@ResponseBody
	public Result modifyBuildByBaseNo(int base_no,String base_property,int manage_institution,
			String main_rule,int development_plan,double construction_funds,int financial_situation,
			int base_qualification,int teacher_num,int senior_num,int intermediate_num,int experienced_teacher,
			int manager_num,int aid_num,int developer_num){
		
		Result result = baseService.modifyBaseBuildInfoByNo(base_no, base_property, 
				manage_institution, main_rule, development_plan, construction_funds,
				financial_situation, base_qualification, teacher_num, senior_num, 
				intermediate_num, experienced_teacher, manager_num, aid_num, developer_num);
		System.out.println(base_property);
		return result;
	}
	@RequestMapping("/base/modifyBasicInfoByBaseNo")
	@ResponseBody
	public Result modifyBasicInfoByBaseNo(int base_no,String base_name,String base_address,
			String establish_time){
		
		Result result = baseService.modifyBaseBasicInfoByNo(base_no, base_name,
				base_address, establish_time);
		return result;
	}
	
	@RequestMapping("/base/modifyFiledByBaseNo")
	@ResponseBody
	public Result modifyFiledByBaseNo(int base_no,String base_area,String handware,int machine_situation,
			int software_selfevaluation,int software_demand,int canteen_belong,int dormitory_belong,int student_manage,
			int clean_manage,String environment,String safety){
		
		Result result = baseService.modifyBaseFieldInfoByNo(base_no, base_area, handware, 
				machine_situation, software_selfevaluation, software_demand, 
				canteen_belong, dormitory_belong, student_manage, clean_manage, environment, safety);
		return result;
	}
	
	@RequestMapping("/base/modifyContentByBaseNo")
	@ResponseBody
	public Result modifyContentByBaseNo(int base_no,String internship_outline,String outline_plan,
			String train_plan,String new_plan,String guide_book,String new_guidingbook,String teaching_material,
			String new_material,String publish_book,String train_project,String new_project,
			String student_num,String train_price,String develop_case){
		
		Result result = baseService.modifyBaseContentInfoByNo(base_no, internship_outline,
				outline_plan, train_plan, new_plan, guide_book, new_guidingbook,
				teaching_material, new_material, publish_book, train_project, new_project,
				student_num, train_price, develop_case);
		return result;
	}
	
	@RequestMapping("/base/modifyCocahByBaseNo")
	@ResponseBody
	public Result modifyCocahByBaseNo(int base_no,int school_teacher,int company_teacher){
		
		Result result = baseService.modifyBaseCoachInfoByNo(base_no, school_teacher, company_teacher);
		
		return result;
	}
	
	@RequestMapping("/base/modifyResearchByBaseNo")
	@ResponseBody
	public Result modifyResearchByBaseNo(int base_no,int research_num,int education_num,
			double research_funding,int scientific_research,String typical_research,int develop_project_num,
			double develop_project_funding,String develop_project_staff,String develop_project_student,
			String typical_project){
		
		Result result = baseService.modifyBaseResearchInfoByNo(base_no, research_num,
				education_num, research_funding, scientific_research, typical_research, 
				develop_project_num, develop_project_funding, develop_project_staff,
				develop_project_student, typical_project);
		return result;
	}
	
	@RequestMapping("/base/modifyEffectByBaseNo")
	@ResponseBody
	public Result modifyEffectByBaseNo(int base_no,int project_inuse,int good_project,
			int company_project,int selfdevelop_project,String evaluation_rule,double postgraduate_proportion,
			double undergraduate_proportion,double specialist_proportion,double school_source,
			double trainee_source,String train_finish_num,String train_employed_num,double large_enterprise,
			double middle_enterprise,double small_enterprise,String salary_range,double base_recommend,
			double student_selfask){
		
		Result result = baseService.modifyBaseEffectInfoByNo(base_no, project_inuse, 
				good_project, company_project, selfdevelop_project, evaluation_rule, 
				postgraduate_proportion, undergraduate_proportion, specialist_proportion,
				school_source, trainee_source, train_finish_num, train_employed_num,
				large_enterprise, middle_enterprise, small_enterprise, salary_range,
				base_recommend, student_selfask);
		
		return result;
	}
	
	@RequestMapping("/base/modifyAllianceByBaseNo")
	@ResponseBody
	public Result modifyAllianceByBaseNo(int base_no,String cooperation_enterprise_num,
			String cooperation_project_num,String employment_alliance_num,String actual_employment_num,
			double employment_alliance_proportion,String cooperation_enterprise_name){
		
		Result result = baseService.modifyBaseAllianceInfoByNo(base_no, cooperation_enterprise_num,
				cooperation_project_num, employment_alliance_num, actual_employment_num,
				employment_alliance_proportion, cooperation_enterprise_name);
		
		return result;
	}
	
	@RequestMapping("/base/modifyAdvantageByBaseNo")
	@ResponseBody
	public Result modifyAllianceByBaseNo(int base_no,String base_advantage){
		
		Result result = baseService.modifyBaseAdvantageInfoByNo(base_no, base_advantage);
		return result;
	}
}
