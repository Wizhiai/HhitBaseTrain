/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-29t下午03:28:59 基地特色实体类
 */
public class BaseAdvantageBean {
	/** 基地编号 */
	private Integer base_no;
	/** 基地办学特色和优势 */
	private String base_advantage;

	public Integer getBase_no() {
		return base_no;
	}

	public void setBase_no(Integer baseNo) {
		base_no = baseNo;
	}

	public String getBase_advantage() {
		return base_advantage;
	}

	public void setBase_advantage(String baseAdvantage) {
		base_advantage = baseAdvantage;
	}

	@Override
	public String toString() {
		return "BaseAdvantageBean [base_advantage=" + base_advantage
				+ ", base_no=" + base_no + "]";
	}

}
