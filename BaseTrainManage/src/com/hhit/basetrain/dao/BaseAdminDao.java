/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.Map;

import com.hhit.basetrain.entity.BaseAdmin;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:22:29
 * 
 */
public interface BaseAdminDao {

	public BaseAdmin findByNo(String no);
	public String findNameByNo(String ct_no);
	public int modifyInf(Map<String,Object> map);
}
