/**
 * 
 */
package com.hhit.basetrain.controller.score;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.ScoreService;

/**
 * @author Mayu
 * @date 2016-5-10t下午12:56:02
 * TODO
 */
@Controller
public class ScoreExamNamegainedController {
	@Resource
	private ScoreService scoreService;
	
	@RequestMapping("gainExam")
	@ResponseBody 
	public Result execute(String stuno, String week, String month){
		Result result=scoreService.gainExampper(stuno, week, month);
		System.out.println(result.getData());
		return result;
		
	}
	
}
