package com.hhit.basetrain.controller.student;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
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
public class BaseAdminModifyTrainStudentController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("baseadmin/modifytrainstudent")
	@ResponseBody
	public Result execute(String stuno, String train_date,
			String base_class, String phone, String cno){
		System.out.println(stuno);
		Result result=trainStudentService.baseadminModifyInfo(stuno, train_date, base_class, phone, cno);
		return result;
	}
}
