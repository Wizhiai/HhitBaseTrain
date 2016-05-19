package com.hhit.basetrain.entity;
/**
 * 
 * @author mayu
 */
public class MarkedWork {
	/**
	 * 学号
	 */
	private String stuno;
	/**
	 * 作业号
	 */
	private String wid;
	/**
	 * 上传时间
	 */
	private String uploadDate;
	/**
	 * 分数
	 */
	private Double result;
	/**
	 * 评论
	 */
	private String comment;
	
	/**
	 * 文件
	 */
	private String markedfile;
	
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Double getResult() {
		return result;
	}
	public void setResult(Double result) {
		this.result = result;
	}
	public String getComment() {
		return comment;
	}
	public String getMarkedfile() {
		return markedfile;
	}
	public void setMarkedfile(String markedfile) {
		this.markedfile = markedfile;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "MarkedWork [stuno=" + stuno + ", wid=" + wid + ", uploadDate="
				+ uploadDate + ", result=" + result + ", comment=" + comment
				+ "]";
	}
	
	
}
