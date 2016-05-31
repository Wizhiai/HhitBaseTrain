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
 * @date 2016-5-3t下午05:46:17
 * TODO
 */
@Controller
public class BaseTeacherModifySelfInfoController {
	@Resource
	private BaseTeacherService baseTeacherService;
	
	@RequestMapping("/baseteacher/modifyselfInfo")
	@ResponseBody
	public Result execute(String tname, String sex, String phone,String tno,String profession){
		Result result=baseTeacherService.modifySelInfo(tname, sex, phone,tno,profession);
		return result;
		
	}
	
	
	
}
