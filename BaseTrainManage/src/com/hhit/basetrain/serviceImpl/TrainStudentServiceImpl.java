/**
 * 
 */
package com.hhit.basetrain.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hhit.basetrain.dao.TrainStudentDao;
import com.hhit.basetrain.entity.Result;
import com.hhit.basetrain.entity.TrainStudent;
import com.hhit.basetrain.service.TrainStudentService;

/**
 * @author Mayu
 * @date 2016-4-25t下午12:53:32
 * TODO
 */
@Service
public class TrainStudentServiceImpl implements TrainStudentService{
	@Resource
	private TrainStudentDao trainstudentDao;

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showInfo(java.lang.String)
	 */
	public Result showInfo(String sno) {
		Result result=new Result();
		TrainStudent student=trainstudentDao.findInfoByNo(sno);
		if(student==null){
			result.setStatus(0);
			result.setMsg("查找失败");
			
		}else{
			result.setStatus(1);
			result.setMsg("查找成功");
			result.setData(student);
			
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showBaseName(java.lang.String)
	 */
	public Result showBaseName(String sno) {
		Result result=new Result();
		String basename=trainstudentDao.findBaseNameByNo(sno);
		if(basename==""){
			result.setMsg("该学生没有实训单位");
			result.setStatus(0);	
		}else{
			result.setMsg("查找成功");
			result.setStatus(1);
			result.setData(basename);
			
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showBaseInfo(java.lang.String)
	 */
	public Result showBaseInfo(String stno,String stuno,Integer page,Integer pageSize) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("page", page);
		map.put("pagesize", pageSize);
		map.put("stuno", stuno);
		map.put("stno", stno);
		map1.put("stuno",stuno);
		map1.put("stno", stno);
		System.out.println(map1);
		System.out.println(map);
		List<Map> students=trainstudentDao.findInfoByPage(map);
		List<Map> student=trainstudentDao.findInfo(map1);
		if(students.size()==0 || student.size()==0){
			result.setMsg("对不起，没有学生信息，请重新输入");
			result.setStatus(0);
		}else if(students.size()!=0 && student.size()!=0 ){
			result.setMsg("查找成功");
			result.setData(students);
			result.setStatus(student.size());
		}
		return result;
	}




/*	 (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showGradeInfoByNo(java.lang.String)
	 
	public Result showGradeInfoByNo(String stuno) {
		Result result =new Result();
		Map<String,String> map=new HashMap<String,String>();
		map.put("stuno",stuno);
		List<Map> grades=trainstudentDao.findScoreInfoByNo(map);
		if(grades.size()==0){
			result.setMsg("对不起，没有成绩信息，请重新输入");
			result.setStatus(0);
		}else{
			result.setMsg("查找成功");
			result.setData(grades);
			result.setStatus(1);
		}
		return result;
	}
*/
	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showGradeInfoByPage(java.lang.String, int, int)
	 
	public Result showGradeInfo(String stuno,Integer page, Integer pageSize,String week,String month) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("stuno",stuno);
		map.put("page", page);
		map.put("pagesize", pageSize);
		map.put("week", week);
		map.put("month", month);
		map1.put("stuno",stuno);
		map1.put("week", week);
		map1.put("month", month);
		List<Map> grades=trainstudentDao.findScoreInfoByPage(map);
		List<Map> grade=trainstudentDao.findScoreInfoByNo(map1);
		System.out.println(map1);
		System.out.println(map);
		System.out.println(2);
		if(grades.size()==0 || grade.size()==0){
			result.setMsg("对不起，没有成绩信息，请重新输入");
			result.setStatus(0);
		}else if(grades.size()!=0 && grade.size()!=0 ){
			result.setMsg("查找成功");
			result.setData(grades);
			result.setStatus(grade.size());
		}
		return result;
	}
*/


	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showGradeInfoByConditionPage(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public Result showGradeInfoByConditionPage(String cno, Integer page, Integer pageSize,String month,String week,String stuno) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("cno",cno);
		map.put("page", page);
		map.put("pagesize", pageSize);
		map.put("month", month);
		map.put("week", week);
		map.put("stuno", stuno);
		map1.put("cno",cno);
		map1.put("week",week);
		map1.put("month", month);
		map1.put("stuno",stuno);
		System.out.println(map1);
		System.out.println(map);
		List<Map> grades=trainstudentDao.findScoreInfoByConditionPage(map);
		List<Map> grade=trainstudentDao.findScoreInfoByCondition(map1);
		if(grades.size()==0 || grade.size()==0){
			result.setMsg("对不起，没有成绩信息，请重新输入");
			result.setStatus(0);
		}else if(grades.size()!=0 && grade.size()!=0 ){
			result.setMsg("查找成功");
			result.setData(grades);
			result.setStatus(grade.size());
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showGradeInfoByPage(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	public Result showGradeInfoByPage(String stuno, Integer page,
			Integer pageSize, String week, String month) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("stuno",stuno);
		map.put("page", page);
		map.put("pagesize", pageSize);
		map.put("week", week);
		map.put("month", month);
		map1.put("stuno",stuno);
		map1.put("week", week);
		map1.put("month", month);
		List<Map> grades=trainstudentDao.findScoreInfoByPage(map);
		List<Map> grade=trainstudentDao.findScoreInfoByNo(map1);
		System.out.println(map1);
		System.out.println(map);
		System.out.println(2);
		if(grades.size()==0 || grade.size()==0){
			result.setMsg("对不起，没有成绩信息，请重新输入");
			result.setStatus(0);
		}else if(grades.size()!=0 && grade.size()!=0 ){
			result.setMsg("查找成功");
			result.setData(grades);
			result.setStatus(grade.size());
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#loadTrainStudnetInfoByPage(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public Result loadTrainStudnetInfoByPage( String stuname,Integer page,
			Integer pageSize) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("page", page);
		map.put("pagesize", pageSize);
		map.put("stuname", stuname);
		map1.put("stuname", stuname);
		List<Map> student=trainstudentDao.findTrainStudentInfo(map1);
		List<Map> students=trainstudentDao.findTrainStudentInfoPage(map);
		System.out.println(map);
		System.out.println(map1);
		if(students.size()==0 || student.size()==0){
			result.setMsg("对不起，没有实训信息！");
			result.setStatus(0);
		}else if(students.size()!=0 && students.size()!=0 ){
			result.setMsg("查找成功");
			result.setData(students);
			result.setStatus(student.size());
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#saveTrainStudentInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double)
	 */
	public Result saveTrainStudentInfo(String stuno, String tNo, String cno,
			String week, String month, Double grade) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("stuno", stuno);
		map.put("t_no", tNo);
		map.put("cno", cno);
		map.put("week", week);
		map.put("month", month);
		map.put("grade", grade);
		map1.put("cno", cno);
		map1.put("week", week);
		map1.put("month", month);
		map1.put("stuno", stuno);
		System.out.println(map);
		System.out.println(map1);
		List<Map> grades=trainstudentDao.findScoreInfoByCondition(map1);
		if(grades.size()==0){
			int results=trainstudentDao.saveGradeInfo(map);
			result.setMsg("录入成功");
			result.setStatus(results);
		}else{
			result.setMsg("对不起,成绩已经存在,不能重复录入");
			result.setStatus(0);	
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#modifyTrainStudentInfo(java.lang.String, java.lang.Double)
	 */
	public Result modifyTrainStudentInfo(int id, Double grade) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",id);
		map.put("grade",grade);
		int row=trainstudentDao.updateGradeInfo(map);
		System.out.println(row);
		if(row>0){
			result.setMsg("修改成功");
			result.setStatus(row);
		}else{
			result.setMsg("修改失败,重新修改!");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#deleteTrainStudentGradeInfo(int)
	 */
	public Result deleteTrainStudentGradeInfo(String id) {
		Result result=new Result();
		int row=trainstudentDao.deleteGradeInfo(id);
		if(row>0){
			result.setMsg("删除成功");
			result.setStatus(row);	
		}else{
			result.setMsg("删除失败,重新删除!");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#showGradeInfoByNo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Result showGradeInfoByNo(String stuno, String week, String month) {
		Result result =new Result();
		Map<String,String> map1=new HashMap<String,String>();
		map1.put("stuno",stuno);
		map1.put("week", week);
		map1.put("month", month);
		List<Map> grade=trainstudentDao.findScoreInfoByNo(map1);
		System.out.println(map1);
		if(grade.size()==0){
			result.setMsg("对不起，没有成绩信息，请重新输入");
			result.setStatus(0);
		}else if( grade.size()!=0 ){
			result.setMsg("查找成功");
			result.setData(grade);
			result.setStatus(grade.size());
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#findTrainInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public Result findTrainInfo(String stuno, String stuclass, String major,
			Integer page, Integer pageSize) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("page", page);
		map.put("pagesize", pageSize);
		map.put("stuclass", stuclass);
		map.put("stuno", stuno);
		map.put("major", major);
		map1.put("stuclass", stuclass);
		map1.put("stuno", stuno);
		map1.put("major", major);
		List<Map> student=trainstudentDao.findTrainInfo(map1);
		List<Map> students=trainstudentDao.findTrainInfoPage(map);
		System.out.println(map);
		System.out.println(map1);
		if(students.size()==0 || student.size()==0){
			result.setMsg("对不起，没有实训信息！");
			result.setStatus(0);
		}else if(students.size()!=0 && students.size()!=0 ){
			result.setMsg("查找成功");
			result.setData(students);
			result.setStatus(student.size());
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.hhit.basetrain.service.TrainStudentService#findGardeInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	public Result findGardeInfo(String stuno, String stuclass, String major,
			Integer page, Integer pageSize, String month, String week) {
		Result result =new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,String> map1=new HashMap<String,String>();
		map.put("stuno",stuno);
		map.put("page", page);
		map.put("pagesize", pageSize);
		map.put("week", week);
		map.put("month", month);
		map.put("stuclass", stuclass);
		map.put("major", major);
		map1.put("stuno",stuno);
		map1.put("week", week);
		map1.put("month", month);
		map1.put("stuclass", stuclass);
		map1.put("major", major);
		List<Map> grade=trainstudentDao.findScoreInfo(map1);
		List<Map> grades=trainstudentDao.findScoreInfoPage(map);
		System.out.println(map1);
		System.out.println(map);
		System.out.println(2);
		if(grades.size()==0 || grade.size()==0){
			result.setMsg("对不起，没有成绩信息，请重新输入");
			result.setStatus(0);
		}else if(grades.size()!=0 && grade.size()!=0 ){
			result.setMsg("查找成功");
			result.setData(grades);
			result.setStatus(grade.size());
		}
		return result;
	}

	

	

}
