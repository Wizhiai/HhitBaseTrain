package com.hhit.basetrain.controller.traincourse;

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
public class BaseAdminInputStudentController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("trainstudent/inputinfo")
	@ResponseBody
	public Result execute(String stuno, String stu_name,
			String stu_sex, String stu_class, String major, String phone,
			Integer enter_year, String birthday, Integer base_no,
			String base_class, String cno, String address, String train_date){
		Result result=trainStudentService.InputTrainStudent(stuno, stu_name, stu_sex, stu_class, major, phone, enter_year, birthday, base_no, base_class, cno, address, train_date);
		return result;
	}

}
