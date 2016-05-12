package com.hhit.basetrain.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.TeachingDao;
import com.hhit.basetrain.entity.Teaching;
import com.hhit.basetrain.service.TeachingService;
@Service
public class TeachingServiceImpl implements TeachingService{
	@Resource
	private TeachingDao teachingDao;

	public void saveStudyCheck(String cno, String studycheck,String t_no) {
		Teaching tea=new Teaching();
		tea.setCno(cno);
		tea.setStudycheck(studycheck);
		tea.setT_no(t_no);
		int count=teachingDao.savestudycheck(tea);
		if(count!=0){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
			
		}
		
		
	}

	public void saveStudyPlan(String cno, String studyplan) {
		Teaching tea=new Teaching();
		tea.setCno(cno);
		tea.setStudyplan(studyplan);
		int count=teachingDao.savestudyplan(tea);
		if(count!=0){
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
			
		}
		
	}

}
