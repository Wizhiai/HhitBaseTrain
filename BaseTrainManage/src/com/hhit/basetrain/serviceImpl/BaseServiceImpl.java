/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.BaseDao;
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
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @author Jiya
 * @date 2016-4-23t下午05:04:10
 * 
 */
@Service
public class BaseServiceImpl implements BaseService{

	@Resource
	private BaseDao baseDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#skimBaseInf(java.lang.String)
	 */
	public Result skimBaseInfByName(String baseName) {
		
		Result result = new Result();
		
		List<BaseBean> list = baseDao.findByName("%"+baseName+"%");
		
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("没有符合查找条件的记录！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#skimBaseInfByAddress(java.lang.String)
	 */
	public Result skimBaseInfByAddress(String baseAddress) {
		Result result = new Result();
		
		List<BaseBean> list = baseDao.findByAddress("%"+baseAddress+"%");
		
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("没有符合查找条件的记录！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#skimBaseInfByCourse(java.lang.String)
	 */
	public Result skimBaseInfByCourse(String cname) {
		Result result = new Result();
		List<BaseBean> list = baseDao.findByCourse("%"+cname+"%");

		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("没有符合查找条件的记录！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#skimAllBaseInf()
	 */
	public Result skimAllBaseInf() {

		Result result = new Result();
		List<BaseBean> list = baseDao.findAllBaseInf();

		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("对不起，没有合作基地的信息！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showAllBaseName()
	 */
	public Result showAllBaseName() {
		
		Result result = new Result();
		List<BaseNameBean> list = baseDao.findAllBaseName();

		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("对不起，没有合作基地的信息！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(list);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseBasicInfoByNo(java.lang.String)
	 */
	public Result showBaseBasicInfoByNo(String baseNo) {
		Result result = new Result();
		BaseBean base = baseDao.findBasicInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地基本信息查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseAdvantageInfoByNo(java.lang.String)
	 */
	public Result showBaseAdvantageInfoByNo(String baseNo) {
		
		Result result = new Result();
		BaseAdvantageBean base = baseDao.findAdvantageInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地特色查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseAllianceInfoByNo(java.lang.String)
	 */
	public Result showBaseAllianceInfoByNo(String baseNo) {
		Result result = new Result();
		BaseAllianceBean base = baseDao.findAllianceInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地企业联盟查找成功查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseBuildInfoByNo(java.lang.String)
	 */
	public Result showBaseBuildInfoByNo(String baseNo) {
		Result result = new Result();
		BaseBuildBean base = baseDao.findBuildInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地建设与管理状况查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseCoachInfoByNo(java.lang.String)
	 */
	public Result showBaseCoachInfoByNo(String baseNo) {
		Result result = new Result();
		BaseCoachBean base = baseDao.findCoachInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("基地教师与辅导队伍查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseContentInfoByNo(java.lang.String)
	 */
	public Result showBaseContentInfoByNo(String baseNo) {
		Result result = new Result();
		BaseTrainContentBean base = baseDao.findContentInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("实训目标及内容查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseEffectInfoByNo(java.lang.String)
	 */
	public Result showBaseEffectInfoByNo(String baseNo) {
		Result result = new Result();
		BaseTrainEffectBean base = baseDao.findEffectInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("时间效果及开发能力查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseFieldInfoByNo(java.lang.String)
	 */
	public Result showBaseFieldInfoByNo(String baseNo) {
		Result result = new Result();
		BaseFieldBean base = baseDao.findFieldInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("场地与设施条件查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#showBaseResearchInfoByNo(java.lang.String)
	 */
	public Result showBaseResearchInfoByNo(String baseNo) {
		Result result = new Result();
		BaseResearchBean base = baseDao.findResearchInfoByNo(baseNo);

		if(base == null){
			
			result.setStatus(0);
			result.setMsg("对不起，该基地不存在！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("科研与技术活动查找成功");
			result.setData(base);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseService#searchAllBase()
	 */
	public Result searchAllBase() {
		Result result = new Result();
		List<BaseBean> list = baseDao.findAllBaseInf();
		List<String> baseUrlString = baseDao.findAllBaseUrlString();
		Object[] os = new Object[2];
		os[0] = list;
		os[1] = baseUrlString;
		if(list.size() == 0){
			
			result.setStatus(0);
			result.setMsg("对不起，没有合作基地的信息！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(os);
		
		}
		return result;
	}
	
	

}
