/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;

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
