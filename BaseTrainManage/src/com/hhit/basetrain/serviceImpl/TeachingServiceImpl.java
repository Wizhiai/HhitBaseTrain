package com.hhit.basetrain.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.TeachingDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.Teaching;
import com.hhit.basetrain.service.TeachingService;
/**
 * 
 * @author mayu
 */

@Service
public class TeachingServiceImpl implements TeachingService{
	@Resource
	private TeachingDao teachingDao;

	public boolean saveStudyCheck(String cno, String studycheck,String t_no) {
		Teaching tea=new Teaching();
		tea.setCno(cno);
		tea.setStudycheck(studycheck);
		tea.setT_no(t_no);
		int count=teachingDao.savestudycheck(tea);
		if(count!=0){
			System.out.println("插入成功");
			return true;
		}
			System.out.println("插入失败");
			return false;
		
		
	}

	public boolean saveStudyPlan(String cno, String studyplan) {
		Teaching tea=new Teaching();
		tea.setCno(cno);
		tea.setStudyplan(studyplan);
		int count=teachingDao.savestudyplan(tea);
		if(count!=0){
			System.out.println("插入成功");
			return true;
		}
			System.out.println("插入失败");
			return false;
		
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TeachingService#showFile(java.lang.String)
	 */
	public Result showFile(String tNo) {
		Result result=new Result();
		Teaching tea=new Teaching();
		tea=teachingDao.findfile(tNo);
		if(tea==null){
			result.setStatus(0);
			result.setMsg("查找失败");
		}else{
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(tea);
		}
		return result;
		
	}

	public Result showStudyPlan(String base_no,Integer page,Integer pagesize) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("base_no", base_no);
		map.put("page", page);
		map.put("pagesize", pagesize);
		List<Map> plans=new ArrayList<Map>();
		List<Map> plan=new ArrayList<Map>();
		plan=teachingDao.findStudyPlan(base_no);
		plans=teachingDao.findStudyPlanPage(map);
		if(plans.size()==0 || plan.size()==0){
			result.setMsg("该基地还没有学习计划");
			result.setStatus(0);
		}else if(plans.size()!=0 && plan.size()!=0){
			result.setMsg("查询成功");
			result.setStatus(plan.size());
			result.setData(plans);
		}
		return result;
	}

	public Result showStudyCheck(String base_no, String base_class,
			Integer page, Integer pagesize) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map.put("base_no", base_no);
		map.put("base_class", base_class);
		map.put("page", page);
		map.put("pagesize", pagesize);
		map1.put("base_no", base_no);
		map1.put("base_class", base_class);
		List<Map> plans=new ArrayList<Map>();
		List<Map> plan=new ArrayList<Map>();
		plan=teachingDao.findStudyCheck(map1);
		plans=teachingDao.findStudyCheckPage(map);
		if(plans.size()==0 || plan.size()==0){
			result.setMsg("该基地还没有课程辅导");
			result.setStatus(0);
		}else if(plans.size()!=0 && plan.size()!=0){
			result.setMsg("查询成功");
			result.setStatus(plan.size());
			result.setData(plans);
		}
		return result;
	}

	public Result showBaseClass(String base_no) {
		Result result =new Result();
		List<Map> classes=new ArrayList<Map>();
		classes=teachingDao.findBaseclass(base_no);
		if(classes.size()!=0){
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(classes);
		}else{
			result.setMsg("查找失败");
			result.setStatus(0);
		}
		return result;
	}

	public Result showStudyPlanByCno(String cno) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		map=teachingDao.findStudyplanBycno(cno);
		if(map.size()==0){
			result.setStatus(0);
			result.setMsg("查找失败");
		}else{
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(map);
		}
		return result;
		
	}

	public Result showStudyCheckByCno(String cno, String base_class) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("cno", cno);
		map1.put("base_class", base_class);
		System.out.println(map1);
		map=teachingDao.findStudcheckbyCno(map1);
	System.out.println(map);
		if(map==null){
			result.setStatus(0);
			result.setMsg("对不起改班级还没有课程计划");
		}else{
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(map);
		}
		return result;
	}

	public Result showBaseByTno(String t_no) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		map=teachingDao.findBaseByTno(t_no);
		if(map.size()!=0){
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(map);
		}else{
			result.setStatus(0);
			result.setMsg("查找失败");
		}
		return result;
	}

	public Result saveTeaching(String cno, String base_class, String t_no) {
		Result result=new Result();
		String tno=teachingDao.findTeachingInfo(t_no);
		if(tno==null){
			Teaching teach=new Teaching();
			teach.setCno(cno);
			teach.setBase_class(base_class);
			teach.setT_no(t_no);
			int count=teachingDao.insertTeachingInfo(teach);
			if(count==0){
				result.setStatus(0);
				result.setMsg("教师分班失败！");
			}else{
				result.setStatus(1);
				result.setMsg("教师分班成功！");
			}
		}else{
			Teaching teach=new Teaching();
			teach.setCno(cno);
			teach.setBase_class(base_class);
			teach.setT_no(t_no);
			int count=teachingDao.updateTeaching(teach);
			if(count==0){
				result.setStatus(0);
				result.setMsg("教师分班失败！");
			}else{
				result.setStatus(1);
				result.setMsg("教师分班成功！");
			}
		}
		return result;
	}

}
