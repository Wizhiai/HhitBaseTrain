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
    /**
     * 插入实训学生
     * @param stuno
     * @param stu_name
     * @param stu_sex
     * @param stu_class
     * @param major
     * @param phone
     * @param enter_year
     * @param birthday
     * @param base_no
     * @param base_class
     * @param cno
     * @param address
     * @param train_date
     * @return
     */
    public Result InputTrainStudent(String stuno,String stu_name,String stu_sex,String stu_class,String major,
			String phone,Integer enter_year,String birthday,Integer base_no,String base_class,String cno,String address,
			String train_date);
    /**
     * 统计课程号
     * @param manager_no
     * @return
     */
    public Result countTrainStudentByCno(String manager_no);
    /**
     * 实训程号相同的详细信息
     * @param base_no
     * @param cno
     * @return
     */
    public Result TrainStudentByCnoDetail(Integer base_no,String cno);
    /**
     * 统计班级
     * @param manager_no
     * @return
     */
    public Result countTrainStudentByClass(String manager_no);
    /**
     * 班级相同的实训信息
     */
    public Result TrainStudentByClassDetail(Integer base_no,String base_class);
    
    public Result loadBaseClass(String manager_no);
    /**
     * 学号模糊查询
     * @param stuno
     * @return
     */
    public Result searchStudentInfo(String stuno);
    /**
     * 基地管理员修改信息
     * @param stuno
     * @param train_date
     * @param base_class
     * @param phone
     * @param cno
     * @return
     */
	public Result baseadminModifyInfo(String stuno,String train_date,String base_class,String phone,String cno);
	/**
	 * 查询基地学生通过班级
	 * @param manager_no
	 * @param base_class
	 * @return
	 */
	public Result baseadminSearchTrainStudentByClass(String manager_no,String base_class);
	/**
	 * 删除学生
	 * @param stuno
	 * @return
	 */
	public Result deleteStudentInfo(String stuno);
    
}
