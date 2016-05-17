/**
 * 
 */
package com.hhit.basetrain.controller.work;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.WorkService;


/**
 * @author Mayu
 * @date 2016-5-17t上午12:42:04
 * TODO
 */
@Controller
public class WorkPigaiController {
	@Resource
	private WorkService workService;
	@RequestMapping("work/btshowfinshedwork")
	@ResponseBody
	public Result execute(Integer base_no,String base_class,String title,Integer page,Integer pageSize){
		Result result=workService.showUploadWorks(base_no, base_class, title, page, pageSize);
		System.out.println(result.getData());
		return result;
		
	}
}
