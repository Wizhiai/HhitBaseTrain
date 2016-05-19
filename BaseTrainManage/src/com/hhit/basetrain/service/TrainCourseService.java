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
public interface TrainCourseService {

	/**
	 * 通过基地号显示基地课程信息
	 * @param no
	 * @return
	 */
	public Result showCourseInfByBaseNo(String base_no);
	/**
	 * 显示所有基地课程
	 * @param
	 * @return
	 */
	public Result showAllbaseCourseInf();
	/**
	 * 通过教师号显示相应的课程信息
	 */
	public Result loadTrainCourseInfo(String t_no);
	/**
	 * 通过基地号查询课程号
	 */
	public Result showCno(String base_no);
}
