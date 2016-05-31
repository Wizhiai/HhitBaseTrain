/**
 * 
 */
package com.hhit.basetrain.controller.baseteahcer;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseTeacherService;

/**
 * @author Mayu
 * @date 2016-5-20t上午10:59:09
 * TODO
 */
@Controller
public class BaseAdminSearchBaseTeacherInfoController {
	@Resource
	private BaseTeacherService  baseTeacherService;
	
	@RequestMapping("/baseteacher/showinfo")
	@ResponseBody
	public Result execute(String tNo, String managerNo){
		Result result=baseTeacherService.showBaseTeacherInfo(tNo, managerNo);
		return result;
	}
	
	@RequestMapping("/baseteacher/showname")
	@ResponseBody
	public Result execute1(String base_no){
		Result result=baseTeacherService.showBaseTeacherName(base_no);
		return result;
	}
}
