/**
 * 
 */
package com.hhit.basetrain.controller.placard;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.PlacardService;

/**
 * @author Mayu
 * @date 2016-4-24t上午09:37:23
 * 
 */
@Controller
public class LoadPlacardsController {
	@Resource
	private PlacardService placardService;
	
	@RequestMapping("/load")
	@ResponseBody
	public Result execute(String id){
		Result result=placardService.loadPlacard(id);
		System.out.println(1);
		return result;
		
	}
	@RequestMapping("/loadschoolPlacard")
	@ResponseBody
	public Result execute1(){
		Result result=placardService.loadSchoolPlacard();
		System.out.println(1);
		return result;
	}
	
	@RequestMapping("/loadstudentPlacard")
	@ResponseBody
	public Result execute2(String id){
		Result result=placardService.loadstudentPlacard(id);
		return result;
	}
	
	@RequestMapping("/question/searchAll")
	@ResponseBody
	public Result searchAllQuestion(){
		
		Result result=placardService.skimAllQuestionInf();
		return result;
	}
	
	@RequestMapping("/question/searchByBaseNo")
	@ResponseBody
	public Result searchQuestionByBaseNo(String base_no){
		
		Result result=placardService.skimQuestionInfByBaseNo(base_no);
		return result;
	}
	
	@RequestMapping("/question/searchByPlacardNo")
	@ResponseBody
	public Result searchQuestionByPlacardNo(String placard_no){
		
		Result result=placardService.showQuestionInfByPlacardNo(placard_no);
		return result;
	}
	
	@RequestMapping("/schoolPlacard/searchAll")
	@ResponseBody
	public Result searchschoolPagePlacard(){
		
		Result result=placardService.showAllSchoolInf();
		return result;
	}
	
	@RequestMapping("/schoolPlacard/searchByPlacardNo")
	@ResponseBody
	public Result searchschoolPlacardByNo(String placard_no){
		
		Result result=placardService.showSchoolPlacardInfByPlacardNo(placard_no);
		return result;
	}
	@RequestMapping("/schoolPlacard/addPlacard")
	@ResponseBody
	public Result addschoolPlacard(String placard_title,String placard_content,String publish_author){
		
		Result result=placardService.addSchoolPlacard(placard_title, placard_content, publish_author);
		return result;
	}
	
	@RequestMapping("/schoolPlacard/findSchoolPlacardByTitle")
	@ResponseBody
	public Result isschoolPlacardExit(String placard_title){
		
		Result result=placardService.isSchoolPlacardExit(placard_title);
		return result;
	}
	@RequestMapping("/schoolPlacard/searchSchoolPlacardByTitle")
	@ResponseBody
	public Result searchschoolPlacardByTitle(String placard_title){
		
		Result result=placardService.searchSchoolPlacardByTitle(placard_title);
		return result;
	}
	@RequestMapping("/schoolPlacard/updateSchoolPlacardByNo")
	@ResponseBody
	public Result searchschoolPlacardByTitle(String placard_no,String placard_title,String placard_content,String publish_author){
		
		Result result=placardService.modifySchoolPlacard(placard_no, placard_title, placard_content, publish_author);
		return result;
	}
	@RequestMapping("/schoolPlacard/deleteSchoolPlacardByNo")
	@ResponseBody
	public Result deleteschoolPlacardByTitle(String placard_no){
		
		Result result=placardService.deleteSchoolPlacard(placard_no);
		return result;
	}
}
