/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:26:01
 * 
 */
public interface CollegeTeacherService {

	/**
	 * 显示个人信息
	 * @param no
	 * @return
	 */
	public Result showInf(String ct_no);
	/**
	 * 查找姓名
	 * @param no
	 * @return
	 */
	public Result showName(String ct_no);
	/**
	 * 修改个人信息
	 * @return
	 */
	public Result modifySelfInf(String ct_no,String ct_name,String ct_birthday,String ct_sex,String academy_no,String ct_phone,String ct_profession);
	/**
	 * 查看学院
	 * @return
	 */
	public Result showAcademyInf();
	/**
	 * 通过学院号查看教师
	 * @return
	 */
	public Result showCollegeTeacherByAcademyNo(String academy_no);
}
