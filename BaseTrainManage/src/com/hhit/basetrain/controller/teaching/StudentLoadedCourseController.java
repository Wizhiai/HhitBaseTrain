package com.hhit.basetrain.controller.teaching;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TeachingService;

@Controller
public class StudentLoadedCourseController {
	@Resource
	private TeachingService teachingService;
	
	@RequestMapping("/teaching/showstudyplanbycno")
	@ResponseBody
	public Result execute(String cno){
		Result result=new Result();
		result=teachingService.showStudyPlanByCno(cno);
		return result;
	}
	
	@RequestMapping("/teaching/showstudycheckbycno")
	@ResponseBody
	public Result execute1(String cno,String base_class){
		Result result=new Result();
		System.out.println(cno);
		System.out.println(base_class);
		result=teachingService.showStudyCheckByCno(cno, base_class);
		return result;
	}
}
