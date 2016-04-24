/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.Placard;

/**
 * @author Mayu
 * @date 2016-4-23t下午08:43:57
 * TODO
 */
public interface PlacardDao {
	/**
	 * 通过基地管理员no查找公告
	 * @param manager_no
	 * @return
	 */
	public List<Map> findById(String id);
	/**
	 * 查询学校公告
	 * @return
	 */
	public List<Map> findByType();
}
