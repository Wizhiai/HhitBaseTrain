/**
 * 
 */
package com.hhit.basetrain.controller.teaching;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TeachingService;

/**
 * @author Mayu
 * @date 2016-5-12t下午01:40:38
 * TODO
 */
@Controller
public class teachingLoadedFileController {
	@Resource
	private TeachingService teachingService;
	
	@RequestMapping("/teaching/showfile")
	@ResponseBody
	public Result execute(String t_no){
		Result result=new Result();
		result=teachingService.showFile(t_no);
		return result;
	}
	

	
}
