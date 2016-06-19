/**
 * 
 */
package com.hhit.love;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *@author hulijie
 * @date 2016-6-14t下午03:10:19
 * TODO
 */
public class greatHtml {
//	*  * 功能描述：创建TXT文件并进行读、写、修改操作 *      * @authorKenZhang* @version 1.0  * Creation date: 2007-12-18 - 下午06:48:45 */

	

	  public static BufferedReader bufread;    //指定文件路径和名称   
	  private static String path = "D:/suncity.html";  
	  private static  File filename1 = new File("C:/apache-tomcat-7.0.69-windows-x64/apache-tomcat-7.0.69/webapps/BaseTrainManage/love/moban.html");
	  private static  File filenameContent = new File("C:/apache-tomcat-7.0.69-windows-x64/apache-tomcat-7.0.69/webapps/BaseTrainManage/love/content.txt");
	  private static  File filename ;
	  private static String readStr ="";   
	  /**    * 创建文本文件.    * @throws IOException      *      */  
	  public static void creatTxtFile(String fname) throws IOException{ 
		  filename = new File(fname);
		  if (!filename.exists()) {       
			  filename.createNewFile();       
			  System.err.println(filename + "已创建！");   
			  }  
		  
	  	}

	     /**    * 读取文本文件.    *      */  

	  public static String readTxtFile(){ 
//		  String read;    
		   
		  readStr = "";
		  
		  
//		    String fileContent = "";     
		    try   
		    {       
		           
		        if(filename1.isFile()&&filename1.exists())  
		        {       
		            InputStreamReader read = new InputStreamReader(new FileInputStream(filename1),"utf-8");       
		            BufferedReader reader=new BufferedReader(read);       
		            String line;       
		            while ((line = reader.readLine()) != null)   
		            {        
		            	readStr += line+"\n";       
		            }         
		            read.close();      
		        }     
		    } catch (Exception e)   
		    {         
		        e.printStackTrace();     
		    }     
		    return readStr;   
	  }
//		  
//		  
//		  try {         
//			  fileread = new FileReader(filename1);   
//		  bufread = new BufferedReader(fileread);        
//		  try {               
//			  while ((read = bufread.readLine()) != null) {  
//				  readStr = readStr + read+ "\r\n";             
//				  }        
//			  } catch (IOException e) {       
//					  // TODO Auto-generated catch block    
//					  e.printStackTrace();        
//					  }   
//				  } catch (FileNotFoundException e) {   
//					  // TODO Auto-generated catch block     
//					  e.printStackTrace();       
//					  }      
//				  System.out.println("文件内容是:"+ "\r\n" + readStr);  
//				  return readStr;  
//				  }     
			  

	   /**    * 替换.    *      */   
	  public static void replaceWithStrs(String toWho,String yourName,String meetTime,String content,String musicUrl){       

	   

//		  String filein = readStr;
		  if (!content.equals("")) {
			  readStr = readStr.replaceAll("contentSTR",content);
		}else{
			
			 try   
			    {       
			           
			        if(filenameContent.isFile()&&filenameContent.exists())  
			        {       
			            InputStreamReader read = new InputStreamReader(new FileInputStream(filenameContent),"utf-8");       
			            BufferedReader reader=new BufferedReader(read);       
			            String line;       
			            while ((line = reader.readLine()) != null)   
			            {        
			            	content += line+"\n";       
			            }         
			            read.close();      
			        }     
			    } catch (Exception e)   
			    {         
			        e.printStackTrace();     
			    }     
			
			 readStr = readStr.replaceAll("contentSTR",content);
		}
		  readStr = readStr.replaceAll("toWho",toWho);
		  if (!yourName.equals("")) {
			  readStr = readStr.replaceAll("YourName",yourName);
		}
		  if (!musicUrl.equals("")) {
			  readStr = readStr.replaceAll("music/music2love.mp3",musicUrl);
		}
//		 2012, 9, 5);
		  String timeString = " together.setFullYear("+meetTime+")";
		  readStr = readStr.replaceAll("timeSTR",timeString);
		 
		  
		  
		  
	  }			  
		  
		  
	  

	   /**    * 写文件.    *      */   
	  public static void writeTxtFile(String newStr) throws IOException{       

	 //先读取原有文件内容，然后进行写入操作     


		  String filein = readStr;
		
		  try   
		    {      
		          
//		        if (!filename.exists())   
//		        {       
		        	filename.createNewFile();      
//		        }      
		        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(filename),"utf-8");      
		        BufferedWriter writer=new BufferedWriter(write); 
		        
		        writer.write(filein);
		        writer.flush();
		        writer.close();     
		    } catch (Exception e)   
		    {      
		        e.printStackTrace();     
		    }  
		  
		  
		  
		  
	   }      
//		
		  
//		  
//	   RandomAccessFile mm = null;       
//	   try {          
//		   
// mm = new RandomAccessFile(filename, "rw");    
//	   mm.writeBytes(filein);      
//	   } catch (IOException e1) { 
//		   // TODO 自动生成 catch 块      
//		   e1.printStackTrace(); 
//		   } finally {       
//			   if (mm != null) {   
//				   try {           
//					   mm.close();       
//					   } catch (IOException e2) {
//						   // TODO 自动生成 catch 块   
//						   e2.printStackTrace();  
//						   }           
//					   }   
//			   }  
//		   
//	  }		   
		   
	
	  /**    * 将文件中指定内容的第一行替换为其它内容.    * 

	     * @param oldStr    *            查找内容    *

	 @param replaceStr    *            替换内容    */ 

	   public static void replaceTxtByStr(String oldStr,String replaceStr) {  
		   String temp = "";     
		          
			   File file = new File(path);   
			   FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			   InputStreamReader isr = new InputStreamReader(fis);    
       BufferedReader br = new BufferedReader(isr);          
       StringBuffer buf = new StringBuffer();        
		   
	 

	    // 保存该行前面的内容         

	   try {
		for (int j = 1; (temp = br.readLine()) != null       
		   && !temp.equals(oldStr); j++) {       
			   buf = buf.append(temp);       
			   buf = buf.append(System.getProperty("line.separator"));  
			   }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	   

	         // 将内容插入     
	   buf = buf.append(replaceStr);    

	        // 保存该行后面的内容       
	   try {
		while ((temp = br.readLine()) != null) {    
			   buf = buf.append(System.getProperty("line.separator"));         
			   buf = buf.append(temp);            }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}        
	   try {
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}         
	   FileOutputStream fos = null;
	try {
		fos = new FileOutputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}     
	   PrintWriter pw = new PrintWriter(fos);         
	   pw.write(buf.toString().toCharArray());        
	   pw.flush();     
	   pw.close();     
	    
	  
	   
}
	   public static void insertStr(String oldStr,String replaceStr) {  
		   String temp = "";     
		          
			   File file = new File(path);   
			   FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			   InputStreamReader isr = new InputStreamReader(fis);    
       BufferedReader br = new BufferedReader(isr);          
       StringBuffer buf = new StringBuffer();        
		   
	 

	    // 保存该行前面的内容         

	   try {
		for (int j = 1; (temp = br.readLine()) != null       
		   && !temp.equals(oldStr); j++) {       
			   buf = buf.append(temp);       
			   buf = buf.append(System.getProperty("line.separator"));  
			   }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	   

	         // 将内容插入     
	   buf = buf.append(replaceStr);    

	        // 保存该行后面的内容       
	   try {
		while ((temp = br.readLine()) != null) {    
			   buf = buf.append(System.getProperty("line.separator"));         
			   buf = buf.append(temp);            }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}        
	   try {
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}         
	   FileOutputStream fos = null;
	try {
		fos = new FileOutputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}     
	   PrintWriter pw = new PrintWriter(fos);         
	   pw.write(buf.toString().toCharArray());        
	   pw.flush();     
	   pw.close();     
	    
	  
	   
}
	   /**    * main方法测试    * @param s    * @throws IOException    */   
//	   public static void main(String[] s) throws IOException {    
////		   ReadWriteFile.creatTxtFile();   
////		   ReadWriteFile.readTxtFile();    
////		   ReadWriteFile.writeTxtFile("20080808:12:13");//   
////		   ReadWriteFile.replaceTxtByStr("ken", "zhang");  
//		   }
//	   }
}
