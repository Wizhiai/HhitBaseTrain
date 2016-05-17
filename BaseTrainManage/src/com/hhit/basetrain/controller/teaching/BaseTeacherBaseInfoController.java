package com.hhit.basetrain.controller.teaching;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TeachingService;

@Controller
public class BaseTeacherBaseInfoController {
	@Resource
	private TeachingService teachingService;
	
	@RequestMapping("teaching/showbaseinfo")
	@ResponseBody
	public Result execute(String t_no){
		Result result=teachingService.showBaseByTno(t_no);
		return result;
	}
}
