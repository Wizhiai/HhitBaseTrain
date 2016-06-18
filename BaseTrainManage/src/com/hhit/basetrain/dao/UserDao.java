/**
 * 
 */
package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.BaseBean;
import com.hhit.basetrain.entity.User;

/**
 * @author Jiya
 * @date 2016-4-20下午02:59:52
 */
public interface UserDao {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findByName(String username);
	/**
	 * 添加用户
	 * @param username
	 * @param password
	 * @param identity
	 */
	public void save(String username,String password,String identity);
	/**
	 * 删除用户
	 * @param username
	 * @return
	 */
	public int delect(String username);
	/**
	 * 查询密码
	 * @param map
	 * @return
	 */
	public String searchPwd(String username);
	/**
	 * 修改密码
	 * @param map
	 * @return
	 */
	public int modifyPwd(Map<String,Object> map);
	/**
	 * 密码重置
	 * @param username
	 * @return
	 */
	public int resetPwd(String username);
	public List<BaseBean> findAllUser();
	/**
	 * @param userName
	 * @return
	 */
	public List<BaseBean> findByNames(String userName);
	/**
	 * @param type
	 * @return
	 */
	public List<BaseBean> findByType(String type);
		
	
}
