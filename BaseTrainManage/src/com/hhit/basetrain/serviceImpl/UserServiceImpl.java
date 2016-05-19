/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhit.basetrain.dao.UserDao;
import com.hhit.basetrain.entity.CollegeTeacher;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.Student;
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
			result.setStatus(-1);
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

    @Transactional()
	public Result InputInfo(String username, String password, String identity) {
		Result result=new Result();
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setIdentity(identity);
		int count=userDao.saveBaseTeacher(user);
		if(count!=0){
			result.setStatus(1);
			result.setMsg("添加成功");
		}else{
			result.setStatus(0);
			result.setMsg("添加失败");
		}
		return result;
		
    }
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.UserService#insertUser(java.lang.String, java.lang.String)
	 */
	@Transactional(rollbackFor=Exception.class)
	public Result insertUser(String username, String identity) {
		Result result = new Result();
		User user = userDao.findByName(username);

		if(user == null){//用户不存在
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("username", username);
			map.put("identity", identity);
			int num = userDao.save(map);
			result.setStatus(num);
			result.setMsg("账号为"+username+"的记录插入成功！");
			
		}else{//用户已经存在
			
			result.setData(user);
			result.setMsg("账号为"+username+"的用户,");
			result.setStatus(0);
		}
		
		return result;
	}


	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.UserService#deleteUser(java.lang.String)
	 */
	@Transactional(rollbackFor=Exception.class)
	public Result deleteUser(String username) {
		
		Result result = new Result();
		User user = userDao.findByName(username);

		if(user == null){//用户不存在
			
			result.setStatus(0);
			result.setMsg("记录不存在！");
			
		}else{//用户已经存在
			
			int num = userDao.delete(username);
			result.setMsg("用户删除成功！");
			result.setStatus(num);
		}
		
		return result;
	}


	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.UserService#showCollegeTeacherUserInfoByNo(java.lang.String)
	 */
	public Result showCollegeTeacherUserInfoByNo(String username) {
		Result result = new Result();
		CollegeTeacher user = userDao.findCollegeTeacherUserByNo(username);

		if(user == null){//用户不存在
			
			result.setStatus(0);
			result.setMsg("记录不存在！");
			
		}else{//用户存在
			
			result.setMsg("用户信息成功！");
			result.setData(user);
			result.setStatus(1);
		}
		
		return result;
	}


	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.UserService#showStudentUserInfoByNo(java.lang.String)
	 */
	public Result showStudentUserInfoByNo(String username) {
		Result result = new Result();
		Student user = userDao.findStudentUserByNo(username);

		if(user == null){//用户不存在
			
			result.setStatus(0);
			result.setMsg("记录不存在！");
			
		}else{//用户存在
			
			result.setMsg("用户信息查找成功！");
			result.setData(user);
			result.setStatus(1);
		}
		
		return result;
	}


	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.UserService#resetUserPwdByNo(java.lang.String)
	 */
	public Result resetUserPwdByNo(String username) {
		Result result = new Result();
		User user = userDao.findByName(username);

		if(user == null){//用户不存在
			
			result.setStatus(0);
			result.setMsg("记录不存在！");
			
		}else{//用户已经存在
			
			int num = userDao.resetPwd(username);
			result.setMsg("密码重置成功！");
			result.setStatus(num);
		}
		
		return result;
	}

}
