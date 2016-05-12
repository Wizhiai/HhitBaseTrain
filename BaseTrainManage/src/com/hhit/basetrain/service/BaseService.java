/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Jiya
 * @date 2016-4-23t下午04:26:01
 * 
 */
public interface BaseService {

	/**
	 * 通过基地名模糊查找浏览基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimBaseInfByName(String base_name);
	/**
	 * 通过基地地址模糊查找浏览基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimBaseInfByAddress(String base_address);
	/**
	 * 通过课程模糊查找浏览基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimBaseInfByCourse(String cname);
	/**
	 * 浏览全部基地部分信息
	 * @param no
	 * @return
	 */
	public Result skimAllBaseInf();
	/**
	 * 显示全部基地名称
	 * @param no
	 * @return
	 */
	public Result showAllBaseName();
	/**
	 * 通过基地号显示基地基本信息
	 * @param no
	 * @return
	 */
	public Result showBaseBasicInfoByNo(String base_no);
	/**
	 * 通过基地号显示基地建设与管理状况
	 * @param no
	 * @return
	 */
	public Result showBaseBuildInfoByNo(String base_no);
	/**
	 * 通过基地号显示基地场地与设施条件
	 * @param no
	 * @return
	 */
	public Result showBaseFieldInfoByNo(String base_no);
	/**
	 * 通过基地号显示基地实训项目目标及内容
	 * @param no
	 * @return
	 */
	public Result showBaseContentInfoByNo(String base_no);
	/**
	 * 通过基地号显示基地教师与辅导队伍
	 * @param no
	 * @return
	 */
	public Result showBaseCoachInfoByNo(String base_no);
	/**
	 * 通过基地号显示基地科研与技术活动
	 * @param no
	 * @return
	 */
	public Result showBaseResearchInfoByNo(String base_no);
	/**
	 * 通过基地号显示基地实践效果与能力开发
	 * @param no
	 * @return
	 */
	public Result showBaseEffectInfoByNo(String base_no);
	/**
	 * 通过基地号显示基地企业联盟
	 * @param no
	 * @return
	 */
	public Result showBaseAllianceInfoByNo(String base_no);
	/**
	 * 通过基地号显示基地特色
	 * @param no
	 * @return
	 */
	public Result showBaseAdvantageInfoByNo(String base_no);
}
