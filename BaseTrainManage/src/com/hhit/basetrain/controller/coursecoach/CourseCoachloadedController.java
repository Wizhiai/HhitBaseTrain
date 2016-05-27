/**
 * 
 */
package com.hhit.basetrain.controller.coursecoach;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.CourseCoachService;

/**
 * @author mayu
 */
@Controller
public class CourseCoachloadedController {
	@Resource
	private CourseCoachService courseCoachService;
	
	@RequestMapping("/coach/loadCoach")
	@ResponseBody
	public Result execute(String cno,Integer page,Integer pageSize){
		Result result=courseCoachService.loadCourseCoach(cno, page, pageSize);
		System.out.println(result.getData());
		return result;
		
	}
}
