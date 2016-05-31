/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhit.basetrain.dao.TrainCourseDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.TrainCourse;
import com.hhit.basetrain.entity.TrainCourseBean;
import com.hhit.basetrain.entity.TrainStudent;
import com.hhit.basetrain.service.TrainCourseService;

/**
 * @author Jiya
 * @date 2016-4-27t下午07:07:07
 * 
 */
@Service
public class TrainCourseServiceImpl implements TrainCourseService{

	@Resource
	private TrainCourseDao trainCourseDao;
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainCourseService#showCourseInfByBaseNo(java.lang.String)
	 */
	public Result showCourseInfByBaseNo(String base_no) {
		
		Result result = new Result();
		List<TrainCourseBean> list = trainCourseDao.findByBaseNo(base_no);
		
		if(list.size() ==0){
			
			result.setMsg("对不起，该基地未开设任何课程");
			result.setStatus(0);
		}else{
			
			result.setMsg("课程查找成功！");
			result.setStatus(1);
			result.setData(list);
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainCourseService#showAllbaseCourseInf()
	 */
	public Result showAllbaseCourseInf() {
		Result result = new Result();
		List<TrainCourseBean> list = trainCourseDao.findAllCourse();
		
		if(list.size() ==0){
			
			result.setMsg("对不起，基地未开设任何课程");
			result.setStatus(0);
		}else{
			
			result.setMsg("课程查找成功！");
			result.setStatus(1);
			result.setData(list);
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainCourseService#loadTrainCourseInfo(java.lang.String)
	 */
	public Result loadTrainCourseInfo(String tNo) {
		Result result=new Result();
		TrainCourse course=new TrainCourse();
		course=trainCourseDao.findCourseInfoByTno(tNo);
		if(course==null){
			result.setStatus(0);
			result.setMsg("查找失败");
		}else{
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(course);	
		}
		return result;
		
	}
	public Result showCno(String base_no) {
		Result result=new Result();
		List<String> cnos=new ArrayList<String>();
		cnos=trainCourseDao.findCourse(base_no);
		if(cnos.size()==0){
			result.setMsg("查找失败");
			result.setStatus(0);
		}else{
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(cnos);
		}
		return result;
	}
	public Result showCname(String cno) {
		Result result=new Result();
		String cname=trainCourseDao.findCourseName(cno);
		if(cname!=null){
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(cname);
		}else{
			result.setMsg("查找失败");
			result.setStatus(0);
		}
		return result;
	}

}
