/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Jiya
 * @date 2016-4-17下午01:38:53
 */
public interface AssessScoreService {

	/**
	 * 评分插入数据库
	 * @param s11
	 * @param s12
	 * @param s13
	 * @param s21
	 * @param s22
	 * @param s23
	 * @param s24
	 * @param s25
	 * @param s26
	 * @param s27
	 * @param s31
	 * @param s32
	 * @param s33
	 * @param s34
	 * @param s35
	 * @param s41
	 * @param s42
	 * @param s43
	 * @param s44
	 * @param s45
	 * @param s51
	 * @param s52
	 * @param s53
	 * @param s54
	 * @param s55
	 * @param s61
	 * @param s62
	 * @param s63
	 * @param s64
	 * @param s65
	 * @return
	 */
	public Result insertAssessScore(float s11,float s12,float s13,float s21,float s22,float s23,float s24,float s25,float s26,float s27,float s31,float s32,float s33,float s34,float s35,
			float s36,float s41,float s42,float s43,float s44,float s45,float s51,float s52,float s53,float s54,float s55,float s61,float s62,float s63,float s64,float s65,float s66);
}
