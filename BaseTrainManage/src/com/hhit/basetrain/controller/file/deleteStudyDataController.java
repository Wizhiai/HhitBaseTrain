package com.hhit.basetrain.controller.file;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.CourseCoachService;
import com.hhit.basetrain.util.DeleteFileUtil;
@Controller
public class deleteStudyDataController {
	@Resource
	private CourseCoachService courseCoachService;
	
	@RequestMapping("/file/deletefiledata")
	@ResponseBody
	public Result execute(String filename,Integer id){
		Result result=new Result();
		String path=Thread.currentThread()
	            .getContextClassLoader().getResource("").getPath(); 
		path+=File.separator+filename;
		boolean flag=DeleteFileUtil.DeleteFolder(path);
		if(flag){
			result.setStatus(1);
			result.setMsg("删除成功");
			courseCoachService.deleteCourseCoach(id);
			
		}else{
			result.setMsg("删除失败");
			result.setStatus(0);
		}
		return result;
	}
}
