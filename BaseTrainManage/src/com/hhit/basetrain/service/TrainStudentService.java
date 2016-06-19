/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Mayu
 * @date 2016-4-25t下午12:52:53
 * TODO
 */
public interface TrainStudentService {
	/**
	 * 查找实训学生信息
	 */
	public Result showInfo(String sno);
	/**
	 * 查询实训基地
	 */
	public Result showBaseName(String sno);
	
	/**
	 * 查询实训学生具体信息
	 */
	public Result showBaseInfo(String stno,String stuno,Integer page,Integer pageSize);
	/**
	 * 通过学号查询实训学生成绩信息
	 */
	 public Result showGradeInfoByNo(String stuno,String week,String month);
    /**
     * 确定学号查询实训学生成绩信息进行分页
     */
    public Result showGradeInfoByPage(String stuno,Integer page,Integer pageSize,String week,String month);
    /**
     * 通过条件控制进行分页查询成绩
     * 
     */
    public Result showGradeInfoByConditionPage(String cno, Integer page, Integer pageSize,String month,String week,String stuno);

    /**
     * 基地教师查询实训学生信息分页
     */
    public Result loadTrainStudnetInfoByPage(String stuname,Integer page,Integer pageSize);
    
    /**
     * 插入学生成绩信息
     */
    public Result saveTrainStudentInfo(String stuno,String t_no,String cno,String week,String month,Double grade);
    
    /**
     * 修改学生成绩信息
     */
    public Result modifyTrainStudentInfo(int id,Double grade);
    
    /**
     * 删除成绩信息
     */
    public Result deleteTrainStudentGradeInfo(String id);
    
    /**
     * 
     * 学校教师查询学生实训信息
     */
    public Result findTrainInfo(String stuno,String stuclass,String major,Integer page,Integer pageSize);
    
    /**
     * 学校教师查询成绩信息
     */
    public Result findGardeInfo(String stuno,String stuclass,String major,Integer page,Integer pageSize,String month,String week);
    
}
