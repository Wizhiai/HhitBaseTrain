/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Mayu
 * @date 2016-5-9t下午08:58:35
 * TODO
 */
public interface ScoreService {
	 public Result saveExampper(String stuno,String week,String month,String exampaper); 
	 public Result gainExampper(String stuno,String week,String month);
	
}
