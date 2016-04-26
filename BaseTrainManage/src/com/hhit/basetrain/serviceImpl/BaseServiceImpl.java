/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.BaseDao;
import com.hhit.basetrain.entity.BaseBean;
import com.hhit.basetrain.entity.BaseNameBean;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseService;

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
	
	

}
