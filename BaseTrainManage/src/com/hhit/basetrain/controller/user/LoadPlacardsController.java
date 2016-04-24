/**
 * 
 */
package com.hhit.basetrain.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.PlacardService;

/**
 * @author Mayu
 * @date 2016-4-24t上午09:37:23
 * TODO
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
	

}
