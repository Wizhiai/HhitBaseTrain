package com.hhit.basetrain.controller.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.StudentService;
import com.hhit.basetrain.service.TrainStudentService;

/**
 * 
 * @author mayu
 */
@Controller
public class BaseAdminLoadTrainStudentController {
	@Resource
	private StudentService studentService;
	
	@Resource
	private TrainStudentService trainstudentService;
	
	@RequestMapping("student/loadtrainstudent")
	@ResponseBody
	public Result execute(Integer base_no,String cno){
		Result result=studentService.searchTrainStudent(base_no,cno);
		System.out.println(result.getData());
		return result;
	}
	
	
	@RequestMapping("trainstudent/searchtrainstudent")
	@ResponseBody
	public Result execute(String manager_no,
			String base_class){
		Result result=trainstudentService.baseadminSearchTrainStudentByClass(manager_no, base_class);
		System.out.println(result.getData());
		return result;
	}
	
	
}
