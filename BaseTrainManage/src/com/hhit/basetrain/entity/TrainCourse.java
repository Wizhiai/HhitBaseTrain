/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-18t下午02:59:06
 *  实训课程实体类
 */
public class TrainCourse {

	/** 课程号 */
	private String cno;
	/** 基地号 */
	private Integer base_no;
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
		return "TrainCourse [base_no=" + base_no + ", cname=" + cname
				+ ", cno=" + cno + ", cost=" + cost + ", term=" + term + "]";
	}

}
