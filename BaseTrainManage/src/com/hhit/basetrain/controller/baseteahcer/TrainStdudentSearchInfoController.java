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
 * @date 2016-4-25t下午05:57:21
 * TODO
 */
@Controller
public class TrainStdudentSearchInfoController {
	@Resource
	private BaseTeacherService baseTeacherservice;
	
	@RequestMapping("/baseteacher/search")
	@ResponseBody
	public Result execute(String t_name,String stuno,Integer page,Integer pageSize){
		Result result=baseTeacherservice.loadTeacherInfoPage(t_name, stuno, page, pageSize);
		return result;
		
	}
}
