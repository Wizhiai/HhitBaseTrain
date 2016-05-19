package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;
/**
 * 
 * @author mayu
 */
public interface TeachingService {
	/**
	 * 更新课程考勤
	 * @param cno
	 * @param studycheck
	 * @param t_no
	 */
	public boolean saveStudyCheck(String cno,String studycheck,String t_no);
	/**
	 * 更新学习计划
	 * @param cno
	 * @param studyplan
	 */
	public boolean saveStudyPlan(String cno,String studyplan);
	/**
	 * 查询文件名
	 */
	public Result showFile(String t_no);
	/**
	 * 查询学习计划
	 */
	public Result showStudyPlan(String base_no,Integer page,Integer pagesize);
	/**
	 * 查看课程考勤
	 */
	public Result showStudyCheck(String base_no,String base_class,Integer page,Integer pagesize);
	/**
	 * 查找基地班级
	 */
	public Result showBaseClass(String base_no);
	/**
	 * 查找课程计划
	 */
	public Result showStudyPlanByCno(String cno);
	/**
	 * 查询课程考勤
	 */
	public Result showStudyCheckByCno(String cno,String base_class);
	/**
	 * 查询基地号和班级
	 */
	public Result showBaseByTno(String t_no);
}
