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
 * @date 2016-4-24t上午11:30:08
 * 
 */
@Controller
public class BaseAdminLoadSelfInfController {

	@Resource
	private BaseAdminService baseAdminService;
	
	@RequestMapping("/baseadmin/loadSelfInf")
	@ResponseBody
	public Result execute(String manager_no){
		
		Result result = baseAdminService.showInf(manager_no);
		return result;
	}
	
	@RequestMapping("/baseadmin/findName")
	@ResponseBody
	public Result searchName(String manager_no){
		Result result = baseAdminService.showName(manager_no);
		return result;
	}
	
}
