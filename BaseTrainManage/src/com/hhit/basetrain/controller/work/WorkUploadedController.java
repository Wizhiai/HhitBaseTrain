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
public class WorkUploadedController {
	@Resource
	private WorkService workService;
	
	@RequestMapping("work/showuploadwork")
	@ResponseBody
	public Result execute(String stuno, Integer page, Integer pageSize){
		Result result=workService.uploadedWork(stuno, page, pageSize);
		System.out.println(result.getData());
		return result;
		
	}
}
