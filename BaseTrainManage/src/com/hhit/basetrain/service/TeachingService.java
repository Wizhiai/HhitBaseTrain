package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

public interface TeachingService {
	
	public void saveStudyCheck(String cno,String studycheck,String t_no);
	
	public void saveStudyPlan(String cno,String studyplan);
}
