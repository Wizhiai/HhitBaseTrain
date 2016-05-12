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
 * @date 2016-4-25t下午03:33:15
 * TODO
 */
@Controller
public class SearchTrainStudnetInfoController {
	@Resource
	private TrainStudentService trainStudentService;
	
	@RequestMapping("/trainstudent/loadTrainInfo")
	@ResponseBody
<<<<<<< HEAD
	public Result execute(String stno,String stuno){
		Result result=trainStudentService.showBaseInfo(stno,stuno);
=======
	public Result execute(String stno,String stuno,Integer page,Integer pageSize){
		Result result=trainStudentService.showBaseInfo(stno, stuno, page, pageSize);
		System.out.println(result.getData());
>>>>>>> ecb39c985cd60b39d06e28deb8b5783e9b248f5f
		
		return result;
		
	}
}
