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
	public boolean uploadWork(String stuno,String wid,String uploadDate,String file);
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
}
