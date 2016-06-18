/**
 * 
 */
package com.hhit.basetrain.controller.admin;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
