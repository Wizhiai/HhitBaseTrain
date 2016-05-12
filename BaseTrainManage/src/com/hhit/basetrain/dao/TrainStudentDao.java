/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.Student;
import com.hhit.basetrain.entity.TrainStudent;

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
	
}
