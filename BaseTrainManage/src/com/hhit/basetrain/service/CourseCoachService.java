/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author mayu
 */
public interface CourseCoachService {
	/**
	 * 添加教辅资料
	 */
	public boolean addCourseCoach(String cno,String cname,int term,
			String studydataname,String studydata,String uploadDate,String uploadNo);
	/**
	 * 加载课辅资料
	 */
	public Result loadCourseCoach(String cno,Integer page,Integer pagesize);
	/**
	 * 删除教辅资料
	 */
	public Result deleteCourseCoach(Integer id);
	
}
