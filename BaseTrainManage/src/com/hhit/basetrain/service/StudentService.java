/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.Student;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:26:01
 * 
 */
public interface StudentService {

	/**
	 * 显示个人信息
	 * @param no
	 * @return
	 */
	public Result showInf(String stuno);
	/**
	 * 查找姓名
	 * @param no
	 * @return
	 */
	public Result showName(String stuno);
	/**
	 * 修改个人信息
	 * @return
	 */
	public Result modifySelfInf(String stuno,String stu_name,String stu_sex,String stu_class,String marjor,String phone,int enter_year,String birthday,String address);
	
	/**
	 * 修改部分个人信息
	 * @return
	 */
	public Result modifySelfInfo(String stuno,String stu_name,String stu_sex,String stu_class,String major,String phone,String birthday,String address);
	
	
}
