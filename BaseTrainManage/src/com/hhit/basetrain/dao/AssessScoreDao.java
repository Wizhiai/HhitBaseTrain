/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.BaseBean;
import com.hhit.entity.assess.AssessScore;

/**
 *@author hulijie
 * @date 2016-4-28t下午03:55:04
 * TODO
 */
public interface AssessScoreDao {

	public int save(Map<String, Object> map);
	public AssessScore findByUserIdAndbaseTypeId(String userId,int baseTypeId);
	/**
	 * @param userName
	 * @param expertType 
	 * @return
	 */
	public int insertToExpert(String username, String expertType);
	/**
	 * @param userName
	 * @return
	 */
	public String findByUserName(String userName);
	/**
	 * @param userName
	 * @param experType
	 * @return
	 */
	public int insertToAssessExpert(String userName, String experType);
	/**
	 * @param integer
	 * @return
	 */
	public List<AssessScore> getScore(Integer integer);
	/**
	 * @param userName
	 * @param url
	 * @return
	 */
	public int insertVideo(String userName, String url);
	/**
	 * @param userName
	 * @return
	 */
	public String findVideo(String userName);
	/**
	 * @param userName
	 * @param url
	 * @return
	 */
	public void updateVideo(String userName, String url);

}
