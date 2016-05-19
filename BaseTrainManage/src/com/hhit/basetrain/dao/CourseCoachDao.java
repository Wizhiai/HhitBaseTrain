/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.CourseCoach;

/**
 * @author mayu
 */
public interface CourseCoachDao {
/**
 * 上传辅导资料
 */
	public int saveCoach(CourseCoach course);
	/**
	 * 通过课程号加载课辅资料
	 */
	public List<CourseCoach> findCoachBycno(String cno);
	/**
	 * 通过课程号加载课辅资料分页
	 */
	public List<CourseCoach> findCoachBycnoPage(Map map);
	/**
	 * 删除课辅资料
	 */
	public int deletecourseCoach(Map map);
}
