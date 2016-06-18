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
 * @date 2016-5-1t下午12:50:31
 * TODO
 */
@Controller
public class BaseTeacherLoadTrainStudentInfoController {
	@Resource
	TrainStudentService trainStudentService;
	
	@RequestMapping("baseteacher/loadInfo")
	@ResponseBody
	public Result execute(String stuname,String tno,Integer page,Integer pageSize){
		Result result =trainStudentService.loadTrainStudnetInfoByPage(stuname,tno, page, pageSize);
		System.out.println(result.getData());
		return result;
	}
}
