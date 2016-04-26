/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.BaseTeacherDao;
<<<<<<< HEAD
=======
import com.hhit.basetrain.entity.BaseTeacher;
import com.hhit.basetrain.entity.Result;
>>>>>>> 5a857da9cd498017f0d9541f8ae813e0d070f0ab
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
	 * @see com.hhit.basetrain.service.BaseTeacherService#loadTeacherInfo(java.util.Map)
	 */
	public Result loadTeacherInfo(String t_name,String stuno) {
		Result result=new Result();
		Map<String,String> map=new HashMap<String,String>();
		map.put("t_name", t_name);
		map.put("stuno", stuno);
		List<BaseTeacher> baseTeachers=baseTeacherDao.findInfoByBaseName(map);
		if(baseTeachers.size()==0){
			result.setMsg("未查到信息,请重新输入");
			result.setStatus(0);
		}else{
			result.setData(baseTeachers);
			result.setMsg("查找成功");
			result.setStatus(1);
			
		}
		return result;
	}


}
