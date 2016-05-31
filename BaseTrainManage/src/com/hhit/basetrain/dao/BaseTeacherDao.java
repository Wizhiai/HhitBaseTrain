/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hhit.basetrain.entity.BaseTeacher;
import com.hhit.basetrain.entity.BaseTeacherBean;

/**
 * @author Mayu
 * @date 2016-4-23t下午08:39:38
 * TODO
 */
public interface BaseTeacherDao {
	/**
	 * 通过基地名字查询信息
	 * @param map
	 * @return
	 */
	public List<BaseTeacher> findInfoByBaseName(Map map);
	/**
	 * 通过基地名字查询信息分液
	 * @param map
	 * @return
	 */
	public List<BaseTeacher> findInfoByBaseNamePage(Map map);
	/**
	 * 通过教师号查询课程号
	 * @param tno
	 * @return
	 */
	public String findCnoByTeacherNo(String tno);
	/**
	 * 通过教师号查询信息
	 * @param tno
	 * @return
	 */
	public Map findInfoByNo(String tno);
	/**
	 * 修改个人信息
	 * @param teacher
	 * @return
	 */
	public int modifySelfInfo(BaseTeacher teacher);
	public int deleteBaseTeacherByBaseNo(int base_no);
	public List<String> findBaseTeacherNoByBaseNo(int base_no);

	/**
	 * 插入教师信息
	 * @param teacher
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveBaseTeacher(BaseTeacher teacher);
	/**
	 * 删除基地教师
	 * @param t_no
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteBaseTeacher(String t_no);
	/**
	 * 查找基地教师
	 * @param map
	 * @return
	 */
	public List<BaseTeacherBean> findBaseTeacherByTno(Map map);
	/**
	 * 查找基地教师分页
	 * @param map
	 * @return
	 */
	public List<BaseTeacherBean> findBaseTeacherByTnoPage(Map map);
	/**
	 * 查询基地的教师
	 * @param base_no
	 * @return
	 */
	public List<BaseTeacher> findBaseTeacherName(String base_no);
}
