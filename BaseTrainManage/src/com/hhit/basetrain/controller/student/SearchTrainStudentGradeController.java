/**
 * 
 */
package com.hhit.basetrain.controller.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TrainStudentService;

/**
 * @author Mayu
 * @date 2016-4-26t上午10:56:59
 * TODO
 */
@Controller
public class SearchTrainStudentGradeController {
	@Resource
	private TrainStudentService trainStudentService;
	
	/*@RequestMapping("/trainstudent/searchgrade")
	@ResponseBody
	public Result execute(String stuno,String month,String week){
		Result result=trainStudentService.showGradeInfo(stuno, month, week);
		return result;
		
	}
	
	@RequestMapping("/trainstudent/searchgradebymonth")
	@ResponseBody
	public Result execute1(String stuno,String month){
		Result result=trainStudentService.showGradeInfoByMonth(stuno,month);
		return result;
		
	}
	
	@RequestMapping("/trainstudent/searchgradebyweek")
	@ResponseBody
	public Result execute2(String stuno,String week){
		Result result=trainStudentService.showGradeInfoByWeek(stuno,week);
		return result;
		
	}
	
	@RequestMapping("/trainstudent/searchgradebyno")
	@ResponseBody
	public Result execute3(String stuno){
		Result result=trainStudentService.showGradeInfoByNo(stuno);
		return result;
		
	}*/
	
	@RequestMapping("/trainstudent/searchgradebyPage")
	@ResponseBody
	public Result execute4(String stuno,Integer page,Integer pageSize,String week,String month){
		Result result=trainStudentService.showGradeInfoByPage(stuno, page, pageSize,week,month);
		System.out.println(result.getData());
		return result;
		
	}
	
	/*@RequestMapping("/trainstudent/searchgradebymonthPage")
	@ResponseBody
	public Result execute6(String cno,String month,Integer page,Integer pageSize){
		Result result=trainStudentService.showGradeInfoByMonthPage(cno, month, page, pageSize);
		System.out.println(result.getData());
		return result;
		
	}
	*/
	@RequestMapping("/trainstudent/searchgradebyconditionPage")
	@ResponseBody
	public Result execute7(String cno,Integer page,Integer pageSize,String month,String week,String stuno){
		Result result=trainStudentService.showGradeInfoByConditionPage(cno,page,pageSize,month,week,stuno);
		System.out.println(result.getData());
		return result;
		
	}
	
	@RequestMapping("/trainstudent/searchgradebyno")
	@ResponseBody
	public Result execute8(String stuno, String week, String month){
		Result result=trainStudentService.showGradeInfoByNo(stuno, week, month);
		System.out.println(result.getData());
		return result;
		
	}
	
	@RequestMapping("/teacher/searchgrade")
	@ResponseBody
	public Result execute9(String stuno, String stuclass, String major,
			Integer page, Integer pageSize, String month, String week){
		Result result=trainStudentService.findGardeInfo(stuno, stuclass, major, page, pageSize, month, week);
		System.out.println(result.getData());
		return result;
		
	}
}
