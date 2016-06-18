/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-5-12t下午03:13:14
 * 
 */
public class Academy {
	private String academy_no;
	private String academy_name;

	public String getAcademy_no() {
		return academy_no;
	}

	public void setAcdademy_no(String academyNo) {
		academy_no = academyNo;
	}

	public String getAcademy_name() {
		return academy_name;
	}

	public void setAcademy_name(String academyName) {
		academy_name = academyName;
	}

	@Override
	public String toString() {
		return "Academy [academy_name=" + academy_name + ", acdademy_no="
				+ academy_no + "]";
	}

}
