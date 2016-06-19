/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.CollegeTeacherDao;
import com.hhit.basetrain.entity.CollegeTeacher;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.service.CollegeTeacherService;

/**
 * @author Jiya
 * @date 2016-4-23t下午05:04:10
 * 
 */
@Service
public class CollegeTeacherServiceImpl implements CollegeTeacherService{

	@Resource
	private CollegeTeacherDao collegeTeacherDao;
	
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AdminService#showInf(java.lang.String)
	 */
	public Result showInf(String ct_no) {
		
		Result result = new Result();
		
		if(collegeTeacherDao.findByNo(ct_no)==null){
			
			result.setStatus(0);
			result.setMsg("个人信息显示失败！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(collegeTeacherDao.findByNo(ct_no));
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.CollegeTeacherService#modifySelfInf(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifySelfInf(String ct_no,String ct_name,String ct_birthday,String ct_sex,String academy_no,String ct_phone,String ct_profession) {
		
		CollegeTeacher teacher = new CollegeTeacher();
		teacher.setCt_no(ct_no);
		teacher.setCt_name(ct_name);
		teacher.setCt_phone(ct_phone);
		teacher.setCt_sex(ct_sex);
		teacher.setCt_profession(ct_profession);
		teacher.setCt_birthday(ct_birthday);
		teacher.setAcademy_no(academy_no);
		System.out.println(ct_birthday);
		
		Result result = new Result();
		result.setStatus(collegeTeacherDao.modifyInf(teacher));
		result.setMsg("修改成功！");
		return result;
	}


	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.CollegeTeacherService#showName(java.lang.String)
	 */
	public Result showName(String ctNo) {

		Result result = new Result();
		
		if(collegeTeacherDao.findByNo(ctNo)==null){
			
			result.setStatus(0);
			result.setMsg("姓名显示失败！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(collegeTeacherDao.findNameByNo(ctNo));
		}
		return result;
	}

}
