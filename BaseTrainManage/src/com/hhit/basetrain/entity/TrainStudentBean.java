/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Mayu
 * @date 2016-5-22t上午10:34:40
 * TODO
 */
public class TrainStudentBean {
	/**
	 * 学号
	 */
	private String stuno;
	/**
	 * 姓名
	 */
	private String stu_name;
	/**
	 * 基地班级
	 */
	private String base_class;
	/**
	 * 课程号
	 */
	private String cno;
	/**
	 * 课程名
	 */
	private String cname;
	/**
	 * 实训时间
	 */
	private String train_date;
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
	 * @return the stu_name
	 */
	public String getStu_name() {
		return stu_name;
	}
	/**
	 * @param stuName the stu_name to set
	 */
	public void setStu_name(String stuName) {
		stu_name = stuName;
	}
	/**
	 * @return the base_class
	 */
	public String getBase_class() {
		return base_class;
	}
	/**
	 * @param baseClass the base_class to set
	 */
	public void setBase_class(String baseClass) {
		base_class = baseClass;
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
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the train_date
	 */
	public String getTrain_date() {
		return train_date;
	}
	/**
	 * @param trainDate the train_date to set
	 */
	public void setTrain_date(String trainDate) {
		train_date = trainDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TrainStudentBean [base_class=" + base_class + ", cname="
				+ cname + ", cno=" + cno + ", stu_name=" + stu_name
				+ ", stuno=" + stuno + ", train_date=" + train_date + "]";
	}
	
	
}
