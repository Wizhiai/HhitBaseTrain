/**
 * 
 */
package com.hhit.basetrain.service;


import com.hhit.basetrain.entity.Result;

import java.util.Map;

import com.hhit.basetrain.entity.Result;



/**
 * @author Mayu
 * @date 2016-4-23t下午08:46:57
 * TODO
 */
public interface BaseTeacherService {
	public Result loadTeacherInfo(String t_name,String stuno);
	public Result loadTeacherInfoPage(String t_name,String stuno,Integer page,Integer pageSize);
	public Result loadCnoInfo(String tno);
	public Result loadSelInfo(String tno);
	public Result modifySelInfo(String tname,String sex,String phone,String tno);
}
