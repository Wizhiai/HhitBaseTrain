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
 * @author Mayu
 * @date 2016-5-16t下午11:13:05
 * TODO
 */
@Controller
public class deleteFileController {
	/*@Resource
	private WorkService workService;*/
	@RequestMapping("/work/deleteworkfile")
	@ResponseBody
	public Result execute(String filename){
		System.out.println(filename);
		Result result=new Result();
		String path=Thread.currentThread()
	            .getContextClassLoader().getResource("").getPath(); 
		path+=File.separator+filename;
		boolean flag=DeleteFileUtil.DeleteFolder(path);
		if(flag){
			//workService.deleteUploadedwork(stuno, wid);
			System.out.println(1);
			result.setStatus(1);
			result.setMsg("删除成功");
		}else{
			result.setMsg("删除失败");
			result.setStatus(0);
		}
		return result;
	}
}
