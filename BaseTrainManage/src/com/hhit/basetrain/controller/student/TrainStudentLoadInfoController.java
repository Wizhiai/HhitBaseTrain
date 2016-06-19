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
 * @date 2016-4-25t下午12:51:02
 * TODO
 */
@Controller
public class TrainStudentLoadInfoController {
	@Resource
	private TrainStudentService studentservice;
	
	@RequestMapping("/trainstudnet/load")
	@ResponseBody
	public Result execute(String sno){
		Result result=studentservice.showInfo(sno);
		return result;
	}
	
	@RequestMapping("/trainstudnet/loadBaseName")
	@ResponseBody
	public Result execute1(String sno){
		Result result=studentservice.showBaseName(sno);
		return result;
	}
	
	

}
