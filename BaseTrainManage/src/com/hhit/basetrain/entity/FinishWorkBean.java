package com.hhit.basetrain.entity;
/**
 * 
 * @author mayu
 */
public class FinishWorkBean {
	/**
	 * 学号
	 */
	private String stuno;
	/**
	 * 作业号
	 */
	private String wid;
	/**
	 * 上传日期
	 */
	private String uploadDate;
	/**
	 * 文件
	 */
	private String file;
	/**
	 * 文件名
	 * @return
	 */
	private String filename;
	
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
	
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "FinishWorkBean [stuno=" + stuno + ", wid=" + wid
				+ ", uploadDate=" + uploadDate + ", file=" + file + "]";
	}
	
	
}
