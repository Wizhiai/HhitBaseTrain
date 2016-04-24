/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:26:01
 * 
 */
public interface BaseAdminService {

	/**
	 * 显示个人信息
	 * @param no
	 * @return
	 */
	public Result showInf(String manager_no);
	/**
	 * 修改个人信息
	 * @return
	 */
	public Result modifySelfInf(String manager_no,String manager_name,String manager_phone);
}
