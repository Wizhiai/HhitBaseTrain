/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.BaseTeacherDao;
import com.hhit.basetrain.entity.BaseTeacher;
import com.hhit.basetrain.entity.Result;
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
	public Result modifySelInfo(String tname, String sex, String phone,String tno) {
		Result result=new Result();
		BaseTeacher teacher=new BaseTeacher();
		teacher.setT_name(tname);
		teacher.setT_phone(phone);
		teacher.setT_sex(sex);
		teacher.setT_no(tno);
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

	public Result inputBaseTeacher(String t_no, String t_name, String t_sex,
			String t_phone, String t_profeesion, Integer base_no) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result deleteBaseTeacherByNo(String tNo) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
