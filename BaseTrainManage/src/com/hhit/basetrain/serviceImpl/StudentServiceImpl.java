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

import com.hhit.basetrain.dao.StudentDao;
import com.hhit.basetrain.dao.TrainStudentDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.Student;
import com.hhit.basetrain.entity.StudentRegistCountBean;
import com.hhit.basetrain.entity.StudentRegistCountInfoBean;
import com.hhit.basetrain.entity.TrainStudent;
import com.hhit.basetrain.service.StudentService;

/**
 * @author Jiya
 * @date 2016-4-23t下午05:04:10
 * 
 */
@Service
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao studentDao;
	
	@Resource
    private TrainStudentDao trainstudentDao;
	
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.AdminService#showInf(java.lang.String)
	 */
	public Result showInf(String stuno) {
		
		Result result = new Result();
		
		if(studentDao.findByNo(stuno)==null){
			
			result.setStatus(0);
			result.setMsg("个人信息显示失败！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(studentDao.findByNo(stuno));
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#modifySelfInf(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	public Result modifySelfInf(String stuno, String stuName, String stuSex,
			String stuClass, String major, String phone, int enterYear,
			String birthday, String address) {
	
		Student stu = new Student();
		stu.setStuno(stuno);
		stu.setStu_sex(stuSex);
		stu.setStu_name(stuName);
		stu.setStu_class(stuClass);
		stu.setPhone(phone);
		stu.setMajor(major);
		stu.setEnter_year(enterYear);
		stu.setBirthday(birthday);
		stu.setAddress(address);
		
		Result result = new Result();
		result.setStatus(studentDao.modifyInf(stu));
		result.setMsg("修改成功！");
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#showName(java.lang.String)
	 */
	public Result showName(String stuno) {
		
		Result result = new Result();
		
		if(studentDao.findByNo(stuno)==null){
			
			result.setStatus(0);
			result.setMsg("姓名显示失败！");
			
		}else{
			
			result.setStatus(1);
			result.setMsg("查询成功");
			result.setData(studentDao.findNameByNo(stuno));
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#modifySelfInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result modifySelfInfo(String stuno, String stuName, String stuSex,
			String stuClass, String major, String phone, String birthday,
			String address) {
		Result result=new Result();
		Student stu=new Student();
		stu.setStuno(stuno);
		stu.setAddress(address);
		stu.setBirthday(birthday);
		stu.setMajor(major);
		stu.setPhone(phone);
		stu.setStu_class(stuClass);
		stu.setStu_name(stuName);
		stu.setStu_sex(stuSex);
		studentDao.modifyInfo(stu);
		trainstudentDao.modifyInfo(stu);
		
		result.setStatus(1);
		result.setMsg("修改成功");
		
		
		
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#isStudentRegist(java.lang.String)
	 */
	public Result isStudentRegist(String stuno) {
		Result result = new Result();
		
		if(studentDao.findTrainBaseByStuno(stuno)==null
				||
			studentDao.findTrainBaseByStuno(stuno)==""){//未报名
			result.setStatus(1);
			result.setMsg("学生还未报名！！");
			
		}else{//已报名
			
			result.setStatus(0);
			result.setMsg("对不起，您已经报名！");
		}
		return result;
		
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#studentRegist(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result studentRegist(String stuno, String cno, String baseNo) {
		
		Result result = new Result();
		if(studentDao.findTrainBaseByStuno(stuno) == ""
			||
			studentDao.findTrainBaseByStuno(stuno) == null){//未报名
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("base_no", baseNo);
			map.put("stuno", stuno);
			map.put("cno", cno);
			
			result.setStatus(studentDao.regist(map));
			result.setMsg("报名成功！！");
			
		}else{//已报名
			
			result.setStatus(0);
			result.setMsg("对不起，您已经报名！");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#studentRegistCountByBase()
	 */
	public Result studentRegistCountByBase() {
		
		Result result = new Result();
		List<StudentRegistCountBean> list =  studentDao.registCountByBase();
		
		if(list.size()==0){
			result.setStatus(0);
			result.setMsg("没有报名信息！");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("没有报名信息！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#studentRegistCountByMajor()
	 */
	public Result studentRegistCountByMajor() {
		Result result = new Result();
		List<StudentRegistCountBean> list =  studentDao.registCountByMajor();
		
		if(list.size()==0){
			result.setStatus(0);
			result.setMsg("没有报名信息！");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("没有报名信息！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#studentRegistCountByMajorAndBase()
	 */
	public Result studentRegistCountByMajorAndBase() {
		Result result = new Result();
		List<StudentRegistCountBean> list =  studentDao.registCountByMajorAndBase();
		
		if(list.size()==0){
			result.setStatus(0);
			result.setMsg("没有报名信息！");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("没有报名信息！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#studentRegistCountInfo()
	 */
	public Result studentRegistCountInfo() {
		Result result = new Result();
		List<StudentRegistCountInfoBean> list =  studentDao.searchRegistCountInf();
		
		if(list.size()==0){
			result.setStatus(0);
			result.setMsg("没有报名信息！");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("没有报名信息！");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#searchClassInfoByMajor(java.lang.String)
	 */
	public Result searchClassInfo(String major) {
		Result result = new Result();
		List<String> list =  studentDao.findClass(major);
		
		if(list.size() == 0){
			result.setStatus(0);
			result.setMsg("未查找到相关的班级！");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("班级查找成功");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#studentEnterYearInfo()
	 */
	public Result studentEnterYearInfo() {
		Result result = new Result();
		List<Integer> list =  studentDao.findEnterYear();
		
		if(list.size() == 0){
			result.setStatus(0);
			result.setMsg("未查找到学生入学年份！");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("入学年份查找成功查找成功");
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#studentMajorInfo()
	 */
	public Result studentMajorInfo() {
		Result result = new Result();
		List<String> list =  studentDao.findMajor();
		
		if(list.size() == 0){
			result.setStatus(0);
			result.setMsg("未查找到专业信息！");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("专业查找成功");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.StudentService#searchStudentInfoAsUser(int, java.lang.String, java.lang.String)
	 */
	public Result searchStudentInfoAsUser(int enterYear, String major,
			String stuClass) {
		
		Result result = new Result();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("enter_year", enterYear);
		map.put("major", major);
		map.put("stu_class", stuClass);
		
		List<Student> list =  studentDao.findStudentAsUser(map);
		
		if(list.size() == 0){
			result.setStatus(0);
			result.setMsg("未查找到学生信息！");
		}else{
			result.setStatus(1);
			result.setData(list);
			result.setMsg("学生信息查找成功");
		}
		return result;
	}

	public Result searchTrainStudent(Integer base_no,String cno) {
		Result result =new Result();
		List<TrainStudent> trainstudents=new ArrayList<TrainStudent>();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("base_no", base_no);
		map.put("cno", cno);
		trainstudents=studentDao.findTrainstudent(map);
		if(trainstudents.size()==0){
			result.setMsg("没有学生报该门课程!");
			result.setStatus(0);
		}else{
			result.setMsg("加载成功");
			result.setStatus(1);
			result.setData(trainstudents);	
		}
		return result;
	}
}
