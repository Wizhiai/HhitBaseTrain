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
	
	/**
	 * 显示所有基地部分信息
	 * @return
	 */
	@RequestMapping("/base/searchAllBase")
	@ResponseBody
	public Result searchAllBase(){
		
		Result result = baseService.searchAllBase();
		return result;
	}
	
	
	
	/**
	 * 通过基地号搜索基地基本信息
	 * @return
	 */
	@RequestMapping("/base/searchByBaseNo")
	@ResponseBody
	public Result searchBaseBasicInfo(String base_no){
		
		Result result = baseService.showBaseBasicInfoByNo(base_no);
		return result;
	}
	/**
	 * 通过基地号搜索基地建设与管理状况
	 * @return
	 */
	@RequestMapping("/base/searchBuildByBaseNo")
	@ResponseBody
	public Result searchBaseBuildInfo(String base_no){
		
		Result result = baseService.showBaseBuildInfoByNo(base_no);
		return result;
	}
	/**
	 * 通过基地号搜索基地场地与设施条件
	 * @return
	 */
	@RequestMapping("/base/searchFieldByBaseNo")
	@ResponseBody
	public Result searchBaseFieldInfo(String base_no){
		
		Result result = baseService.showBaseFieldInfoByNo(base_no);
		return result;
	}
	/**
	 * 通过基地号搜索基地实训项目目标及内容
	 * @return
	 */
	@RequestMapping("/base/searchContentByBaseNo")
	@ResponseBody
	public Result searchBaseContentInfo(String base_no){
		
		Result result = baseService.showBaseContentInfoByNo(base_no);
		return result;
	}
	/**
	 * 通过基地号搜索基地教师与辅导队伍
	 * @return
	 */
	@RequestMapping("/base/searchCoachByBaseNo")
	@ResponseBody
	public Result searchBaseCoachInfo(String base_no){
		
		Result result = baseService.showBaseCoachInfoByNo(base_no);
		return result;
	}
	/**
	 * 通过基地号搜索基地科研与技术活动
	 * @return
	 */
	@RequestMapping("/base/searchResearchByBaseNo")
	@ResponseBody
	public Result searchBaseResearchInfo(String base_no){
		
		Result result = baseService.showBaseResearchInfoByNo(base_no);
		return result;
	}
	/**
	 * 通过基地号搜索基地实践效果与能力开发
	 * @return
	 */
	@RequestMapping("/base/searchEffectByBaseNo")
	@ResponseBody
	public Result searchBaseEffectInfo(String base_no){
		
		Result result = baseService.showBaseEffectInfoByNo(base_no);
		return result;
	}
	/**
	 * 通过基地号搜索基地企业联盟
	 * @return
	 */
	@RequestMapping("/base/searchAllianceByBaseNo")
	@ResponseBody
	public Result searchBaseAllianceInfo(String base_no){
		
		Result result = baseService.showBaseAllianceInfoByNo(base_no);
		return result;
	}
	/**
	 * 通过基地号搜索基地特色
	 * @return
	 */
	@RequestMapping("/base/searchAdvantageByBaseNo")
	@ResponseBody
	public Result searchBaseAdvantageInfo(String base_no){
		
		Result result = baseService.showBaseAdvantageInfoByNo(base_no);
		return result;
	}
}
