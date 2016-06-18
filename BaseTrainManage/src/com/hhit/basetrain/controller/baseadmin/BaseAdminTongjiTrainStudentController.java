/**
 * 
 */
package com.hhit.basetrain.controller.baseadmin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TrainStudentService;

/**
 * @author Mayu
 * @date 2016-5-21t下午08:36:14
 * TODO
 */
@Controller
public class BaseAdminTongjiTrainStudentController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("baseadmin/counttrainstudent")
	@ResponseBody
	public Result execute(String manager_no){
		Result result=trainStudentService.countTrainStudentByCno(manager_no);
		System.out.println(result.getData());
		return result;
	}
	
	@RequestMapping("baseadmin/counttrainstudentdetail")
	@ResponseBody
	public Result execute(Integer base_no,String cno){
		Result result=trainStudentService.TrainStudentByCnoDetail(base_no, cno);
		System.out.println(result.getData());
		return result;
	}
	
	@RequestMapping("baseadmin/counttrainstudentbyclass")
	@ResponseBody
	public Result execute1(String manager_no){
		Result result=trainStudentService.countTrainStudentByClass(manager_no);
		System.out.println(result.getData());
		return result;
	}
	
	@RequestMapping("baseadmin/counttrainstudentclassdetail")
	@ResponseBody
	public Result execute1(Integer base_no,String base_class){
		Result result=trainStudentService.TrainStudentByClassDetail(base_no, base_class);
		System.out.println(result.getData());
		return result;
	}

}
