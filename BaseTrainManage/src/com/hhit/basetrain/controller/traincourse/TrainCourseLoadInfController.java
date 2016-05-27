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
<<<<<<< HEAD
	@RequestMapping("/traincourse/isCourseNameExit")
	@ResponseBody
	public Result isCourseNameExit(String manager_no, String cname){
		
		Result result=trainCourseService.isCourseNameExit(manager_no, cname);
		return result;
		
	}
	@RequestMapping("/traincourse/addCourse")
	@ResponseBody
	public Result addCourse(String manager_no,String cname,int cost,double term){
		
		Result result=trainCourseService.addCourseInf(manager_no, cname, cost, term);
		return result;
		
	}
	@RequestMapping("/traincourse/showBaseCourseByManagerNo")
	@ResponseBody
	public Result showBaseCourseByManagerNo(String manager_no){
		
		Result result=trainCourseService.showCourseInfByManagerNo(manager_no);
		return result;
	}
	@RequestMapping("/traincourse/searchCourseByCourseNo")
	@ResponseBody
	public Result searchCourseByCourseNo(String cno){
		
		Result result=trainCourseService.searchCourseInfByCourseNo(cno);
		return result;
	}
	@RequestMapping("/traincourse/modifyCourseInfoByCourseNo")
	@ResponseBody
	public Result modifyCourseInfoByCourseNo(String cno,String cname,int cost,double term){
		
		Result result=trainCourseService.modifyCourseInfByCourseNo(cno, cname, cost, term);
		return result;
	}
	@RequestMapping("/traincourse/deleteCourseInfoByCourseNo")
	@ResponseBody
	public Result deleteCourseInfoByCourseNo(String cno){
		
		Result result=trainCourseService.deleteCourseInfByCourseNo(cno);
		return result;
	}
=======
	
	@RequestMapping("/traincourse/searchCno")
	@ResponseBody
	public Result execute(String base_no){
		
		Result result=trainCourseService.showCno(base_no);
		return result;
		
	}

>>>>>>> 945d2b75460f000516705e1dd40c9ea8b8dd71dd
}
