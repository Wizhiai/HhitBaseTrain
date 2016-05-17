package com.hhit.basetrain.controller.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class uploadWorkController {
	@Resource
	private WorkService workService;
	
	@RequestMapping("/uploadfilework.do")
	@ResponseBody
	 public void uploadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {  
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
	            		System.out.println(fi.getFieldName());
	            		System.out.println(fi.getString("utf-8"));
	            	}
	            	else{
	            		fileName = "work"+File.separator+UUID.randomUUID() + fi.getName().substring(fi.getName().lastIndexOf("."), fi.getName().length());  
	            		fi.write(new File(path, fileName));  
	            	}
	            	
	            }  
	            String cno=map.get("cno");
	            String uploadNo=map.get("tno");
	            String cname=map.get("cname");
	            String wid="work"+UUID.randomUUID();
	            String title=map.get("title");
	            String content=map.get("content");
	            Integer base_no=Integer.parseInt(map.get("baseno"));
	            System.out.println(base_no);
	            String base_class=map.get("baseclass");
	            String file=fileName;
	            String uploadDate=TimeUtil.getFormatCurrentTime();
	            String endDate=map.get("endDate");
	            boolean result=workService.holdWork(wid, cno, cname, base_no, title, content, uploadDate, uploadNo, base_class, endDate, file);		
	            if(result){
		            response.sendRedirect("html/ShowWork.html");
	            }else{
		            response.sendRedirect("html/JDT_uploadStudycheck2.html");
	            }
	            
	        } catch (Exception e) {  
	            e.printStackTrace(); 
	            System.out.println("文件上传出错");
	        }  
	      
	    }

	private Integer parseInt(String string) {
		// TODO Auto-generated method stub
		return null;
	}  
}
