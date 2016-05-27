package com.hhit.basetrain.controller.teaching;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TeachingService;

/**
 * 
 * @author mayu
 */
@Controller
public class TrainCourseShowedController {
	@Resource
	private TeachingService teachingService;
	
	@RequestMapping("/teaching/showstudyplan")
	@ResponseBody
	public Result execute(String base_no,Integer page,Integer pageSize){
		Result result=teachingService.showStudyPlan(base_no, page, pageSize);
		return result;
	}
	
	@RequestMapping("/teaching/showstudycheck")
	@ResponseBody
	public Result execute(String base_no,String base_class,Integer page,Integer pageSize){
		Result result=teachingService.showStudyCheck(base_no, base_class, page, pageSize);
		return result;
	}
}
