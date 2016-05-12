/**
 * 
 */
package com.hhit.basetrain.controller.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.StudentService;

/**
 * @author Jiya
 * @date 2016-4-24t上午11:30:08
 * 
 */
@Controller
public class StudentLoadSelfInfController {

	@Resource
	private StudentService studentService;
	
	@RequestMapping("/student/loadSelfInf")
	@ResponseBody
	public Result execute(String stuno){
		Result result = studentService.showInf(stuno);
		return result;
	}
	
	@RequestMapping("/student/findName")
	@ResponseBody
	public Result searchName(String stuno){
		Result result = studentService.showName(stuno);
		return result;
	}
	
	@RequestMapping("/student/isregist")
	@ResponseBody
	public Result isRegist(String stuno){
		Result result = studentService.isStudentRegist(stuno);
		return result;
	}
	@RequestMapping("/student/registCountByMajor")
	@ResponseBody
	public Result registCountByMajor(){
		Result result = studentService.studentRegistCountByMajor();
		return result;
	}
	@RequestMapping("/student/registCountByBase")
	@ResponseBody
	public Result registCountByBase(){
		Result result = studentService.studentRegistCountByBase();
		return result;
	}
	@RequestMapping("/student/registCountByMajorAndBase")
	@ResponseBody
	public Result registCountByMajorAndBase(){
		Result result = studentService.studentRegistCountByMajorAndBase();
		return result;
	}
	@RequestMapping("/student/registCountInfo")
	@ResponseBody
	public Result registCountInfo(){
		Result result = studentService.studentRegistCountInfo();
		return result;
	}
	@RequestMapping("/student/searchEnteryear")
	@ResponseBody
	public Result searchEnteryearInfo(){
		Result result = studentService.studentEnterYearInfo();
		return result;
	}
	@RequestMapping("/student/searchMajor")
	@ResponseBody
	public Result searchMajorInfo(){
		Result result = studentService.studentMajorInfo();
		return result;
	}
	@RequestMapping("/student/searchClass")
	@ResponseBody
	public Result searchClassInfo(String major){
		Result result = studentService.searchClassInfo(major);
		return result;
	}
	
}
