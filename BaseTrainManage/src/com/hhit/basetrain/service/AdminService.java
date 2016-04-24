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
public interface AdminService {

	/**
	 * 显示个人信息
	 * @param no
	 * @return
	 */
	public Result showInf(String no);
	/**
	 * 查找姓名
	 * @param no
	 * @return
	 */
	public Result showName(String no);
	/**
	 * 修改个人信息
	 * @return
	 */
	public Result modifySelfInf(String no,String name,String phone);
}
