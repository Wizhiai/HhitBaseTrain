/**
 * 
 */
package com.hhit.basetrain.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jiya
 * @date 2016-5-9t上午10:54:30
 * 
 */
public class TimeUtil {

	public static String getFormatCurrentTime(){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(date);
	}
}
