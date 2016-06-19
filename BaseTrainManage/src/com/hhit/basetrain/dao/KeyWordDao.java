/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;

/**
 *@author hulijie
 * @date 2016-6-9t下午11:33:40
 * TODO
 */
public interface KeyWordDao {

	/**
	 * @return
	 */
	List<String> findAllKeyword();

	/**
	 * @return
	 */
	List<String> findAllDegreeKeyword();

	/**
	 * @param j 
	 * @param getResultString 
	 * @param i 
	 * 
	 */
	void insertIntoCommentKeyWord(int i, String getResultString, int j,int commentid);

	/**
	 * @param trim
	 * @return
	 */
	int getEmotionScore(String word);

	/**
	 * @return
	 */
	List<String> findAllBadKeyword();

}
