/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hhit.basetrain.entity.CollegeTeacher;
import com.hhit.basetrain.entity.Student;
import com.hhit.basetrain.entity.User;

/**
 * @author Jiya
 * @date 2016-4-20下午02:59:52
 */
public interface UserDao {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findByName(String username);
	/**
	 * 添加用户
	 * @param username
	 * @param password
	 * @param identity
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int save(Map<String,Object> map);
	/**
	 * 删除用户
	 * @param username
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int delete(String username);
	/**
	 * 查询密码
	 * @param map
	 * @return
	 */
	public String searchPwd(String username);
	/**
	 * 修改密码
	 * @param map
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int modifyPwd(Map<String,Object> map);
	/**
	 * 密码重置
	 * @param username
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int resetPwd(String username);
	/**
	 * 插入基地教师
	 * @param user
	 * @return
	 */
	public int saveBaseTeacher(User user);
	/**
	 * 根据用户名查找学生信息
	 * @param username
	 * @return
	 */
	public Student findStudentUserByNo(String username);
	/**
	 * 根据用户名查找学生信息
	 * @param username
	 * @return
	 */
	public CollegeTeacher findCollegeTeacherUserByNo(String username);
}
