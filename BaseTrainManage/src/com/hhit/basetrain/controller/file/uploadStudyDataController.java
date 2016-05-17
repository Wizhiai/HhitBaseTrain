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

import com.hhit.basetrain.service.CourseCoachService;
import com.hhit.basetrain.util.TimeUtil;

@Controller
public class uploadStudyDataController {
	@Resource
	private CourseCoachService courseCoachService;
	
	@RequestMapping("/uploadfiledata.do")
	@ResponseBody
	 public void uploadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {  
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
	        /**上传文件处理内容**/  
	        DiskFileItemFactory factory = new DiskFileItemFactory();  
	        ServletFileUpload sfu = new ServletFileUpload(factory);  
	        sfu.setHeaderEncoding("gbk"); // 处理中文问题 
	       // sfu.setHeaderEncoding( request.getCharacterEncoding());
	        request.setCharacterEncoding("gbk");
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
	            		fileName = "coach"+File.separator+UUID.randomUUID() + fi.getName().substring(fi.getName().lastIndexOf("."), fi.getName().length());  
	            		fi.write(new File(path, fileName));  
	            	}
	            	
	            }  
	            String uploadNo=map.get("tno");
	            String cno=map.get("cno");
	            System.out.println(cno);
	            String cname=map.get("cname");
	            int term=Integer.parseInt(map.get("term"));
	            String studydataname=map.get("title");
	            String studydata=fileName;
	            String uploadDate=TimeUtil.getFormatCurrentTime();
	            boolean result=courseCoachService.addCourseCoach(cno, cname, term, studydataname, studydata, uploadDate, uploadNo);
	            if(result){
	            	response.sendRedirect("html/JDT_uploadStudydata1.html");
	            }else{
	            	response.sendRedirect("html/JDT_uploadStudydata2.html");
	            }
	            
	        } catch (Exception e) {  
	            e.printStackTrace(); 
	            System.out.println("文件上传出错");
	        }  
	      
	    }  
}
