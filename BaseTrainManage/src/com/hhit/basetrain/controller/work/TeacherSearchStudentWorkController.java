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
public class TeacherSearchStudentWorkController {
	@Resource
	private WorkService workService;
	
	@RequestMapping("work/searchstudentwork")
	@ResponseBody
	public Result execute(String base_no, String stuno, Integer page,
			Integer pageSize){
		System.out.println(stuno);
		System.out.println(base_no);
		Result result=workService.searchStudentWork(base_no, stuno, page, pageSize);
		System.out.println(result.getData());
		return result;
		
	}
}
