package com.hhit.basetrain.entity;

import java.util.Date;

public class Work {
	/**
	 * 作业号
	 */
	private String wid;
	/**
	 * 课程号
	 */
	private String cno;
	/**
	 * 课程名
	 */
	private String cname;
	/**
	 * 基地号
	 */
	private Integer base_no;
	/**
	 * 作业标题
	 */
	private String title;
	/**
	 * 作业内容
	 */
	private String content;
	/**
	 * 上传日期
	 */
	private String uploadDate;
	/**
	 * 上传人
	 */
	private String uploadNo;
	/**
	 * 基地班级
	 */
	private String base_class;
	/**
	 * 结束日期
	 */
	private String endDate;
	/**
	 * 文件
	 */
	private String file;
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getBase_no() {
		return base_no;
	}
	public void setBase_no(Integer base_no) {
		this.base_no = base_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getUploadNo() {
		return uploadNo;
	}
	public void setUploadNo(String uploadNo) {
		this.uploadNo = uploadNo;
	}
	public String getBase_class() {
		return base_class;
	}
	public void setBase_class(String base_class) {
		this.base_class = base_class;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Work [wid=" + wid + ", cno=" + cno + ", cname=" + cname
				+ ", base_no=" + base_no + ", title=" + title + ", content="
				+ content + ", uploadDate=" + uploadDate + ", uploadNo="
				+ uploadNo + ", base_class=" + base_class + ", endDate="
				+ endDate + ", file=" + file + "]";
	}
	
	
}
