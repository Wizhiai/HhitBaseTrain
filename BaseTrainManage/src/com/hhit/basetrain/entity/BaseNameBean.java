/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-26t上午11:10:55 
 */
public class BaseNameBean {

	/** 基地编号 */
	private Integer base_no;
	/** 基地名称 */
	private String base_name;

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

	@Override
	public String toString() {
		return "BaseNameBean [base_name=" + base_name + ", base_no=" + base_no
				+ "]";
	}

}
