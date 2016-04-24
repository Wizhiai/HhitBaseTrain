/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.AdminDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.AdminService;

/**
 * @author Jiya
 * @date 2016-4-23t下午05:04:10
 * 
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminDao adminDao;
	
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AdminService#showInf(java.lang.String)
	 */
	public Result showInf(String no) {
		
		Result result = new Result();
		
		if(adminDao.findByNo(no)==null){
			
			result.setStatus(0);
			result.setMsg("个人信息显示失败！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(adminDao.findByNo(no));
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AdminService#modifySelfInf(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifySelfInf(String no, String name, String phone) {
		
		Result result = new Result();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("name", name);
		map.put("phone", phone);

		result.setStatus(adminDao.modifyInf(map));
		result.setMsg("修改成功");
		return result;
	}

}
