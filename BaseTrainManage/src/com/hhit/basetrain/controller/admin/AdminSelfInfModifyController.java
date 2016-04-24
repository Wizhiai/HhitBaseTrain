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
 * @date 2016-4-23t下午05:11:25
 * 
 */
@Controller
public class AdminSelfInfModifyController {

	@Resource
	private AdminService adminService;
	
	@RequestMapping("/admin/loadSelfInf")
	@ResponseBody
	public Result execute(String no){
		
		Result result = adminService.showInf(no);
		return result;
	}
	
	@RequestMapping("/admin/modifySelfInf")
	@ResponseBody
	public Result execute(String no,String name,String phone){
		
		Result result = adminService.modifySelfInf(no,name,phone);
		return result;
	}
}
