/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.BaseTeacher;

/**
 * @author Mayu
 * @date 2016-4-23t下午08:39:38
 * TODO
 */
public interface BaseTeacherDao {
	public List<BaseTeacher> findInfoByBaseName(Map map);
	public List<BaseTeacher> findInfoByBaseNamePage(Map map);
	public String findCnoByTeacherNo(String tno);
	public Map findInfoByNo(String tno);
	public int modifySelfInfo(BaseTeacher teacher);
	public int deleteBaseTeacherByBaseNo(int base_no);
	public List<String> findBaseTeacherNoByBaseNo(int base_no);

}
