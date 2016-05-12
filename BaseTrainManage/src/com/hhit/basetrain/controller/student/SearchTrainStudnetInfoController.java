/**
 * 
 */
package com.hhit.basetrain.controller.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.dao.TrainStudentDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TrainStudentService;

/**
 * @author Mayu
 * @date 2016-4-25t下午03:33:15
 * TODO
 */
@Controller
public class SearchTrainStudnetInfoController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("/trainstudent/loadTrainInfo")
	@ResponseBody
	public Result execute(String stno,String stuno,Integer page,Integer pageSize){
		Result result=trainStudentService.showBaseInfo(stno, stuno, page, pageSize);
		System.out.println(result.getData());
		
		return result;
		
	}
}
