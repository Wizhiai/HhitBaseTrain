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
	
	/**
	 * 查看学生是否已经报名
	 */
	public Result isStudentRegist(String stuno);
	/**
	 * 学生实训课程报名
	 */
	public Result studentRegist(String stuno,String cno,String base_no);
	/**
	 * 学生实训报名按专业统计
	 */
	public Result studentRegistCountByMajor();
	/**
	 * 学生实训报名按实训基地统计
	 */
	public Result studentRegistCountByBase();
	/**
	 * 学生实训报名按实训专业和基地统计
	 */
	public Result studentRegistCountByMajorAndBase();
	/**
	 * 学生实训报名信息
	 */
	public Result studentRegistCountInfo();
	/**
	 * 学生入学年份信息
	 */
	public Result studentEnterYearInfo();
	/**
	 * 学生专业信息
	 */
	public Result studentMajorInfo();
	/**
	 * 根据专业查找学生班级信息
	 */
	public Result searchClassInfo(String major);
	/**
	 * 根据入学年份、专业、班级查找学生信息
	 */
	public Result searchStudentInfoAsUser(int enter_year,String major,String stu_class);
}
