/**
 * 
 */
package com.hhit.basetrain.dao;

import com.hhit.basetrain.entity.CollegeTeacher;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:22:29
 * 
 */
public interface CollegeTeacherDao {

	public CollegeTeacher findByNo(String ct_no);
	public String findNameByNo(String ct_no);
	public int modifyInf(CollegeTeacher teacher);
}
