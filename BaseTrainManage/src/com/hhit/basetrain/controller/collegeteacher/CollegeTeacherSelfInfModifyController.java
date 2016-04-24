/**
 * 
 */
package com.hhit.basetrain.controller.collegeteacher;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.CollegeTeacherService;

/**
 * @author Jiya
 * @date 2016-4-23t下午05:11:25
 * 
 */
@Controller
public class CollegeTeacherSelfInfModifyController {

	@Resource
	private CollegeTeacherService collegeTeacherService;
	
	@RequestMapping("/collegeteacher/loadSelfInf")
	@ResponseBody
	public Result execute(String ct_no){
		
		Result result = collegeTeacherService.showInf(ct_no);
		System.out.println(result.getData().toString());
		return result;
	}
	
	@RequestMapping("/collegeteacher/modifySelfInf")
	@ResponseBody
	public Result execute(String ct_no,String ct_name,String ct_birthday,String ct_sex,String academy_no,String ct_phone,String ct_profession){
		
		Result result = collegeTeacherService.modifySelfInf(ct_no,ct_name,ct_birthday,ct_sex,academy_no,ct_phone,ct_profession);
		return result;
	}
}
