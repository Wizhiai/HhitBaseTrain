/**
 * 
 */
package com.hhit.basetrain.controller.collegeteacher;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.CollegeTeacherService;

/**
 * @author Jiya
 * @date 2016-4-24t上午11:30:08
 * 
 */
@Controller
public class CollegeTeacherLoadSelfInfController {

	@Resource
	private CollegeTeacherService collegeTeacherService;
	
	@RequestMapping("/collegeteacher/loadSelfInf")
	@ResponseBody
	public Result execute(String ct_no){
		
		Result result = collegeTeacherService.showInf(ct_no);
		return result;
	}
	
	@RequestMapping("/collegeteacher/findName")
	@ResponseBody
	public Result searchName(String ct_no){
		Result result = collegeTeacherService.showName(ct_no);
		return result;
	}
	
	@RequestMapping("/collegeteacher/searchAcademy")
	@ResponseBody
	public Result searchAcademyName(){
		Result result = collegeTeacherService.showAcademyInf();
		return result;
	}
	
	@RequestMapping("/teacher/searchTeacherUser")
	@ResponseBody
	public Result searchTeacherUser(String academy_no){
		Result result = collegeTeacherService.showCollegeTeacherByAcademyNo(academy_no);
		return result;
	}
	
}
