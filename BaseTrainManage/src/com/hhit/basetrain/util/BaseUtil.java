/**
 * 
 */
package com.hhit.basetrain.util;


/**
 * @author Jiya
 * @date 2016-5-13t下午10:27:21
 */
public class BaseUtil {
	/**
	 * 格式化基地编号
	 * @param base_no
	 * @param num
	 * @return
	 */
	public static String formatBaseNo(int base_no,int num){
		
		String baseNo = String.valueOf(base_no);
		String formatNo = "";
		int length = baseNo.length();
		
		if(length == num){//如果基地编号和目标长度相等，那么返回基地编号
			return baseNo;
		}else{
			for(int i = 0;i < num-length;i++){
				formatNo = formatNo.concat("0");
			}
			formatNo = formatNo.concat(baseNo);
		}
		
		return formatNo;
	}
	/**
	 * 获取基地管理员编号
	 * @param base_no 基地编号
	 * @param num  基地格式化的位数
	 * @return
	 */
	public static String generateBaseAdminNo(int base_no,int num){
		
		String manage_no = "ba".concat(formatBaseNo(base_no,num));
		return manage_no;
		
	}
	
	public static String generateTrainCourseNo(int base_no){
		
		String timeStr = String.valueOf(System.currentTimeMillis());
		int length = timeStr.length();
		
		String ffix = timeStr.substring(0,2).concat(timeStr.substring(length-5,length));
		
		String cno = formatBaseNo(base_no,3).concat(ffix) ;
		return cno;
		
	}
}
