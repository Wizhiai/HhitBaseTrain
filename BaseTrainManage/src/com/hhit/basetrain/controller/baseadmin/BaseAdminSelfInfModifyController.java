/**
 * 
 */
package com.hhit.basetrain.controller.baseadmin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseAdminService;

/**
 * @author Jiya
 * @date 2016-4-23t下午05:11:25
 * 
 */
@Controller
public class BaseAdminSelfInfModifyController {

	@Resource
	private BaseAdminService baseAdminService;
	
	@RequestMapping("/baseadmin/loadSelfInf")
	@ResponseBody
	public Result execute(String manager_no){
		
		Result result = baseAdminService.showInf(manager_no);
		return result;
	}
	
	@RequestMapping("/baseadmin/modifySelfInf")
	@ResponseBody
	public Result execute(String manager_no,String manager_name,String manager_phone){
		
		Result result = baseAdminService.modifySelfInf(manager_no,manager_name,manager_phone);
		return result;
	}
}
