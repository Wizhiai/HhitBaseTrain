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
public class WorkSearchedController {
	@Resource
	private WorkService workService;
	@RequestMapping("work/finishedstudent")
	@ResponseBody
	public Result execute(String base_class, Integer base_no,
			String title, Integer page, Integer pageSize){
		Result result=workService.searchAllFinishedWork(base_class, base_no, title, page, pageSize);
		return result;
	}
	
	@RequestMapping("work/unfinishedstudent")
	@ResponseBody
	public Result execute1(String base_class, Integer base_no,
			String title, Integer page, Integer pageSize){
		Result result=workService.searchAllUnFinishedWork(base_class, base_no, title, page, pageSize);
		return result;
	}
}
