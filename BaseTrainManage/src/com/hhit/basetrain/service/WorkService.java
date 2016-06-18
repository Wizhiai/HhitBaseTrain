package com.hhit.basetrain.service;

import java.util.Date;

import com.hhit.basetrain.entity.Result;
/**
 * 
 * @author mayu
 */

public interface WorkService {
	/**
	 * 上传作业
	 */
	public boolean holdWork(String wid,String cno,String cname,Integer base_no,String title,
			String content,String uploadDate,String uploadNo,String base_class,String endDate,String file);
	/**
	 * 查询作业
	 */
	public Result showWork(String base_class,Integer base_no,Integer page,Integer pagesize);
	/**
	 * 删除作业
	 */
	public Result deleteWork(String wid);
	/**
	 * 查询最新作业
	 */
	public Result searchUnfinishedWork(String stuno,String base_class,Integer base_no,
			Integer page,Integer pagesize,String currentDate);
	/**
	 * 查看未交过期的作业
	 */
	public Result searchUfinishedWorkPass(String stuno,String base_class,Integer base_no,
			Integer page,Integer pagesize,String currentDate);
	
	/**
	 * 提交作业
	 */
	public boolean uploadWork(String stuno,String wid,String uploadDate,String file,String filename,String title);
	/**
	 * 已交作业
	 */
	public Result uploadedWork(String stuno,Integer page,Integer pagesize);
	/**
	 * 删除已交作业
	 */
	public Result deleteUploadedwork(String stuno,String wid);
	/**
	 * 查询已交作业
	 */
	public Result showUploadWorks(Integer base_no,String base_class,String title,Integer page,Integer pagesize);
	/**
	 * 查询评论
	 */
	public Result showComments();
	/**
	 * 更新状态
	 */
	public boolean upDateIden(String stuno,String wid);
	/**
	 * 插入批改作业
	 */
	public boolean saveMarked(String stuno,String wid,String uploadDate,Double result,String comment,String markedfile);
	
	/**
	 * 学生查询已批作业
	 */
	public Result searchMarkedWork(String stuno,Integer page,Integer pagesize);
	/**
	 * 基地教师查询已交作业
	 */
	public Result searchAllFinishedWork(String base_class,Integer base_no,String title,Integer page,Integer pageSize);
	/**
	 * 基地教师查询未交作业
	 */
	public Result searchAllUnFinishedWork(String base_class,Integer base_no,String title,Integer page,Integer pageSize);
	/**
	 * 学校教师查询学生作业情况
	 */
	public Result searchStudentWork(String base_no,String stuno,Integer page,Integer pagesize);
	/**
	 * 重交作业
	 */
	public boolean reUpload(String stuno,String uploadDate,String file,String wid,String filename);
	
	/**
	 * 查询重交作业
	 */
	public Result reUploadResult(String wid,String stuno);
	/**
	 * 提醒交作业
	 * @param title
	 * @param stuno
	 * @param t_no
	 * @return
	 */
	
	public Result remindWork(String title,String stuno,String t_no);
	/**
	 * 获取提醒
	 * @param stuno
	 * @return
	 */
	public Result gainRemind(String stuno);
}
