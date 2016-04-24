/**
 * 
 */
package com.hhit.basetrain.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.AdminService;

/**
 * @author Jiya
 * @date 2016-4-24t上午11:30:08
 * 
 */
@Controller
public class AdminLoadSelfInfController {

	@Resource
	private AdminService adminService;
	
	@RequestMapping("/admin/loadSelfInf")
	@ResponseBody
	public Result execute(String no){
		
		Result result = adminService.showInf(no);
		return result;
	}
	
	@RequestMapping("/admin/findName")
	@ResponseBody
	public Result searchName(String no){
		Result result = adminService.showName(no);
		return result;
	}
	
}
