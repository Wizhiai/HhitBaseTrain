/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.Map;

import com.hhit.basetrain.entity.Admin;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:22:29
 * 
 */
public interface AdminDao {

	public Admin findByNo(String no);
	public int modifyInf(Map map);
}
