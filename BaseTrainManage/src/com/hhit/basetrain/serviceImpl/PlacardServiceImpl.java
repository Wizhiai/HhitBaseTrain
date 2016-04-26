/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.BaseTeacherDao;
import com.hhit.basetrain.dao.PlacardDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.PlacardService;

/**
 * @author Mayu
 * @date 2016-4-23t下午09:03:40
 * TODO
 */
@Service
public class PlacardServiceImpl implements PlacardService{
	@Resource
	private PlacardDao placardDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#gainPlacard(java.lang.String)
	 */
	public Result loadPlacard(String id) {
		Result result=new Result();
		List<Map> placards=placardDao.findById(id);
		result.setData(placards);
		result.setStatus(0);
		result.setMsg("加载成功");
		return result;
		
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#loadSchoolPlacard()
	 */
	public Result loadSchoolPlacard() {
		Result result=new Result();
		List<Map> schoolPlacards=placardDao.findByType();
		result.setData(schoolPlacards);
		result.setStatus(0);
		result.setMsg("加载成功");
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#loadstudentPlacard(java.lang.String)
	 */
	public Result loadstudentPlacard(String id) {
		Result result=new Result();
		List<Map> Placards=placardDao.findplacardById(id);
		result.setData(Placards);
		result.setStatus(0);
		result.setMsg("加载成功");
		return result;
	}

}
