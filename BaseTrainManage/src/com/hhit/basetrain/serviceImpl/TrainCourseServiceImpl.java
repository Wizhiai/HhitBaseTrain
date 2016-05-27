/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.BaseAdminDao;
import com.hhit.basetrain.dao.TrainCourseDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.TrainCourse;
import com.hhit.basetrain.entity.TrainCourseBean;
import com.hhit.basetrain.service.TrainCourseService;
import com.hhit.basetrain.util.BaseUtil;

/**
 * @author Jiya
 * @date 2016-4-27t下午07:07:07
 * 
 */
@Service
public class TrainCourseServiceImpl implements TrainCourseService{

	@Resource
	private TrainCourseDao trainCourseDao;
	@Resource
	private BaseAdminDao baseAdminDao;
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
	 * @see com.hhit.basetrain.service.TrainCourseService#deleteCourseInfByCourseNo(java.lang.String)
	 */
	public Result deleteCourseInfByCourseNo(String cno) {
		
		Result result = new Result();
		TrainCourse course = trainCourseDao.findCourseByCourseNo(cno);
		
		if(course == null){
			
			result.setMsg("对不起，该课程不存在");
			result.setStatus(0);
		}else{
			
			int num = trainCourseDao.deleteCourseInfoByCourseNo(cno);
			result.setMsg("课程删除成功！");
			result.setStatus(num);
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainCourseService#addCourseInf(java.lang.String, java.lang.String, int, double)
	 */
	public Result addCourseInf(String managerNo, String cname, int cost,
			double term) {
		
		Result result = new Result();
		
		int base_no = baseAdminDao.findBaseNoByManagerNo(managerNo);//查找课程所属基地
		
		Map<String,Object> searchMap = new HashMap<String, Object>();
		searchMap.put("base_no", base_no);
		searchMap.put("cname", cname);
		TrainCourse course = trainCourseDao.findCourseByBaseNoAndCname(searchMap);//查看课程名是否已经存在
		
		if(course != null){
			result.setStatus(0);
			result.setMsg("课程名已存在，添加失败！");
		}else{//课程名不存在
			
			Map<String,Object> map = new HashMap<String, Object>();
			String cno = BaseUtil.generateTrainCourseNo(base_no);//生成课程号
			map.put("cno", cno);
			map.put("base_no", base_no);
			map.put("cname", cname);
			map.put("cost", cost);
			map.put("term", term);
			
			int num = trainCourseDao.saveCourse(map);
			result.setStatus(num);
			result.setMsg("课程添加成功！");
		}
		
		return result;
	}
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainCourseService#isCourseNameExit(java.lang.String, java.lang.String)
	 */
	public Result isCourseNameExit(String managerNo, String cname) {
		Result result = new Result();
		
		int base_no = baseAdminDao.findBaseNoByManagerNo(managerNo);//查找课程所属基地
		
		Map<String,Object> searchMap = new HashMap<String, Object>();
		searchMap.put("base_no", base_no);
		searchMap.put("cname", cname);
		TrainCourse course = trainCourseDao.findCourseByBaseNoAndCname(searchMap);//查看课程名是否已经存在
		
		if(course != null){
			result.setStatus(0);
			result.setMsg("课程名已存在");
		}else{
			result.setStatus(1);
			result.setMsg("该课程名不存在");
		}
		
		return result;
	}
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainCourseService#modifyCourseInfByCourseNo(java.lang.String)
	 */
	public Result modifyCourseInfByCourseNo(String cno,String cname,int cost,double term){
		
		Result result = new Result();
		TrainCourse course = trainCourseDao.findCourseByCourseNo(cno);
		
		if(course == null){
			result.setStatus(0);
			result.setMsg("未查找到该课程！");
		}else{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("cno", cno);
			map.put("cname",cname);
			map.put("cost", cost);
			map.put("term", term);
			
			int num = trainCourseDao.updateCourseInfoByCourseNo(map);
			result.setStatus(num);
			result.setMsg("修改成功！");
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainCourseService#searchCourseInfByCourseNo(java.lang.String)
	 */
	public Result searchCourseInfByCourseNo(String cno) {
		Result result = new Result();
		
		TrainCourse course = trainCourseDao.findCourseByCourseNo(cno);
		if(course == null){
			result.setStatus(0);
			result.setMsg("未查找到该课程！");
		}else{
			result.setData(course);
			result.setMsg("课程信息查询成功！");
			result.setStatus(1);
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainCourseService#showCourseInfByManagerNo(java.lang.String)
	 */
	public Result showCourseInfByManagerNo(String managerNo) {
		Result result = new Result();
		int base_no = baseAdminDao.findBaseNoByManagerNo(managerNo);//查找课程所属基地
		List<TrainCourse> list = trainCourseDao.findCourseByBaseNo(base_no);//根据基地号查找基地开设课程
		
		if(list.size() == 0){
			result.setStatus(0);
			result.setMsg("基地还未设任何课程！");
		}else{
			result.setData(list);
			result.setMsg("基地开课课程信息查询成功！");
			result.setStatus(1);
		}
		
		return result;
	}
}
