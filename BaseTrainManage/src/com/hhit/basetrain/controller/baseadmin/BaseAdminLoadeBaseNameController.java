/**
 * 
 */
package com.hhit.basetrain.controller.baseadmin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseAdminService;

/**
 * @author Mayu
 * @date 2016-5-19t下午03:53:46
 * TODO
 */
@Controller
public class BaseAdminLoadeBaseNameController {
	@Resource
	private BaseAdminService baseAdminService;
	@RequestMapping("baseadmin/loadbaseName")
	@ResponseBody
	public Result execute(String manager_no){
		Result result=baseAdminService.showBaseNameByNo(manager_no);
		return result;
		
	}
}
