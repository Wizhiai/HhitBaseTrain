package com.hhit.basetrain.controller.teaching;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TeachingService;
/**
 * 
 * @author mayu
 */
@Controller
public class BaseClassLoadedController {
	@Resource
	private TeachingService teachingService;
	
	@RequestMapping("/teaching/searchclass")
	@ResponseBody
	public Result execute(String base_no){
		Result result=teachingService.showBaseClass(base_no);
		return result;
	}
}
