/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.BaseAdminDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.BaseAdminService;

/**
 * @author Jiya
 * @date 2016-4-23t下午05:04:10
 * 
 */
@Service
public class BaseAdminServiceImpl implements BaseAdminService{

	@Resource
	private BaseAdminDao baseAdminDao;
	
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AdminService#showInf(java.lang.String)
	 */
	public Result showInf(String manager_no) {
		
		Result result = new Result();
		
		System.out.println(manager_no);
		if(baseAdminDao.findByNo(manager_no)==null){
			
			result.setStatus(0);
			result.setMsg("个人信息显示失败！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(baseAdminDao.findByNo(manager_no));
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AdminService#modifySelfInf(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifySelfInf(String manager_no, String manager_name, String manager_phone) {
		
		Result result = new Result();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("manager_no", manager_no);
		map.put("manager_name", manager_name);
		map.put("manager_phone", manager_phone);

		result.setStatus(baseAdminDao.modifyInf(map));
		result.setMsg("修改成功");
		return result;
	}

}
