/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.UserDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.User;
import com.hhit.basetrain.service.UserService;

/**
 * @author Jiya
 * @date 2016-4-17t下午01:40:24
 */
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.UserService#ckeckLogIn(java.lang.String, java.lang.String)
	 */
	public Result ckeckLogIn(String username, String password) {
		Result result = new Result();
		User user = userDao.findByName(username);
		
		if(user == null){//用户不存在
			
			result.setMsg("用户名或密码错误！");
			result.setStatus(0);
			
		}else if(!user.getPassword().equals(password)){//密码错误
			
			result.setMsg("用户名或密码错误！");
			result.setStatus(0);
			
		}else{//登陆成功
			
			result.setMsg("登陆成功！");
			result.setStatus(1);
			result.setData(user);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.UserService#modifyPwd(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifyPwd(String username, String oldPwd, String newPwd) {
		
		Result result = new Result();
		
		if(!userDao.searchPwd(username).equals(oldPwd)){
			result.setStatus(0);
			result.setMsg("原密码输入错误！");
		}else{
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("newPwd", newPwd);
			map.put("username", username);
			
			result.setStatus(userDao.modifyPwd(map));
			result.setMsg("修改成功!");
		}
		return result;
	}

}
