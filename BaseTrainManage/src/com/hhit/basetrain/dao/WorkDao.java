package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.FinishWorkBean;
import com.hhit.basetrain.entity.MarkedWork;
import com.hhit.basetrain.entity.Work;

public interface WorkDao {
	/**
	 * 上传作业
	 */
	public int saveWork(Work work);
	/**
	 * 查找作业
	 */
	public List<Work> findWorkByBase(Map map);
	/**
	 * 查询作业分页
	 */
	public List<Work> findWorkByBasePage(Map map);
	/**
	 * 删除作业
	 */
	public int deleteWorkById(String wid);
	/**
	 * 查询最新作业
	 */
	public List<Work> findWorkUnfinished(Map map);
	/**
	 * 查询最新作业分页
	 */
	public List<Work> findWorkUnfinishedPage(Map map);
	/**
	 * 查询超期未交的作业
	 */
	public List<Work> findWorkUnfinishedPassed(Map map);
	/**
	 * 查询超期未交的作业分页
	 */
	public List<Work> findWorkUnfinishedPassedPage(Map map);
	/**
	 * 提交作业
	 */
	public int insertFinished(FinishWorkBean work);
	/**
	 * 查找已交作业
	 */
	public List<Map> findWorkUpload(String stuno);
	/**
	 * 已交作业分页
	 */
	public List<Map> findWorkUploadPage(Map map);
	/**
	 * 删除已交作业
	 */
	public int deleteuploadedwork(FinishWorkBean finish);

	/**
	 * 基地教师查询已交作业
	 */
	public List<Map> findFinishedWork(Map map);
	/**
	 * 基地教师查询已交作业分页
	 */
	public List<Map> findFinishedWorkPage(Map map);
	/**
	 * 查询评论
	 */
	public List<String> findComments();
	/**
	 * 插入批改作业
	 */
	public int saveMarkedWork(MarkedWork work);
	/**
	 * 更细状态
	 */
	public int updateIdentity(FinishWorkBean finish);
	/**
	 * 学生查询已批作业分页
	 */
	public List<Map> findWorkMarkPage(Map map);
	/**
	 * 查询已批作业
	 */
	public List<Map> findWorkMark(String stuno);
	/**
	 * 查询所有学生的已交作业情况分页
	 */
	public List<Map> findAllFinishedWorkPage(Map map);
	/**
	 * 查询所有学生的已交作业情况
	 */
	public List<Map> findAllFinishedWork(Map map);
	/**
	 * 查询所有学生的未交作业情况分页
	 */
	public List<Map> findUnfinishedWorkPage(Map map);
	/**
	 * 查询所有学生的未交作业情况
	 */
	public List<Map> findUnfinishedWork(Map map);
	/**
	 * 学校教师查询学生作业分页
	 */
	public List<Map> findstudentworkPage(Map map);
	/**
	 * 学校教师查询学生作业
	 */
	public List<Map> findstudentwork(Map map);
	/**
	 * 重交作业
	 */
	public int updateFinshedWork(FinishWorkBean finish);
	/**
	 * 查询重交的作业
	 * 
	 */
	public Map findReuploadWork(Map map);
	
	/**
	 * 提醒交作业
	 */
	public int insertTixingInfo(Map map);
	
	/**
	 * 查询是否重复提醒
	 */
	public Map findTixingInfo(Map map);
	/**
	 * 收到提醒
	 */
	public List<Map> findTixing(String stuno);
	/**
	 * 删除提醒
	 */
	public int deleteTixing(Map map);
}
