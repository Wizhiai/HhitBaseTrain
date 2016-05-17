/**
 * 
 */
package com.hhit.basetrain.controller.traincourse;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TrainCourseService;

/**
 * @author Mayu
 * @date 2016-5-12t上午10:57:22
 * TODO
 */
@Controller
public class TrainCourseLoadInfoByTnoController {
	@Resource
	private TrainCourseService trainCourseService;
	
	@RequestMapping("/traincourse/loadTrainCourse")
	@ResponseBody
	public Result execute(String t_no){
		Result result=trainCourseService.loadTrainCourseInfo(t_no);
		return result;
	}
}
