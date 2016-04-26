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
}
