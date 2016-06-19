/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;

import com.hhit.basetrain.entity.BaseBean;
import com.hhit.entity.assess.Expert;

/**
 *@author hulijie
 * @date 2016-5-19t下午12:46:37
 * TODO
 */
public interface ExpertDao {

	public List<BaseBean> findAllExpert();

	/**
	 * @param userName
	 * @return
	 */
	public int deleteByUserName(String userName);

	/**
	 * @param userName
	 * @return
	 */
	public Expert findByName(String userName);
}
