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
 * @date 2016-4-23t下午05:11:25
 * 
 */
@Controller
public class StudentSelfInfModifyController {

	@Resource
	private StudentService studentService;
	
	@RequestMapping("/student/modifySelfInf")
	@ResponseBody
	public Result execute(String stuno,String stu_name,String stu_sex,String stu_class,String major,String phone,int enter_year,String birthday,String address){
		
		Result result = studentService.modifySelfInf(stuno,stu_name,stu_sex,stu_class,major,phone,enter_year,birthday,address);
		return result;
	}
	
	@RequestMapping("/student/modifySelfInfo")
	@ResponseBody
	public Result execute1(String stuno,String stu_name,String stu_sex,String stu_class,String major,String phone,String birthday,String address){
		
		Result result = studentService.modifySelfInfo(stuno,stu_name,stu_sex,stu_class,major,phone,birthday,address);
		return result;
	}
	
	@RequestMapping("/student/trainregist")
	@ResponseBody
	public Result trainregist(String stuno, String cno, String base_no){
		
		Result result = studentService.studentRegist(stuno, cno, base_no);
		return result;
	}
	
}
