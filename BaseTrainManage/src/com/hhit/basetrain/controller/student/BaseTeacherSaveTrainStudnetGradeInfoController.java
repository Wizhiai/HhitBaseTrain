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
 * @date 2016-5-1t下午09:34:41
 * TODO
 */
@Controller
public class BaseTeacherSaveTrainStudnetGradeInfoController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("/trainstudent/saveGradeInfo")
	@ResponseBody
	public Result execute(String stuno, String tNo, String cno,
			String week, String month, Double grade){
				Result result=trainStudentService.saveTrainStudentInfo(stuno, tNo, cno, week, month, grade);
				return result;
			}
}
