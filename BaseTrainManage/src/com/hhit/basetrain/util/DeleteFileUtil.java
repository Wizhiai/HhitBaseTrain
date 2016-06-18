package com.hhit.basetrain.util;

import java.io.File;

public class DeleteFileUtil {
	public static boolean DeleteFolder(String sPath) {  
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 判断目录或文件是否存在  
	    if (!file.exists()) {  // 不存在返回 false  
	        return flag;  
	    } else {  
	        // 判断是否为文件  
	        if (file.isFile()) {  // 为文件时调用删除文件方法  
	           file.delete();
	           flag=true;
	        }  
	    }
		return flag;  
	}  
}
