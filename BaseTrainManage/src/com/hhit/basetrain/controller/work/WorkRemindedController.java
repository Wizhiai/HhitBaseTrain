package com.hhit.basetrain.controller.work;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.WorkService;

@Controller
public class WorkRemindedController {
	@Resource
	private WorkService workService;
	
	@RequestMapping("work/remind")
	@ResponseBody
	public Result execute(String title, String stuno, String t_no){
		
		Result result=workService.remindWork(title, stuno, t_no);
		return result;
	}
	
	@RequestMapping("work/gainremind")
	@ResponseBody
	public Result execute(String stuno){
		Result result=workService.gainRemind(stuno);
		return result;
	}
}
