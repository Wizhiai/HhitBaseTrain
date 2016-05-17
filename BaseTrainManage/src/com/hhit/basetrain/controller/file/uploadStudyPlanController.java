/**
 * 
 */
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

import com.hhit.basetrain.service.TeachingService;

/**
 * @author Mayu
 * @date 2016-5-12t下午12:25:03
 * TODO
 */
@Controller
public class uploadStudyPlanController {
	@Resource
	private TeachingService teachinService;
	
	@RequestMapping("/uploadfileplan.do")
	@ResponseBody
	 public void uploadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {  
		//ModelAndView mav=new ModelAndView();
		Map<String,String> map=new HashMap<String,String>();
	       /* String path = Thread.currentThread()
            .getContextClassLoader().getResource("").getPath()
            + "studyplan"; */
		String path = Thread.currentThread()
	            .getContextClassLoader().getResource("").getPath(); 
	        File file = new File(path);  
	        if (!file.exists()) {  
	            file.mkdirs();  
	        }  
	        //获取图片url地址  
	        String fileName = "";// 文件名称  
	        /**上传文件处理内容**/  
	        DiskFileItemFactory factory = new DiskFileItemFactory();  
	        ServletFileUpload sfu = new ServletFileUpload(factory);  
	        sfu.setHeaderEncoding("UTF-8"); // 处理中文问题 
	        request.setCharacterEncoding("UTF-8");
	        sfu.setSizeMax(2048 * 2048); // 限制文件大小  
	        try {  
	            List<FileItem> fileItems = sfu.parseRequest(request); // 解码请求  
	            for (FileItem fi : fileItems) {  
	            	if(fi.isFormField()){
	            		map.put(fi.getFieldName(),fi.getString() );
	            		System.out.println(fi.getFieldName());
	            		System.out.println(fi.getString());
	            	}
	            	else{
	            		fileName = "studyplan"+File.separator+UUID.randomUUID() + fi.getName().substring(fi.getName().lastIndexOf("."), fi.getName().length());  
	            		fi.write(new File(path, fileName));  
	            	}
	            	
	            }  
	            String cno=map.get("cno");
	            String studyplan=fileName;
	            boolean result=teachinService.saveStudyPlan(cno,studyplan);
	            if(result){
		            response.sendRedirect("html/JDT_uploadStudyplan1.html");
	            }else{
		            response.sendRedirect("html/JDT_uploadStudyplan2.html");
	            }
	            
	        } catch (Exception e) {  
	            e.printStackTrace(); 
	            System.out.println("文件上传出错");
	        }  
	      
	    }  
	
}
