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
 * @date 2016-5-3t下午02:29:45
 * TODO
 */
@Controller
public class BaseTeacherDeleteTrainStudentGradeController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("baseteacher/deletegrade")
	@ResponseBody
	public Result execute(String id){
		Result result=trainStudentService.deleteTrainStudentGradeInfo(id);
		return result;
		
	}
}
