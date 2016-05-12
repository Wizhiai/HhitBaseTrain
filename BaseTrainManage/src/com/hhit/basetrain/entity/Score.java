/**
 * 
 */
package com.hhit.basetrain.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Mayu
 * @date 2016-5-4t下午12:28:18
 * TODO
 */
public class Score {
	/**
	 * 自增Id
	 */
	private String id;
	/**
	 * 课程号
	 */
	private String cno;
	/**
	 * 学号
	 */
	private String stuno;
	/**
	 * 教师号
	 */
	private String t_no;
	/**
	 * 月份
	 */
	private String month;
	/**
	 * 星期
	 */
	private String week;
	/**
	 * 成绩
	 */
	private Double grade;
	/**
	 * 考试试卷
	 */
	private String exampaper;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the cno
	 */
	public String getCno() {
		return cno;
	}
	/**
	 * @param cno the cno to set
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}
	/**
	 * @return the stuno
	 */
	public String getStuno() {
		return stuno;
	}
	/**
	 * @param stuno the stuno to set
	 */
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	/**
	 * @return the t_no
	 */
	public String getT_no() {
		return t_no;
	}
	/**
	 * @param tNo the t_no to set
	 */
	public void setT_no(String tNo) {
		t_no = tNo;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the week
	 */
	public String getWeek() {
		return week;
	}
	/**
	 * @param week the week to set
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	/**
	 * @return the grade
	 */
	public Double getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	/**
	 * @return the exampaper
	 */
	public String getExampaper() {
		return exampaper;
	}
	/**
	 * @param exampaper the exampaper to set
	 */
	public void setExampaper(String exampaper) {
		this.exampaper = exampaper;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Score [cno=" + cno + ", grade=" + grade + ", id=" + id
				+ ", month=" + month + ", stuno=" + stuno + ", t_no=" + t_no
				+ ", week=" + week + "]";
	} 
	
	
	
	
	
	

}
