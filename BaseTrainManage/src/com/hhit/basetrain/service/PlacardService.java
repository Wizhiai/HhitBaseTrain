/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Mayu
 * @date 2016-4-23t下午08:49:44
 * TODO
 */
public interface PlacardService {
	/**
	 * 通过基地管理员获取公告信息
	 */
	public Result loadPlacard (String id);
	/**
	 * 查询学校公告
	 */
	public Result loadSchoolPlacard();

}
