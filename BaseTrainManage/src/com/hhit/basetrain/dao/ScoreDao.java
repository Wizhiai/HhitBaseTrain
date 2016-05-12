/**
 * 
 */
package com.hhit.basetrain.dao;

import com.hhit.basetrain.entity.Score;

/**
 * @author Mayu
 * @date 2016-5-9t下午08:57:29
 * TODO
 */
public interface ScoreDao {
	public int saveexamName(Score score);
	public String findexampper(Score score);
}
