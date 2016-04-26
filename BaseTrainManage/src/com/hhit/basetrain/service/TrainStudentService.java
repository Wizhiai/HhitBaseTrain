/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Mayu
 * @date 2016-4-25t下午12:52:53
 * TODO
 */
public interface TrainStudentService {
	/**
	 * 查找实训学生信息
	 */
	public Result showInfo(String sno);
	/**
	 * 查询实训基地
	 */
	public Result showBaseName(String sno);
	
	/**
	 * 查询实训学生具体信息
	 */
	public Result showBaseInfo(String stno,String stuno);

}
