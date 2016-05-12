/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.AssessScoreDao;
import com.hhit.basetrain.dao.UserDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.User;
import com.hhit.basetrain.service.AssessScoreService;
import com.hhit.basetrain.service.UserService;

/**
 * @author Jiya
 * @date 2016-4-17t下午01:40:24
 */
@Service
public class AssessScoreServiceImpl implements AssessScoreService{
	@Resource
	private AssessScoreDao assessDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AssessScoreService#insertAssessScore(float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float, float)
	 */
	public Result insertAssessScore(float s11, float s12, float s13, float s21,
			float s22, float s23, float s24, float s25, float s26, float s27,
			float s31, float s32, float s33, float s34, float s35,float s36, 
			float s41,
			float s42, float s43, float s44, float s45, float s51, float s52,
			float s53, float s54, float s55, float s61, float s62, float s63,
			float s64, float s65,float s66) {
		System.out.println("services1");
		
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("s11", s11);
		map.put("s12", s12);
		map.put("s13", s13);
		map.put("s21", s21);
		map.put("s22", s22);
		map.put("s23", s23);
		map.put("s24", s24);
		map.put("s25", s25);
		map.put("s26", s26);
		map.put("s27", s27);
		map.put("s31", s31);
		map.put("s32", s32);
		map.put("s33", s33);
		map.put("s34", s34);
		map.put("s35", s35);
		map.put("s36", s36);
		map.put("s41", s41);
		map.put("s42", s42);
		map.put("s43", s43);
		map.put("s44", s44);
		map.put("s45", s45);
		map.put("s51", s51);
		map.put("s52", s52);
		map.put("s53", s53);
		map.put("s54", s54);
		map.put("s55", s55);
		map.put("s61", s61);
		map.put("s62", s62);
		map.put("s63", s63);
		map.put("s64", s64);
		map.put("s65", s65);
		map.put("s66", s66);
		System.out.println(s65+"sasasasas");
		Result result = new Result();
		int re = assessDao.save(map);
		if (re==0) {
			result.setMsg("插入失败!");
		}else {
			result.setMsg("插入成功！");
			result.setStatus(re);
		}
	
	return result;
		
	}


}
