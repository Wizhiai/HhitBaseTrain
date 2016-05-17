package com.hhit.basetrain.dao;

import java.util.List;
import java.util.Map;

import com.hhit.basetrain.entity.FinishWorkBean;
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
}
