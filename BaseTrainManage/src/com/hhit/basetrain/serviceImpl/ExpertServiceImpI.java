/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.hhit.basetrain.dao.ExpertDao;
import com.hhit.basetrain.entity.BaseBean;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.ExpertService;
import com.hhit.entity.assess.AssessScore;
import com.hhit.entity.assess.Expert;

/**
 *@author hulijie
 * @date 2016-5-19t下午12:42:02
 * TODO
 */
public class ExpertServiceImpI implements ExpertService{
@Resource
	private ExpertDao expertDao;
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.ExpertService#findAllExpert()
	 */
public Result findAllExpert() {
	System.out.println("2");
	Result result = new Result();
	List<BaseBean> user= expertDao.findAllExpert();
	System.out.println("3");
	if(user!=null){
		System.out.println(user);
		if(user.size() == 0){
			
			result.setStatus(0);
			result.setMsg("对不起，暂时没有用户呢！");
			
		}else{
			System.out.println(user);
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(user);
		}
		}else{
			
			result.setStatus(0);
			result.setMsg("对不起，暂时没有用户呢！");
			
		}



	return result;

}
/* (non-Javadoc)
 * @see com.hhit.basetrain.service.ExpertService#deleteExpertByUsernName(java.lang.String)
 */
public Result deleteExpertByUsernName(String userName) {
	System.out.println("services1"+userName);
	

	
	
	Result result = new Result();
//	Expert expert =expertDao.findByName(userName);
//	System.out.println(expert);
//	if (expert==null) {
		int re = expertDao.deleteByUserName(userName);
		if (re==0) {
			result.setMsg("删除失败!");
		}else {
			result.setMsg("删除成功！");
			result.setStatus(re);
		}
//	}else {
//		result.setMsg("您已评价！");}


return result;
}

}
