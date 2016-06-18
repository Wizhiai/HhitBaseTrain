/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 *@author hulijie
 * @date 2016-5-19t下午12:41:14
 * TODO
 */
public interface ExpertService {
	public Result findAllExpert() ;

	/**
	 * @param userName
	 * @return
	 */
	public Result deleteExpertByUsernName(String userName);
}
