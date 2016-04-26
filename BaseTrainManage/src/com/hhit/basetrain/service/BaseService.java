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
public interface BaseService {

	/**
	 * 通过基地名模糊查找浏览基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimBaseInfByName(String base_name);
	/**
	 * 通过基地地址模糊查找浏览基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimBaseInfByAddress(String base_address);
	/**
	 * 通过课程模糊查找浏览基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimBaseInfByCourse(String cname);
	/**
	 * 浏览全部基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimAllBaseInf();
	/**
	 * 显示全部基地名称
	 * @param no
	 * @return
	 */
	public Result showAllBaseName();
}
