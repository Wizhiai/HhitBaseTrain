/**
 * 
 */
package com.hhit.basetrain.controller.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.ScoreService;



/**
 * @author Mayu
 * @date 2016-5-4t下午01:46:10
 * TODO
 */
@Controller
public class uploadFileController {
	@Resource
	private ScoreService scoreService;
	
	/*@RequestMapping("/uploadfile.do")
	@ResponseBody
	public Result upload(
		      HttpServletRequest request) throws IOException{
		try{
			Map<String,String> map=new HashMap<String,String>();
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setRepository(new File(Thread.currentThread()
		            .getContextClassLoader().getResource("").getPath()
		            + "download"));
			ServletFileUpload upload=new ServletFileUpload(factory);
			upload.setSizeMax(2000000); //设置缓冲区大小
			List parseRequest = upload.parseRequest(request);
			List<FileItem> items=parseRequest;
			System.out.println(items);
			for(FileItem item:items){
				
					System.out.println(item.getFieldName());
					//map.put(item.getFieldName(), item.getString());
			}
			Set<String> s=map.keySet();
			System.out.println(s);
			String stuno=map.get("stuno");
			String month=map.get("month");
			String week=map.get("week");
			System.out.println(stuno);
			Result result=new Result();
			String path=Thread.currentThread()
            .getContextClassLoader().getResource("").getPath()
            + "download" + File.separator;
			MultipartFile file;
			String filename;
			filename=((MultipartFile) file).getOriginalFilename();//获取上传文件的原名
			filename=new String(filename.getBytes("ISO8859-1"),"utf-8");
			String path1=path+filename;
			File targetfile=new File(path1);
			 if (!targetfile.exists()) {
				 targetfile.mkdirs();
			  }
			 file.transferTo(targetfile);
			 result.setStatus(0);
			 result.setMsg("上传成功");
			 result.setData(filename);
			 //model.addAttribute("upload.message", request.getContextPath() + "/upload/" + filename);
			 return result;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
		
	}*/
	
	@RequestMapping("/uploadfile.do")
	@ResponseBody
	 public Object uploadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {  
		//ModelAndView mav=new ModelAndView();
		Map<String,String> map=new HashMap<String,String>();
	        String path = Thread.currentThread()
            .getContextClassLoader().getResource("").getPath(); 
	        File file = new File(path);  
	        if (!file.exists()) {  
	            file.mkdirs();  
	        }  
	        //获取图片url地址  
	        String fileName = "";// 文件名称 
	        Result result = null;
	        /**上传文件处理内容**/  
	        DiskFileItemFactory factory = new DiskFileItemFactory();  
	        ServletFileUpload sfu = new ServletFileUpload(factory);  
	        sfu.setHeaderEncoding("UTF-8"); // 处理中文问题  
	        sfu.setSizeMax(1024 * 1024); // 限制文件大小  
	        try {  
	            List<FileItem> fileItems = sfu.parseRequest(request); // 解码请求  
	            for (FileItem fi : fileItems) {  
	            	if(fi.isFormField()){
	            		map.put(fi.getFieldName(),fi.getString("utf-8") );
	            		/*System.out.println(fi.getFieldName());
	            		System.out.println(fi.getString());*/
	            	}
	            	else{
	            		fileName = "download"+File.separator+UUID.randomUUID() + fi.getName().substring(fi.getName().lastIndexOf("."), fi.getName().length());  
	            		fi.write(new File(path, fileName));  
	            	}
	            	
	            }  
	            String stuno=map.get("stuno");
	            String week=map.get("week");
	            String month=map.get("month");
	            String exampaper=fileName;
	            result=scoreService.saveExampper(stuno, week, month, exampaper);
	           // response.sendRedirect("html/JDT_uploadexampper.jsp");
	        } catch (Exception e) {  
	            e.printStackTrace(); 
	            System.out.println("文件上传出错");
	        }  
	        if(result.getStatus()==1){
	              return "<script>window.parent.uploadSucced();</script>";
	              
        }else{
	             return "<script>window.parent.uploadFailed();</script>";
	            //response.sendRedirect("html/JDT_uploadStudycheck2.html");
        }
	      
	      
	    }  
}
