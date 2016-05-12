/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.PlacardBean;

/**
 * @author Mayu
 * @date 2016-4-23t下午08:43:57
 */
public interface PlacardDao {
	/**
	 * 通过基地管理员no查找公告(基地教师)
	 * @param manager_no
	 * @return
	 */
	public List<Map> findById(String id);
	/**
	 * 查询学校公告
	 * @return
	 */
	public List<Map> findByType();
	/**
	 * 通过基地管理员no查找公告（学生）
	 * @param id
	 * @return
	 */
	public List<Map> findplacardById(String id);
	/**
	 * 浏览全部常见问题
	 * @return
	 */
	public List<PlacardBean> findAllQuestion();
	/**
	 * 通过基地名查询常见问题公告 
	 * @return
	 */
	public List<PlacardBean> findQuestionByBaseNo(String base_no);
	/**
	 * 通过公告号查询常见问题公告 
	 * @return
	 */
	public PlacardBean findQuestionByPlacardNo(String placard_no);
	/**
	 * 分页显示学校公告
	 * @return
	 */
	public List<PlacardBean> findAllSchoolPlacard();
	/**
	 * 通过公告号查询学校公告 
	 * @return
	 */
	public PlacardBean findSchoolPlacardByPlacardNo(String placard_no);
	/**
	 * 添加学校公告 
	 * @return
	 */
	public int saveSchoolPlacard(Map<String,Object> map);
	/**
	 * 通过公告标题精确查询学校公告 
	 * @return
	 */
	public PlacardBean findSchoolPlacardByTitle(String placard_title);
	/**
	 * 通过公告标题模糊查询学校公告 
	 * @return
	 */
	public List<PlacardBean> searchSchoolPlacardByTitle(String placard_title);
	/**
	 * 通过公告号修改学校公告
	 * @return
	 */
	public int updateSchoolPlacardByNo(Map<String,Object> map);
	/**
	 * 通过公告号删除学校公告
	 * @return
	 */
	public int deleteSchoolPlacardByNo(String placard_no);
	
}
