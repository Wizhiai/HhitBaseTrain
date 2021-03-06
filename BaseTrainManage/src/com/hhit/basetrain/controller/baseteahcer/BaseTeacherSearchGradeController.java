/**
 * 
 */
package com.hhit.basetrain.controller.baseteahcer;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseTeacherService;

/**
 * @author Mayu
 * @date 2016-4-28t下午02:21:32
 * TODO
 */
@Controller
public class BaseTeacherSearchGradeController {
	@Resource
	private BaseTeacherService baseTeacherService;
	
	@RequestMapping("baseteacher/loadcno")
	@ResponseBody
	public Result execute(String tno){
		Result result=baseTeacherService.loadCnoInfo(tno);
		return result;
		
	}
	
}
