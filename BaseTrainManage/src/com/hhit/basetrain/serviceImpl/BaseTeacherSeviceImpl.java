/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.BaseTeacherDao;
import com.hhit.basetrain.service.BaseTeacherService;

/**
 * @author Mayu
 * @date 2016-4-23t下午08:52:44
 * TODO
 */
@Service
public class BaseTeacherSeviceImpl implements BaseTeacherService{
	@Resource
	private BaseTeacherDao baseTeacherDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseTeacherService#gainBaseManager(java.lang.String)
	 */
	public 	String gainBaseManager(String id) {
		String manager_no=baseTeacherDao.findManagerNoByTno(id);
		if(manager_no ==null){
			return null;
		}
			
		return manager_no;
		
	}

}
