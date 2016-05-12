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
 * @date 2016-5-3t下午01:48:55
 * TODO
 */
@Controller
public class BaseTeacherModifyTrainStudentGradeController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("baseteacher/modifygrade")
	@ResponseBody
	public Result execute(int id,Double grade){
		Result result=trainStudentService.modifyTrainStudentInfo(id, grade);
		return result;
		
	}
}
