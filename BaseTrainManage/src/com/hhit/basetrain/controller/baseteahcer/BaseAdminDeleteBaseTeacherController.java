package com.hhit.basetrain.controller.baseteahcer;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseTeacherService;

/**
 * 
 * @author mayu
 */
@Controller
public class BaseAdminDeleteBaseTeacherController {
	@Resource
	private BaseTeacherService baseTeacherService;
	@RequestMapping("delete")
	@ResponseBody
	public Result execute(String tNo){
		Result result=baseTeacherService.deleteBaseTeacherByNo(tNo);
		return result;
	}
	

	
}
