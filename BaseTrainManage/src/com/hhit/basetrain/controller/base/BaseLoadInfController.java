/**
 * 
 */
package com.hhit.basetrain.controller.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseService;

/**
 * @author Jiya
 * @date 2016-4-24t上午11:30:08
 * 
 */
@Controller
public class BaseLoadInfController {

	@Resource
	private BaseService baseService;
	
	@RequestMapping("/base/searchByName")
	@ResponseBody
	public Result searchByName(String base_name){
		
		Result result = baseService.skimBaseInfByName(base_name);
		return result;
	}
	
	@RequestMapping("/base/searchByAddress")
	@ResponseBody
	public Result searchByAddress(String base_address){

		Result result = baseService.skimBaseInfByAddress(base_address);
		return result;
	}
	
	@RequestMapping("/base/searchByCourse")
	@ResponseBody
	public Result searchByCourse(String cname){
		
		Result result = baseService.skimBaseInfByCourse(cname);
		return result;
	}
	
	/**
	 * 显示所有基地部分信息
	 * @return
	 */
	@RequestMapping("/base/searchAll")
	@ResponseBody
	public Result searchAll(){
		
		Result result = baseService.skimAllBaseInf();
		return result;
	}
	
	@RequestMapping("/base/searchName")
	@ResponseBody
	public Result searchName(){
		
		Result result = baseService.showAllBaseName();
		return result;
	}
	
}
