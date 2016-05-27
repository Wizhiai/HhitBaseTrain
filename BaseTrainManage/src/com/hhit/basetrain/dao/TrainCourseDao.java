/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.TrainCourse;
import com.hhit.basetrain.entity.TrainCourseBean;

/**
 * @author Jiya
 * @date 2016-4-25t上午11:38:42
 * 
 */
public interface TrainCourseDao {
	/**
	 * 根据基地号查询基地所开课程
	 * @param base_no
	 * @return
	 */
	public List<TrainCourseBean> findByBaseNo(String base_no);
	/**
	 * 查找每个基地全部课程
	 * @param 
	 * @return
	 */
	public List<TrainCourseBean> findAllCourse();
	/**
<<<<<<< HEAD
	 * 添加基地课程
	 * @param map
	 * @return
	 */
	public int saveCourse(Map<String,Object> map);
	/**
	 * 通过基地查找基地课程
	 * @param base_no
	 * @return
	 */
	 public List<TrainCourse> findCourseByBaseNo(int base_no);
	 /**
	  * 通过课程号修改课程
	  * @param map
	  * @return
	  */
	 public int updateCourseInfoByCourseNo(Map<String,Object> map);
	 /**
	  * 通过课程号删除课程
	  * @param cno
	  * @return
	  */
	 public int deleteCourseInfoByCourseNo(String cno);
	 /**
	  * 通过基地号、课程名查找课程
	  * @param map
	  * @return
	  */
	 public TrainCourse findCourseByBaseNoAndCname(Map<String,Object> map);
	 
	 /**
	  * 通过课程号查找基地课程
	  * @param cno
	  * @return
	  */
	 public TrainCourse findCourseByCourseNo(String cno);
	 /**
	 * 加载基地课程信息
	 * @param t_no
	 * @return
	 */
	public TrainCourse findCourseInfoByTno(String t_no);
	/**
	 * 查询课程号
	 */
	public List<String> findCourse(String base_no);

}
