/**
 * 
 */
package com.hhit.basetrain.dao;

/**
 * @author Mayu
 * @date 2016-4-23t下午08:39:38
 * TODO
 */
public interface BaseTeacherDao {
	/**
	 * 根据用户名查到baserelation表中的基地管理员
	 * @param id
	 * @return
	 */
	public String findManagerNoByTno(String id);
}
