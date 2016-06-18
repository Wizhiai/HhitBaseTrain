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
import org.springframework.transaction.annotation.Transactional;

import com.hhit.basetrain.dao.BaseTeacherDao;
import com.hhit.basetrain.dao.TeachingDao;
import com.hhit.basetrain.dao.UserDao;
import com.hhit.basetrain.entity.BaseTeacher;
import com.hhit.basetrain.entity.BaseTeacherBean;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.User;
import com.hhit.basetrain.service.BaseTeacherService;

/**
 * @author Mayu
 * @date 2016-4-23t下午08:52:44
 * TODO
 */
@Service
public class BaseTeacherSeviceImpl implements BaseTeacherService{
	@Resource
	private BaseTeacherDao baseTeacherDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private TeachingDao teachingDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseTeacherService#loadTeacherInfo(java.util.Map)
	 */
	public Result loadTeacherInfo(String t_name,String stuno) {
		Result result=new Result();
		Map<String,String> map=new HashMap<String,String>();
		map.put("t_name", t_name);
		map.put("stuno", stuno);
		List<BaseTeacher> baseTeachers=baseTeacherDao.findInfoByBaseName(map);
		if(baseTeachers.size()==0){
			result.setMsg("未查到信息,请重新输入");
			result.setStatus(0);
		}else{
			result.setData(baseTeachers);
			result.setMsg("查找成功");
			result.setStatus(1);
			
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseTeacherService#loadCnoInfo(java.lang.String)
	 */
	public Result loadCnoInfo(String tno) {
		Result result=new Result();
		String cno=baseTeacherDao.findCnoByTeacherNo(tno);
		if(cno==null){
			result.setStatus(0);
			result.setMsg("对不起你没有授课，无法查询学生成绩");
		}
		else{
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(cno);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseTeacherService#loadTeacherInfoPage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result loadTeacherInfoPage(String tName, String stuno, Integer page,
			Integer pageSize) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("t_name", tName);
		map.put("stuno", stuno);
		map.put("page", page);
		map.put("pagesize", pageSize);
		map1.put("t_name", tName);
		map1.put("stuno", stuno);
		List<BaseTeacher> baseTeachers=baseTeacherDao.findInfoByBaseNamePage(map);
		List<BaseTeacher> baseTeacher=baseTeacherDao.findInfoByBaseName(map1);
		if(baseTeachers.size()==0 || baseTeacher.size()==0){
			result.setMsg("未查到信息,请重新输入");
			result.setStatus(0);
		}else{
			result.setData(baseTeachers);
			result.setMsg("查找成功");
			result.setStatus(baseTeacher.size());
			
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseTeacherService#loadSelInfo(java.lang.String)
	 */
	public Result loadSelInfo(String tno) {
		Result result=new Result();
		Map self=baseTeacherDao.findInfoByNo(tno);
		if(self!=null){
			result.setData(self);
			result.setMsg("加载成功");
			result.setStatus(1);
		}else{
			result.setMsg("加载失败");
			result.setStatus(1);	
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseTeacherService#modifySelInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifySelInfo(String tname, String sex, String phone,String tno,String profession) {
		Result result=new Result();
		BaseTeacher teacher=new BaseTeacher();
		teacher.setT_name(tname);
		teacher.setT_phone(phone);
		teacher.setT_sex(sex);
		teacher.setT_no(tno);
		teacher.setT_profession(profession);
		int row=baseTeacherDao.modifySelfInfo(teacher);
		System.out.println(row);
		if(row>0){
		result.setMsg("修改成功");
		result.setStatus(row);
		}else{
			result.setStatus(0);
			result.setMsg("修改失败");
			
		}
		return result;
		
	}
    @Transactional(rollbackFor=Exception.class)
	public Result inputBaseTeacher(String t_no, String t_name, String t_sex,
			String t_phone, String t_profeesion, Integer base_no,String identity) {
    	Result result=new Result();
    	BaseTeacher baseteacher=new BaseTeacher();
    	Map<String,Object> map=new HashMap<String,Object>();
    	Map<String,Object> resultMap=new HashMap<String,Object>();
    	User user=new User();
    	
        user=userDao.findByName(t_no);//查找用户名是否重复
        resultMap=baseTeacherDao.findInfoByNo(t_no);//查找用户名是否重复
        if(user!=null || resultMap!=null){
        	result.setMsg("用户名重复，请重新插入");
        	result.setStatus(0);
        }
        else if(user==null && resultMap==null){
        	baseteacher.setT_name(t_name);
        	baseteacher.setT_no(t_no);
        	baseteacher.setT_phone(t_phone);
        	baseteacher.setT_sex(t_sex);
        	baseteacher.setBase_no(base_no);
        	baseteacher.setT_profession(t_profeesion);
        	int insertBaseTeacherCount=baseTeacherDao.saveBaseTeacher(baseteacher);
        	if(insertBaseTeacherCount==0){
        		result.setStatus(0);
        		result.setMsg("基地教师插入失败!");
        		 throw new RuntimeException("基地教师插入失败！");
        	}else{//基地教师插入成功
        		/*插入基地教师到用户表*/
        		map.put("username", t_no);
            	map.put("identity", identity);
            	int insertUserCount=userDao.save(map);
            	if(insertUserCount==0){
            		result.setStatus(0);
            		result.setMsg("用户名插入失败！");
            		throw new RuntimeException("用户名插入失败！");
            	}else{
            		result.setStatus(1);
            		result.setMsg("基地教师插入成功");
            		
            	}
        	}
        }
    	return result;

	}
   
    @Transactional(rollbackFor=Exception.class)
	public Result deleteBaseTeacherByNo(String tNo) {
    	Result result=new Result();
    	
    	int count=baseTeacherDao.deleteBaseTeacher(tNo);
    	if(count==0){
    		result.setMsg("基地教师删除失败!");
    		result.setStatus(0);
    		throw new RuntimeException("基地教师删除失败！");
    	}else{//删除用户表
    		int usercount=userDao.delete(tNo);
    		if(usercount==0){
    			result.setMsg("用户删除失败!");
    			result.setStatus(0);
    			throw new  RuntimeException("用户删除失败！");
    		}else{//删除授课表
    			String t_no=teachingDao.findTeachingInfo(tNo);
    			if(t_no!=null){
    				int teacount=teachingDao.deleteTeaching(tNo);
    				if(teacount==0){
    					result.setMsg("授课表删除失败！");
    	    			result.setStatus(0);
    	    			throw new  RuntimeException("授课表删除失败!");
    				}else{
    					result.setMsg("基地教师删除成功");
    					result.setStatus(1);
    				}
    			}else{
    				result.setMsg("基地教师删除成功");
					result.setStatus(1);
    			}
    		}
    	}
    	return result;
    	
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.BaseTeacherService#showBaseTeacherInfo(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public Result showBaseTeacherInfo(String tNo, String managerNo) {
		Result result=new Result();
		List<BaseTeacherBean> baseTeachers=new ArrayList<BaseTeacherBean>();//分页查询
		List<BaseTeacherBean> baseTeacher=new ArrayList<BaseTeacherBean>();//总的查询
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map.put("t_no", tNo);
		map.put("manager_no", managerNo);
		System.out.println(map);
		baseTeacher=baseTeacherDao.findBaseTeacherByTno(map);
		if(baseTeacher!=null){
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(baseTeacher);
		}else {
			result.setStatus(0);
			result.setMsg("没有该教师,请重新查询!");
		}
		return result;
		
	}

	public Result showBaseTeacherName(String base_no) {
		Result result=new Result();
		List<BaseTeacher> baseteachers=new ArrayList<BaseTeacher>(); 
		baseteachers=baseTeacherDao.findBaseTeacherName(base_no);
		if(baseteachers.size()==0){
			result.setMsg("该基地没有老师!");
			result.setStatus(0);
		}else{
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(baseteachers);
		}
		return result;
	}

	

}
