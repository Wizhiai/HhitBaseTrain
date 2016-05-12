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
 * @date 2016-5-3t下午06:30:10
 * TODO
 */
@Controller
public class TeacherSearchTrainStudentInfoController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("/teacher/searchtrainstudent")
	@ResponseBody
	public Result execute(String stuno, String stuclass, String major,
			Integer page, Integer pageSize){
		Result result=trainStudentService.findTrainInfo(stuno, stuclass, major, page, pageSize);
		return result;
	}
}
