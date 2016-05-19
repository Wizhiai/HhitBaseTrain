/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	public BaseBean findBasicInfoByNo(int base_no);
	public BaseBean findBasicBaseInfoByNo(int base_no);

	public BaseBuildBean findBuildInfoByNo(int base_no);

	public BaseFieldBean findFieldInfoByNo(int base_no);

	public BaseTrainContentBean findContentInfoByNo(int base_no);

	public BaseCoachBean findCoachInfoByNo(int base_no);

	public BaseResearchBean findResearchInfoByNo(int base_no);

	public BaseTrainEffectBean findEffectInfoByNo(int base_no);

	public BaseAllianceBean findAllianceInfoByNo(int base_no);

	public BaseAdvantageBean findAdvantageInfoByNo(int base_no);

	@Transactional(propagation = Propagation.REQUIRED)
	public int save(Map<String, Object> map);

	public BaseNameBean findBaseByNameCarefully(String base_name);

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteBase(int base_no);

	public String findBaseAdminByBaseNo(int base_no);

	@Transactional(propagation = Propagation.REQUIRED)
	public int saveBaseRelation(Map<String, Object> map);

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteBaseRelation(int base_no);
	
	public int updateBasicInfoByNo(BaseBean base);
	public int updateBuildInfoByNo(BaseBuildBean base);
	public int updateFieldInfoByNo(BaseFieldBean base);
	public int updateContentInfoByNo(BaseTrainContentBean base);
	public int updateCoachInfoByNo(BaseCoachBean base);
	public int updateResearchInfoByNo(BaseResearchBean base);
	public int updateEffectInfoByNo(BaseTrainEffectBean base);
	public int updateAllianceInfoByNo(BaseAllianceBean base);
	public int updateAdvantageInfoByNo(BaseAdvantageBean base);
	
}
