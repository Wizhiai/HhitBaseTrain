/**
 * 
 */
package com.hhit.basetrain.service;

import com.hhit.basetrain.entity.Result;

/**
 * @author Mayu
 * @date 2016-4-23t下午08:49:44
 * 
 */
public interface PlacardService {
	/**
	 * 通过基地管理员获取公告信息(基地教师)
	 */
	public Result loadPlacard (String id);
	/**
	 * 查询学校公告
	 */
	public Result loadSchoolPlacard();
	/**
	 * 通过基地管理员获取公告信息(学生)
	 * @param id
	 * @return
	 */
	public Result loadstudentPlacard (String id);
	/**
	 * 浏览全部常见问题信息
	 * @param id
	 * @return
	 */
	public Result skimAllQuestionInf();
	/**
	 * 通过基地号浏览常见问题
	 * @param base_name
	 * @return
	 */
	public Result skimQuestionInfByBaseNo(String base_no);
	/**
	 * 通过公告号显示常见问题
	 * @param placard_no
	 * @return
	 */
	public Result showQuestionInfByPlacardNo(String placard_no);
	/**
	 * 分页显示学校公告
	 * @param placard_no
	 * @return
	 */
	public Result showAllSchoolInf();
	/**
	 * 通过公告号显示学校公告
	 * @param placard_no
	 * @return
	 */
	public Result showSchoolPlacardInfByPlacardNo(String placard_no);
	
	/**
	 * 添加学校公告
	 * @param placard_no
	 * @return
	 */
	public Result addSchoolPlacard(String placard_title,String placard_content,String publish_author);
	/**
	 * 判断学校公告标题是否已经存在
	 * @param placard_no
	 * @return
	 */
	public Result isSchoolPlacardExit(String placard_title);
	/**
	 * 通过学校公告标题模糊查询
	 * @param placard_no
	 * @return
	 */
	public Result searchSchoolPlacardByTitle(String placard_title);
	/**
	 * 修改学校公告信息
	 * @param placard_no
	 * @return
	 */
	public Result modifySchoolPlacard(String placard_no,String placard_title,String placard_content,String publish_author);
	/**
	 * 删除学校公告
	 * @param placard_no
	 * @return
	 */
	public Result deleteSchoolPlacard(String placard_no);
	/**
	 * 分页显示基地公告
	 * @param placard_no
	 * @return
	 */
	public Result showAllBaseInf(String pulish_author);
	/**
	 * 通过公告号显示学校公告
	 * @param placard_no
	 * @return
	 */
	public Result showBasePlacardInfByPlacardNo(String placard_no);
	
	/**
	 * 添加基地公告
	 * @param placard_no
	 * @return
	 */
	public Result addBasePlacard(String placard_title,String placard_content,String publish_author,String placard_type);
	/**
	 * 判断学校公告标题是否已经存在
	 * @param placard_no
	 * @return
	 */
	public Result isBasePlacardExit(String placard_title,String publish_author);
	/**
	 * 通过基地公告标题模糊查询
	 * @param placard_no
	 * @return
	 */
	public Result searchBasePlacardByTitle(String placard_title,String placard_type,String publish_author);
	/**
	 * 修改基地公告信息
	 * @param placard_no
	 * @return
	 */
	public Result modifyBasePlacard(String placard_no,String placard_title,String placard_content,String placard_type,String publish_author);
	/**
	 * 删除基地公告
	 * @param placard_no
	 * @return
	 */
	public Result deleteBasePlacard(String placard_no);
}
