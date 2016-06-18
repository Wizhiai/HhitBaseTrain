package com.hhit.basetrain.controller.baseteahcer;

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
public class BaseAdminDistributionTeacherController {
	@Resource
	private TeachingService teacherService;
	
	@RequestMapping("/teaching/saveteaching")
	@ResponseBody
	public Result execute(String cno, String base_class, String t_no){
		Result result=teacherService.saveTeaching(cno, base_class, t_no);
		return result;
		
		
	}
}
