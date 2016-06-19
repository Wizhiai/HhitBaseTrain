/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;

import com.hhit.basetrain.entity.BaseBean;
import com.hhit.entity.assess.Comment;


/**
 *@author hulijie
 * @date 2016-5-30t下午03:02:02
 * TODO
 */
public interface CommentDao {
	List<Comment> findAllComment(int baseno);

	/**
	 * @param i
	 * @param j 
	 * @return
	 */
	Comment findByUserName(int i, int j);

	/**
	 * @param i
	 * @param j
	 * @param content
	 * @param time 
	 * @return
	 */
	int inserttoComment(int i, int j, String content, String time);

	/**
	 * @param id
	 * @param emtion
	 */
	void updateEmotion(int id, int emtion);

	/**
	 * @param parseInt
	 * @param parseInt2
	 * @return
	 */
	List<Comment> findCommentByBasenoAndEmotion(int parseInt, int parseInt2);
}
