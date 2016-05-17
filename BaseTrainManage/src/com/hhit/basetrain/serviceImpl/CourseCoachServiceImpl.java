/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.CourseCoachDao;
import com.hhit.basetrain.entity.CourseCoach;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.CourseCoachService;

/**
 * @author mayu
 */
@Service
public class CourseCoachServiceImpl implements CourseCoachService{
    @Resource
    private CourseCoachDao courseCoachDao;
    
	public boolean addCourseCoach(String cno, String cname, int term,
			String studydataname, String studydata, String uploadDate,
			String uploadNo) {
		boolean result;
		CourseCoach course=new CourseCoach();
		course.setCname(cname);
		course.setCno(cno);
		course.setStudydata(studydata);
		course.setStudydataname(studydataname);
		course.setTerm(term);
		course.setUploadDate(uploadDate);
		course.setUploadNo(uploadNo);
		int count=courseCoachDao.saveCoach(course);
		if(count!=0){
			System.out.println("插入成功");
			result=true;
		}else{
			System.out.println("插入失败");
			result=false;
		}
		return result;

		
		
	}

	public Result loadCourseCoach(String cno,Integer page,Integer pagesize) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("cno", cno);
		map.put("page", page);
		map.put("pagesize", pagesize);
		List<CourseCoach> course=new ArrayList<CourseCoach>();
		List<CourseCoach> courses=new ArrayList<CourseCoach>();
		course=courseCoachDao.findCoachBycno(cno);
		courses=courseCoachDao.findCoachBycnoPage(map);
		System.out.println(courses);
		if(course.size()==0||courses.size()==0){
			result.setMsg("没有教辅资料");
			result.setStatus(0);
		}else if(courses.size()!=0 && course.size()!=0){
			result.setData(courses);
			result.setMsg("加载成功");
			result.setStatus(course.size());
		}
		return result;
	}

	public Result deleteCourseCoach(Integer id) {
		Result result=new Result();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("id", id);
		int count=courseCoachDao.deletecourseCoach(map);
		System.out.println(count);
		if(count==0){
			result.setMsg("删除失败");
			result.setStatus(0);
		}else{
			result.setMsg("删除成功");
			result.setStatus(count);
		}
		return result;
	}

}
