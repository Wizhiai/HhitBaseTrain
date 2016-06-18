/**
 * 
 */
package com.hhit.basetrain.controller.assess;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.AssessScoreService;

/**
 *@author hulijie
 * @date 2016-4-28t下午02:54:39
 * TODO
 */
@Controller
public class InsertScoreController {
	@Resource
	private AssessScoreService assessService;
	
	@RequestMapping("/assess/insertAssessScore")
	@ResponseBody
	public Result execute(float s11,float s12,float s13,float s21,float s22,float s23,float s24,float s25,float s26,float s27,float s31,float s32,float s33,float s34,float s35,
			float s36,float s41,float s42,float s43,float s44,float s45,float s51,float s52,float s53,float s54,float s55,float s61,float s62,float s63,float s64,float s65,float s66,int basetypeid,String userId,float allScore){
		System.out.println(s11);
		Result result = assessService.insertAssessScore(s11, s12, s13, s21, s22, s23, s24, s25, s26, s27, s31, s32, s33, s34, s35, s36, s41, s42, s43, s44, s45, s51, s52, s53, s54, s55, s61, s62, s63, s64, s65, s66,basetypeid,userId,allScore);
		System.out.println("wdw");
		return result;
		
	}
	
	@RequestMapping("/assess/getAssessScore")
	@ResponseBody
	public Result getAssessScore(){
		Result result = assessService.getAssessScore();
		System.out.println("wdw");
		return result;
		
	}
	
	@RequestMapping("/assess/insertAssessExpert")
	@ResponseBody
	public Result execute(String userName,String expertType){
		System.out.println(userName);
		Result result = assessService.insertAssessExpert(userName,expertType);

		return result;
		
	}
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/assess/insertComment")
	@ResponseBody
	public Result insertComment(String baseno,String content,String time,String userid){

		Result result = null;
		try {
			String sta = new String(content.getBytes("iso-8859-1"),"utf-8");
			 result = assessService.insertComment(userid,baseno,sta,time);
			System.out.println(sta  +"content");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		return result;
		
	}
	
	
}
