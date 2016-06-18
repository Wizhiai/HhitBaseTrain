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
public class CommentsLoadedController {

	@Resource
	private WorkService workService;
	
	@RequestMapping("/work/loadcomments")
	@ResponseBody
	public Result execute(){
		Result result=workService.showComments();
		System.out.println(result.getData());
		return result;
		
	}
}
