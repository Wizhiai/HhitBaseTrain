/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;

import com.hhit.basetrain.entity.BaseBean;
import com.hhit.entity.assess.AssessExpert;
import com.hhit.entity.assess.Expert;

/**
 *@author hulijie
 * @date 2016-5-19t下午04:02:58
 * TODO
 */
public interface AssessExpertDao {

	/**
	 * @param userName
	 * @return
	 */
	AssessExpert findByUserName(String userName);

	/**
	 * @param userName
	 * @param experType
	 * @return
	 */
	int inserttoAssessExpert(String userName, String experType);

	/**
	 * @return
	 */
	List<BaseBean> findAllExpert();

	/**
	 * @param userName
	 * @return
	 */
	int deleteassessExpertByUsernName(String userName);



	/**
	 * @param userName
	 * @return
	 */
	String findUserPositionByUserName(String userName);

	/**
	 * @param userName
	 * @param positionUpdate
	 * @return
	 */
	int updateAssessExpertPosition(String userName, String positionUpdate);

	/**
	 * @param userName
	 * @return
	 */
	List<BaseBean> findByNames(String userName);

	/**
	 * @param type
	 * @return
	 */
	List<BaseBean> findByType(String type);

}
