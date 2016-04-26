/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;

import com.hhit.basetrain.entity.BaseBean;
import com.hhit.basetrain.entity.BaseNameBean;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:22:29
 * 
 */
public interface BaseDao {

	public List<BaseBean> findByName(String base_name);
	public List<BaseBean> findByCourse(String cname);
	public List<BaseBean> findByAddress(String base_address);
	public List<BaseBean> findAllBaseInf();
	public List<BaseNameBean> findAllBaseName();
}
