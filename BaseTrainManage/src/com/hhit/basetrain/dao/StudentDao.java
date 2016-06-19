/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.Student;
import com.hhit.basetrain.entity.StudentRegistCountBean;
import com.hhit.basetrain.entity.StudentRegistCountInfoBean;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:22:29
 * 
 */
public interface StudentDao {

	public Student findByNo(String stuno);
	public String findNameByNo(String stuno);
	public int modifyInf(Student stu);
	public int modifyInfo(Student stu);
	public String findTrainBaseByStuno(String stuno);
	public int regist(Map<String,Object> map);
	public List<StudentRegistCountBean> registCountByBase();
	public List<StudentRegistCountBean> registCountByMajor();
	public List<StudentRegistCountBean> registCountByMajorAndBase();
	public List<StudentRegistCountInfoBean> searchRegistCountInf();
}
