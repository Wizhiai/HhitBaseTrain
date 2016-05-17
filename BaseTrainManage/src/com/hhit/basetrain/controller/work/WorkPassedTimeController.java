package com.hhit.basetrain.controller.work;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.WorkService;

/**
 * 
 * @author mayu
 */
@Controller
public class WorkPassedTimeController {
	@Resource
	private WorkService workService;
	
	@RequestMapping("work/showpasstimework")
	@ResponseBody
	public Result execute(String stuno, String base_class,
			Integer base_no, Integer page, Integer pageSize, String currentDate){
		Result result=workService.searchUfinishedWorkPass(stuno, base_class, base_no, page, pageSize, currentDate);
		System.out.println(result.getData());
		return result;
		
	}
}
