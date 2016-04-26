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
		System.out.println(1);
		return result;
	}
	
}
