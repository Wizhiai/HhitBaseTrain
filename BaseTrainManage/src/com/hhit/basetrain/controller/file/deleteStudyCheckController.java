package com.hhit.basetrain.controller.file;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TeachingService;
import com.hhit.basetrain.util.DeleteFileUtil;
@Controller
public class deleteStudyCheckController {
	@Resource
	private TeachingService teachingService;
	
	@RequestMapping("/file/deletefilecheck")
	@ResponseBody
	public Result execute(String filename,String cno,String studycheck,String t_no){
		Result result=new Result();
		String path=Thread.currentThread()
	            .getContextClassLoader().getResource("").getPath(); 
		path+=File.separator+filename;
		boolean flag=DeleteFileUtil.DeleteFolder(path);
		if(flag){
			result.setStatus(1);
			result.setMsg("删除成功");
			teachingService.saveStudyCheck(cno, studycheck,t_no);
		}else{
			result.setMsg("删除失败");
			result.setStatus(0);
		}
		return result;
	}
}
