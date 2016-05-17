/**
 * 
 */
package com.hhit.basetrain.controller.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mayu
 * @date 2016-5-12t下午01:19:16
 * TODO
 */
@Controller
public class downloadStudyPlanController {
	  @RequestMapping("/downloadStudyPlan")
	   @ResponseBody
	    public String download(String fileName, HttpServletRequest request,
	            HttpServletResponse response) {
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("multipart/form-data");
	        response.setHeader("Content-Disposition", "attachment;fileName="
	                + fileName);
	        try {
	           /* String path=Thread.currentThread()
               .getContextClassLoader().getResource("").getPath()
               + "studyplan" ;*/
	        	String path = Thread.currentThread()
	                    .getContextClassLoader().getResource("").getPath();
	            	
	            	//Thread.currentThread().getContextClassLoader()
	                  //  .getResource("").getPath()
	                  //  + "download";//这个download目录为啥建立在classes下的
	            InputStream inputStream = new FileInputStream(new File(path
	                    + File.separator + fileName));
	            OutputStream os = response.getOutputStream();
	            byte[] b = new byte[2048];
	            int length;
	            while ((length = inputStream.read(b)) > 0) {
	                os.write(b, 0, length);
	            }
	 
	             // 这里主要关闭。
	            os.close();
	 
	            inputStream.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	            //  返回值要注意，要不然就出现下面这句错误！
	            //java+getOutputStream() has already been called for this response
	        return "success";
	    }
}
