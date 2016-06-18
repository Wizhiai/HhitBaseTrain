package com.hhit.basetrain.controller.file;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhit.basetrain.service.WorkService;
import com.hhit.basetrain.util.TimeUtil;
@Controller
public class ReuploadFinishedWorkController {
	@Resource
	private WorkService workService;
	@RequestMapping("/reuploadwork.do")
	@ResponseBody
	 public Object uploadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {  
		//ModelAndView mav=new ModelAndView();
		Map<String,String> map=new HashMap<String,String>();
	        String path = Thread.currentThread()
            .getContextClassLoader().getResource("").getPath(); 
	        File file1 = new File(path);  
	        if (!file1.exists()) {  
	            file1.mkdirs();  
	        }  
	        //获取图片url地址  
	        String fileName = "";// 文件名称
	        String filename="";
	        String file="";
	        boolean result=false;
	        /**上传文件处理内容**/  
	        DiskFileItemFactory factory = new DiskFileItemFactory();  
	        ServletFileUpload sfu = new ServletFileUpload(factory);  
	        sfu.setHeaderEncoding("UTF-8"); // 处理中文问题 
	        sfu.setSizeMax(2048 * 2048); // 限制文件大小  
	        try {  
	            List<FileItem> fileItems = sfu.parseRequest(request); // 解码请求  
	            for (FileItem fi : fileItems) {  
	            	if(fi.isFormField()){
	            		map.put(fi.getFieldName(),fi.getString("utf-8") );
	            		/*System.out.println(fi.getFieldName());
	            		System.out.println(fi.getString());*/
	            	}
	            	else{
	            		filename=fi.getName().substring(fi.getName().lastIndexOf(File.separator)+1, fi.getName().length());
	            		System.out.println(filename);
	            		//filename=new String(filename.getBytes(),"utf-8");
	            		fileName = "finished"+File.separator+UUID.randomUUID() + fi.getName().substring(fi.getName().lastIndexOf("."), fi.getName().length());  
	            		fi.write(new File(path, fileName));  
	            	}
	            	
	            }  
	            System.out.println(fileName);
	            String stuno=map.get("stuno");
	            System.out.println(stuno);
	            String wid=map.get("wid");
	            System.out.println(wid);
	            String uploadDate=TimeUtil.getFormatCurrentTime();
	            file=fileName;
	             result=workService.reUpload(stuno, uploadDate,file, wid,filename);
	           
	           
	        } catch (Exception e) {  
	            e.printStackTrace(); 
	            System.out.println("文件上传出错");
	        }  
	        if(result){
	        	//filename=new String(filename.getBytes(),"utf-8");
	        	//System.out.println(filename);
	        	String url="<script>window.parent.uploadSucced('"+filename+"','"+file+"');</script>";
	              return url;
	              
        }else{
	             return "<script>window.parent.uploadFailed();</script>";
	            //response.sendRedirect("html/JDT_uploadStudycheck2.html");
        }
	    }  
}

