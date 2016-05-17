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
public class WorkLoadedController {
	@Resource
	private WorkService workService;
	
	@RequestMapping("work/showwork")
	@ResponseBody
	public Result execute(String base_class,Integer base_no,Integer page,Integer pageSize){
		Result result=workService.showWork(base_class, base_no, page, pageSize);
		System.out.println(result.getData());
		return result;
		
	}
}
