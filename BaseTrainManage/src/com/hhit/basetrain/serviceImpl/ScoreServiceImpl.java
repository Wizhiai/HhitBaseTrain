/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.ScoreDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.Score;
import com.hhit.basetrain.service.ScoreService;

/**
 * @author Mayu
 * @date 2016-5-9t下午09:00:13
 * TODO
 */
@Service
public class ScoreServiceImpl implements ScoreService{
	@Resource
	private ScoreDao scoredao;
	
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.ScoreService#saveExampper(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result saveExampper(String stuno, String week, String month,String exampaper) {
		Result result=new Result();
		Score score=new Score();
		score.setStuno(stuno);
		score.setMonth(month);
		score.setWeek(week);
		score.setExampaper(exampaper);
		int count=scoredao.saveexamName(score);
		result.setMsg("保存成功");
		result.setStatus(count);
		return result;
		
	}

	public Result gainExampper(String stuno, String week, String month) {
		Result result=new Result();
		Score score=new Score();
		score.setStuno(stuno);
		score.setMonth(month);
		score.setWeek(week);
		String exampper=scoredao.findexampper(score);
		if(exampper==""){
			result.setStatus(0);
			result.setMsg("查找失败");
		}else{
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(exampper);
			
		}
		return result;
	}

	 

}
