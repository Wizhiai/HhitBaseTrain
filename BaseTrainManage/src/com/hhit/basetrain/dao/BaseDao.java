/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;

import com.hhit.basetrain.entity.BaseAdvantageBean;
import com.hhit.basetrain.entity.BaseAllianceBean;
import com.hhit.basetrain.entity.BaseBean;
import com.hhit.basetrain.entity.BaseBuildBean;
import com.hhit.basetrain.entity.BaseCoachBean;
import com.hhit.basetrain.entity.BaseFieldBean;
import com.hhit.basetrain.entity.BaseNameBean;
import com.hhit.basetrain.entity.BaseResearchBean;
import com.hhit.basetrain.entity.BaseTrainContentBean;
import com.hhit.basetrain.entity.BaseTrainEffectBean;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:22:29
 * 
 */
public interface BaseDao {

	public List<BaseBean> findByName(String base_name);
	public List<BaseBean> findByCourse(String cname);
	public List<BaseBean> findByAddress(String base_address);
	public List<BaseBean> findAllBaseInf();
	public List<BaseNameBean> findAllBaseName();
	public BaseBean findBasicInfoByNo(String base_no);
	public BaseBuildBean findBuildInfoByNo(String base_no);
	public BaseFieldBean findFieldInfoByNo(String base_no);
	public BaseTrainContentBean findContentInfoByNo(String base_no);
	public BaseCoachBean findCoachInfoByNo(String base_no);
	public BaseResearchBean findResearchInfoByNo(String base_no);
	public BaseTrainEffectBean findEffectInfoByNo(String base_no);
	public BaseAllianceBean findAllianceInfoByNo(String base_no);
	public BaseAdvantageBean findAdvantageInfoByNo(String base_no);
}
