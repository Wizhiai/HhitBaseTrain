/**
 * 
 */
package com.hhit.basetrain.controller.assess;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.AssessScoreService;
import com.hhit.basetrain.service.UserService;
import com.hhit.love.greatHtml;
import com.hhit.love.mail.sendMail;

/**
 *@author hulijie
 * @date 2016-5-18t上午10:19:15
 * TODO
 */
@Controller
public class QueryUsersController {
	@Resource
	private UserService assessService;
	@Resource
	private AssessScoreService expertService;
	
	@RequestMapping("/assess/queryUser")
	@ResponseBody
	
	public Result query(){
		
		
		System.out.println("ss");
		
		
//		Result result = assessService.findAllUser();
		
		
	
		Result result = assessService.findAllUser();
		
		System.out.println("wdw");
		return result;
	}
	
	
	
	@RequestMapping("/assess/findByName")
	@ResponseBody
	public Result searchName(String no){
		System.out.println("1");
		Result result = assessService.findByNames(no);
		return result;
	}
	
	
	@RequestMapping("/assess/findByType")
	@ResponseBody
	public Result searchByType(String type){
		System.out.println("1"+type);
		Result result = assessService.findByType(type);
		return result;
	}
	@RequestMapping("/assess/findAssessByType")
	@ResponseBody
	public Result findAssessByType(String type){
		System.out.println("1"+type);
		Result result = expertService.findAssessByType(type);
		return result;
	}
	//查找专家库专家
	@RequestMapping("/assess/findAllExpert")
	@ResponseBody
	public Result findAllExpert(){
		System.out.println("1");
		Result result = expertService.findAllExpert();
		System.out.println("11");
		return result;
	}
//	查找专家委员会
	
	
	@RequestMapping("/assess/findAllassessExpert")
	@ResponseBody
	public Result findAllassessExpert(){
		System.out.println("1");
		Result result = expertService.findAllassessExpert();
		System.out.println("11");
		return result;
	}
	
//	查找评论
	
	
	@RequestMapping("/assess/findAllComment")
	@ResponseBody
	public Result findAllComment(String baseno){
		System.out.println("1");
//		try {
//			String mailUrlhref = "<a href="+"\91youzhi.com"+"ta为你写的表白信息请查看!"+"</a>";
//			sendMail.sendEmail("630806244@qq.com", "您有新的表白消息","ILOVEYOU!");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		   try {
//			greatHtml.creatTxtFile();
//			greatHtml.readTxtFile();  
//			greatHtml.replaceWithStrs("欧巴", "胡礼节", "2012,9,5", "很好的人。真的很不错","");
//			greatHtml.writeTxtFile("");//   
////			greatHtml.replaceTxtByStr("2", "0");  
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}   
//////	  
		System.out.println(baseno+"baseno");
		Result result = expertService.findAllComment(baseno);
		System.out.println("11");
		return result;
	}
	
	
		@RequestMapping("/assess/findCommentByBasenoAndEmotion")
		@ResponseBody
		public Result findAllComment(String baseno,String emotion){
			System.out.println("emotion");
			System.out.println(baseno+"baseno");
			Result result = expertService.findCommentByBasenoAndEmotion(Integer.parseInt(baseno) ,Integer.parseInt(emotion));
			System.out.println("11");
			return result;
		}
		
	@RequestMapping("/assess/inserttoAssessExpert")
	@ResponseBody
	public Result inserttoAssessExpert(String userName,String experType){
		System.out.println("1"+userName+experType);
		Result result = expertService.inserttoAssessExpert(userName,experType);
		System.out.println("11");
		return result;
	}
	
	
	

		@RequestMapping("/assess/insertVideo")
		@ResponseBody
		public Result insertVideo(String userName,String url){
			System.out.println("1"+userName+url);
			Result result = expertService.insertVideo(userName,url);
			System.out.println("11");
			return result;
		}
		
	
	@RequestMapping("/assess/deleteExpertByUsernName")
	@ResponseBody
	public Result deleteExpertByUsernName(String userName){
		
		Result result = expertService.deleteExpertByUsernName(userName);
		
		return result;
	}
	
	
	@RequestMapping("/assess/deleteassessExpertByUsernName")
	@ResponseBody
	public Result deleteassessExpertByUsernName(String userName){
		
		Result result = expertService.deleteassessExpertByUsernName(userName);
		
		return result;
	}
	
	
		@RequestMapping("/assess/findAssessExpertByName")
		@ResponseBody
		public Result findAssessExpertByName(String userName){
			System.out.println("----");
			Result result = expertService.findAssessExpertByName(userName);
			System.out.println("+++");
			System.out.println(result);
			return result;
		}
		@RequestMapping("/assess/appointmentOfDirector")
		@ResponseBody
		public Result appointmentOfDirector(String userName,String position){
			
			Result result = expertService.appointmentOfDirector(userName,position);
			
			return result;
		}
		
		@RequestMapping("/assess/assessLogin")
		@ResponseBody
		public Result assessLogin(String userName,String passWord){
			System.out.println("----");
			Result result = expertService.assessLogin(userName,passWord);
			System.out.println("+++");
			System.out.println(result);
			return result;
		}
		
		@RequestMapping("/assess/testLogin")
		@ResponseBody
		public Result testLogin(){
			System.out.println("----");
			Result result = expertService.assessLogin("10010","123");
			System.out.println("+++");
			System.out.println(result);
			return result;
		}
	//sendLove
		@RequestMapping("/sendLove")
		@ResponseBody
		public Result sendLove(String email,String toWho,String yourName,String meetTime,String content,String musicUrl){
			String sendContentString = "";
		
			if (content.equals("")) {
				content = "";
			}else{
				
				content = MyReplace(content);
				sendContentString = content.substring(0, content.length()/2);
			}
		
			if (yourName.equals("你的名字(可不填即匿名)")) {
				yourName = "一直守护着你的人";
			}
		int p =	(int)(1+Math.random()*(999999999-1+1));
		String pathString ="C:/apache-tomcat-7.0.69-windows-x64/apache-tomcat-7.0.69/webapps/BaseTrainManage/love/"+String.valueOf(p)+".html";
			   try {
				greatHtml.creatTxtFile(pathString);
				greatHtml.readTxtFile();  
				greatHtml.replaceWithStrs(toWho,yourName, meetTime, content,musicUrl);
				greatHtml.writeTxtFile("");//   
//				greatHtml.replaceTxtByStr("2", "0");  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
				Result result = new Result();
				 String con ="";
			try {
				 con = pathString.replaceAll("C:/apache-tomcat-7.0.69-windows-x64/apache-tomcat-7.0.69/webapps/BaseTrainManage/love/","91youzhi.com:8888/BaseTrainManage/love/");
				String mailUrlhref = "<a href=\"http://"+con+"\">ta为你写的具体表白信息请点击查看(请用电脑查看，手机没有酷炫效果)!"+con+"</a>"+sendContentString;
				 StringBuffer theMessage = new StringBuffer();
		         theMessage.append(mailUrlhref);
		   
				 sendMail.sendEmail(email,toWho+ "，您有一份表白消息",theMessage.toString());
				 String s="http://"+con;
				result.setData(s);
				result.setStatus(1);
				result.setMsg(s);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				
			
				result.setStatus(0);
				result.setMsg("发送失败");
				e.printStackTrace();
			}
			
			System.out.println("11");
			return result;
		}
		public String MyReplace(String mystr)
		{
		if(mystr == null || mystr == "" )
		{
		return("&nbsp;");
		}
		else
		{
			mystr = mystr.replace("\n","<br>");
		mystr = mystr.replace("\n\r","<br>");
		mystr = mystr.replace("\r","<br>");
		mystr = mystr.replace("\t","　　");
		return(mystr);
		}
		}
	
}
