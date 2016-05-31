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
import com.hhit.basetrain.service.UserService;

/**
 * @author Mayu
 * @date 2016-5-19t下午01:34:44
 * TODO
 */
@Controller
public class BaseAdminAddBaseTeacherController {
	@Resource
	private BaseTeacherService baseTeacherService;
	
	@RequestMapping("baseadmin/addBaseTeacher")
	@ResponseBody
	public Result execute(String t_no, String t_name, String t_sex,
			String t_phone, String t_profession, Integer base_no,String identity){
		Result result=baseTeacherService.inputBaseTeacher(t_no, t_name, t_sex, t_phone, t_profession, base_no,identity);
		return result;
	}
	
}
