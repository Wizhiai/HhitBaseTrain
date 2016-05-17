package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.Teaching;

public interface TeachingDao {
	/**
	 * 更新课程考勤
	 * @param tea
	 * @return
	 */
	public int savestudycheck(Teaching tea);
	/**
	 * 上传学习计划
	 * @param tea
	 * @return
	 */
	
	public int savestudyplan(Teaching tea);
	/**
	 * 查询文件名
	 * @param t_no
	 * @return
	 */
	public Teaching findfile(String t_no);
	
	/**
	 * 根据基地号查询学习计划
	 */
	public List<Map> findStudyPlan(String base_no);
	/**
	 * 根据基地号查询学习计划分页
	 */
	public List<Map> findStudyPlanPage(Map map);
	/**
	 * 根据基地或者班级查询课程考勤
	 */
	public List<Map> findStudyCheck(Map map);
	/**
	 * 根据基地或者班级查询课程考勤分页
	 */
	public List<Map> findStudyCheckPage(Map map);
	/**
	 * 查找基地班级
	 */
	public List<Map> findBaseclass(String base_no);
	/**
	 * 通过学号查询课程计划
	 */
	public Map findStudyplanBycno(String cno);
	/**
	 * 通过课程号和班级查询课程考勤
	 */
	public Map findStudcheckbyCno(Map map);
	/**
	 * 通过基地教师号查询基地号和基地班级
	 */
	public Map findBaseByTno(String t_no);
	
	
}
