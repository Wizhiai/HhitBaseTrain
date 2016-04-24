/**
 * 
 */
package com.hhit.basetrain.dao;

import com.hhit.basetrain.entity.Student;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:22:29
 * 
 */
public interface StudentDao {

	public Student findByNo(String stuno);
	public String findNameByNo(String stuno);
	public int modifyInf(Student stu);
}
