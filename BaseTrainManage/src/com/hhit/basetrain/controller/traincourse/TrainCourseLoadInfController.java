/**
 * 
 */
package com.hhit.basetrain.controller.traincourse;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TrainCourseService;

/**
 * @author Jiya
 * @date 2016-4-27t下午07:13:49
 * 
 */
@Controller
public class TrainCourseLoadInfController {
	@Resource
	private TrainCourseService trainCourseService;
	
	@RequestMapping("/traincourse/searchCourseInfByBaseNo")
	@ResponseBody
	public Result searchCourseName(String base_no){
		
		Result result=trainCourseService.showCourseInfByBaseNo(base_no);
		return result;
		
	}
	
	@RequestMapping("/traincourse/searchAllCourse")
	@ResponseBody
	public Result searchAllCourse(){
		
		Result result=trainCourseService.showAllbaseCourseInf();
		return result;
		
	}
	
	@RequestMapping("/traincourse/searchCno")
	@ResponseBody
	public Result execute(String base_no){
		
		Result result=trainCourseService.showCno(base_no);
		return result;
		
	}
	
	@RequestMapping("/traincourse/searchCname")
	@ResponseBody
	public Result execute1(String cno){
		Result result=trainCourseService.showCname(cno);
		System.out.println(result.getData());
		return result;
		
	}
	
	
	
	

}
