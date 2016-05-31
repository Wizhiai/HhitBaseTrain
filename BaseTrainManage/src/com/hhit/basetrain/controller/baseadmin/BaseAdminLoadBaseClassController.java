package com.hhit.basetrain.controller.baseadmin;

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
public class BaseAdminLoadBaseClassController {
	@Resource
	private TrainStudentService trainServiceService;
	
	@RequestMapping("baseadmin/loadclass")
	@ResponseBody
	public Result execute(String manager_no){
		System.out.println(manager_no);
		Result result=trainServiceService.loadBaseClass(manager_no);
		System.out.println(result.getData());
		return result;
	}
	
	
}
