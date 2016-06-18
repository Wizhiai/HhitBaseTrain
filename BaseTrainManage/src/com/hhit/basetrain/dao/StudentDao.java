/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hhit.basetrain.entity.Student;
import com.hhit.basetrain.entity.StudentRegistCountBean;
import com.hhit.basetrain.entity.StudentRegistCountInfoBean;
import com.hhit.basetrain.entity.TrainStudent;

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
	public List<Integer> findEnterYear();
	public List<String> findMajor();
	public List<String> findClass(String major);
	public List<Student> findStudentAsUser(Map<String,Object> map);
	/**
	 * 查询实训学生
	 * @param base_no
	 * @return
	 */
	public List<TrainStudent> findTrainstudent(Map map);
	/**
	 * 删除报名学生
	 * @param stuno
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteRegister(String stuno);
	
	/**
	 * 修改电话
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateStudentInfo(Student student);
}
