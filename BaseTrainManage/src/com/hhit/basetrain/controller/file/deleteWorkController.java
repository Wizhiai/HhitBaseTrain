package com.hhit.basetrain.controller.file;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.TeachingService;
import com.hhit.basetrain.service.WorkService;
import com.hhit.basetrain.util.DeleteFileUtil;

/**
 * 
 * @author mayu
 */
@Controller
public class deleteWorkController {
	@Resource
	private WorkService workService;
	
	@RequestMapping("/work/deletework")
	@ResponseBody
	public Result execute(String filename,String wid){
		Result result=new Result();
		String path=Thread.currentThread()
	            .getContextClassLoader().getResource("").getPath(); 
		path+=File.separator+filename;
		boolean flag=DeleteFileUtil.DeleteFolder(path);
		if(flag){
			workService.deleteWork(wid);
			result.setStatus(1);
			result.setMsg("删除成功");
			
		
		}else{
			result.setMsg("删除失败");
			result.setStatus(0);
		}
		return result;
	}
}
