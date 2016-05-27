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
<<<<<<< HEAD
	 *  通过基地管理员显示基地课程
	 * @param manager_no
	 * @return
	 */
	public Result showCourseInfByManagerNo(String manager_no);
	/**
	 * 通过课程号查询课程信息
	 * @param cno
	 * @return
	 */
	public Result searchCourseInfByCourseNo(String cno);
	/**
	 * 通过课程号修改课程信息
	 * @param cno
	 * @return
	 */
	public Result modifyCourseInfByCourseNo(String cno,String cname,int cost,double term);
	/**
	 * 通过课程号删除课程信息
	 * @param cno
	 * @return
	 */
	public Result deleteCourseInfByCourseNo(String cno);
	/**
	 * 查看基地课程名是否存在
	 * @param cno
	 * @return
	 */
	public Result isCourseNameExit(String manager_no,String cname);
	/**
	 * 添加基地课程
	 * @param manager_no
	 * @param cname
	 * @param cost
	 * @param term
	 * @return
	 */
	public Result addCourseInf(String manager_no,String cname,int cost,double term);
	
=======
	 * 通过教师号显示相应的课程信息
	 */
	public Result loadTrainCourseInfo(String t_no);
	/**
	 * 通过基地号查询课程号
	 */
	public Result showCno(String base_no);
>>>>>>> 945d2b75460f000516705e1dd40c9ea8b8dd71dd
}
