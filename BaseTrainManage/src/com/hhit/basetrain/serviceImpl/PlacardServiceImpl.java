/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.PlacardDao;
import com.hhit.basetrain.entity.Placard;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseTeacherService;
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
	@Resource
	private BaseTeacherService baseTeacherService;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.PlacardService#gainPlacard(java.lang.String)
	 */
	public Result loadPlacard(String id) {
		Result result=new Result();
		String managerNo;
		managerNo=baseTeacherService.gainBaseManager(id);
		List<Map> placards=placardDao.findByAuthorName(managerNo);
		result.setData(placards);
		result.setStatus(0);
		result.setMsg("加载成功");
		return result;
		
	}

}
