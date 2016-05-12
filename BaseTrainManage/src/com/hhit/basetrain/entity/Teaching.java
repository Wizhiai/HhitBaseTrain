/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author mayu
 */
public class Teaching {
	/**
	 * 课程号
	 */
	private String cno;
	/**
	 * 基地教师号
	 */
	private String t_no;
	/**
	 * 基地班级
	 */
	private String base_class;
	/**
	 * 课程计划
	 */
	private String studyplan;
	/**
	 * 课程考勤
	 */
	private String studycheck;
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getT_no() {
		return t_no;
	}
	public void setT_no(String t_no) {
		this.t_no = t_no;
	}
	public String getBase_class() {
		return base_class;
	}
	public void setBase_class(String base_class) {
		this.base_class = base_class;
	}
	public String getStudyplan() {
		return studyplan;
	}
	public void setStudyplan(String studyplan) {
		this.studyplan = studyplan;
	}
	public String getStudycheck() {
		return studycheck;
	}
	public void setStudycheck(String studycheck) {
		this.studycheck = studycheck;
	}
	@Override
	public String toString() {
		return "Teaching [cno=" + cno + ", t_no=" + t_no + ", base_class="
				+ base_class + ", studyplan=" + studyplan + ", studycheck="
				+ studycheck + "]";
	}

}
