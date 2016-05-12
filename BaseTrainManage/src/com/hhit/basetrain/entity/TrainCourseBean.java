/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-28t上午11:29:08
 * 
 */
public class TrainCourseBean {

	/** 课程号 */
	private String cno;
	/** 基地号 */
	private Integer base_no;
	/** 基地名称 */
	private String base_name;
	/** 课程名 */
	private String cname;
	/** 花费 */
	private Integer cost;
	/** 花费时间 */
	private Double term;

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public String getBase_name() {
		return base_name;
	}

	public void setBase_name(String baseName) {
		base_name = baseName;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Double getTerm() {
		return term;
	}

	public void setTerm(Double term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "TrainCourseBean [base_name=" + base_name + ", base_no="
				+ base_no + ", cname=" + cname + ", cno=" + cno + ", cost="
				+ cost + ", term=" + term + "]";
	}

}
