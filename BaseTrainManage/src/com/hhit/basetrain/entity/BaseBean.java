/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-24t下午05:31:37
 */
public class BaseBean {

	/** 基地编号 */
	private Integer base_no;
	/** 基地名称 */
	private String base_name;
	/** 基地地址 */
	private String base_address;
	/** 成立时间 */
	private String establish_time;

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

	public String getBase_address() {
		return base_address;
	}

	public void setBase_address(String baseAddress) {
		base_address = baseAddress;
	}

	public String getEstablish_time() {
		return establish_time;
	}

	public void setEstablish_time(String establishTime) {
		establish_time = establishTime;
	}

	@Override
	public String toString() {
		return "BaseBean [base_address=" + base_address + ", base_name="
				+ base_name + ", base_no=" + base_no + ", establish_time="
				+ establish_time + "]";
	}

}
