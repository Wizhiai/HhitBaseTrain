/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.TrainStudentDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.TrainStudent;
import com.hhit.basetrain.service.TrainStudentService;

/**
 * @author Mayu
 * @date 2016-4-25t下午12:53:32
 * TODO
 */
@Service
public class TrainStudentServiceImpl implements TrainStudentService{
	@Resource
	private TrainStudentDao trainstudentDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showInfo(java.lang.String)
	 */
	public Result showInfo(String sno) {
		Result result=new Result();
		TrainStudent student=trainstudentDao.findInfoByNo(sno);
		if(student==null){
			result.setStatus(0);
			result.setMsg("查找失败");
			
		}else{
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(student);
			
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showBaseName(java.lang.String)
	 */
	public Result showBaseName(String sno) {
		Result result=new Result();
		String basename=trainstudentDao.findBaseNameByNo(sno);
		if(basename==""){
			result.setMsg("该学生没有实训单位");
			result.setStatus(0);	
		}else{
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(basename);
			
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showBaseInfo(java.lang.String)
	 */
	public Result showBaseInfo(String stno,String stuno) {
		Result result =new Result();
		Map<String,String> map=new HashMap<String,String>();
		map.put("stno", stno);
		map.put("stuno",stuno);
		System.out.println(map);
		List<Map> students=trainstudentDao.findInfo(map);
		result.setData(students);
		result.setMsg("查找成功");
		result.setStatus(0);
	   
		return result;
	}

}
