/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author Jiya
 * @date 2016-4-18t下午02:41:45
 * 
 */
public class PlacardBean {

	/** 公告编号 */
	private Integer placard_no;
	/** 公告标题 */
	private String placard_title;
	/** 公告发布时间 */
	private String publish_time;
	/** 公告内容 */
	private String placard_content;
	/** 所属基地 */
	private String base_name;

	public Integer getPlacard_no() {
		return placard_no;
	}

	public void setPlacard_no(Integer placardNo) {
		placard_no = placardNo;
	}

	public String getPlacard_title() {
		return placard_title;
	}

	public void setPlacard_title(String placardTitle) {
		placard_title = placardTitle;
	}

	public String getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(String publishTime) {
		publish_time = publishTime;
	}

	public String getPlacard_content() {
		return placard_content;
	}

	public void setPlacard_content(String placardContent) {
		placard_content = placardContent;
	}

	public String getBase_name() {
		return base_name;
	}

	public void setBase_name(String baseName) {
		base_name = baseName;
	}

	@Override
	public String toString() {
		return "PlacardBean [base_name=" + base_name + ", placard_content="
				+ placard_content + ", placard_no=" + placard_no
				+ ", placard_title=" + placard_title + ", publish_time="
				+ publish_time + "]";
	}

}
