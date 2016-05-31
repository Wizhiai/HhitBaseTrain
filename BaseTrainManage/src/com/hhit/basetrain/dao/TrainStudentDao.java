/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hhit.basetrain.entity.Student;
import com.hhit.basetrain.entity.TrainStudent;
import com.hhit.basetrain.entity.TrainStudentBean;

/**
 * @author Mayu
 * @date 2016-4-25t上午11:38:42
 * TODO
 */
public interface TrainStudentDao {
	public int modifyInfo(Student stu);
	public TrainStudent findInfoByNo(String sno);
	public String findBaseNameByNo(String sno);
	public List<Map> findInfo(Map map);
	public List<Map> findInfoByPage(Map map);
	public List<Map> findScoreInfoByNo(Map map);
	public List<Map> findScoreInfoByPage(Map map);
	public List<Map> findScoreInfoByCondition(Map map);
	public List<Map> findScoreInfoByConditionPage(Map map);
	public List<Map> findTrainStudentInfo(Map map);
	public List<Map> findTrainStudentInfoPage(Map map);
	public int saveGradeInfo(Map map);
	public int updateGradeInfo(Map map);
	public int deleteGradeInfo(String id);
	public List<Map> findTrainInfo(Map map);
	public List<Map> findTrainInfoPage(Map map);
	public List<Map> findScoreInfo(Map map);
	public List<Map> findScoreInfoPage(Map map);
	/**
	 * 插入实训学生
	 * @param trainStudent
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertTrainStudent(TrainStudent trainStudent);
	/**
	 * 按专业统计
	 * @param base_no
	 * @return
	 */
	public List<Map> findCountByCourse(String manager_no);
	/**
	 * 通过课程号，基地号查询实训学生
	 * @param trainstudent
	 * @return
	 */
	public List<TrainStudentBean> findTrainStudentByCno(TrainStudent trainstudent);
	/**
	 * 通过班级进行统计
	 * @param manager_no
	 * @return
	 */
	public List<Map> findCountByBaseClass(String manager_no);
	
	/**
	 * 通过课程号，基地号查询实训学生
	 * @param trainstudent
	 * @return
	 */
	public List<TrainStudentBean> findTrainStudentByClass(TrainStudent trainstudent);
	/**
	 * 查询基地班级
	 * @param base_class
	 * @return
	 */
	public List<String> findBaseClass(String manager_no);
	
    /**
     * 通过学号模糊查询
     * @param stuno
     * @return
     */
	public List<TrainStudent> findInfoList(String stuno);
	/**
	 * 基地管理员修改班级
	 * @param trainstudent
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateTrainStudentInfo(TrainStudent trainstudent);
	
	public List<TrainStudent> findStudentByClass(Map map);
	/**
	 * 删除学生
	 * @param stuno
	 * @return
	 */
	public int deleteStudent(String stuno);
	
	
}
