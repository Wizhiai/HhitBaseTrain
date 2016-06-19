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
 * @date 2016-5-3t下午05:14:33
 * TODO
 */
@Controller
public class BaseTeacherLoadSelInfoController {
	@Resource
	private BaseTeacherService baseTeacherService;
	
	@RequestMapping("/baseteacher/loadselfinfo")
	@ResponseBody
	 public Result execute(String tno){
		 Result result=baseTeacherService.loadSelInfo(tno);
		 return result;
		 
	 }
	
}
