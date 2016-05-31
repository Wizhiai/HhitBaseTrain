package com.hhit.basetrain.controller.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TrainStudentService;

/**
 * 
 * @author mayu
 */
@Controller
public class BaseAdminDeleteController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("baseadmin/deletestudent")
	@ResponseBody
	public Result execute(String stuno){
		Result result=trainStudentService.deleteStudentInfo(stuno);
		return result;
		
	}
}
