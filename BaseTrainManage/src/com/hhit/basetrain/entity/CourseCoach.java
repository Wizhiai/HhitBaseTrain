/**
 * 
 */
package com.hhit.basetrain.entity;

/**
 * @author mayu
 */
public class CourseCoach {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 课程号
	 */
	private String cno;
	/**
	 * 课程名
	 */
	private String cname;
	/**
	 * 学期
	 */
	private int term;
	/**
	 * 课辅资料名称
	 */
	private String studydataname;
	/**
	 * 课辅资料
	 */
	private String studydata;
	/**
	 * 上传日期
	 */
	private String uploadDate;
	/**
	 * 上传人编号
	 */
	private String uploadNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getStudydataname() {
		return studydataname;
	}
	public void setStudydataname(String studydataname) {
		this.studydataname = studydataname;
	}
	public String getStudydata() {
		return studydata;
	}
	public void setStudydata(String studydata) {
		this.studydata = studydata;
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
	@Override
	public String toString() {
		return "CourseCoach [cno=" + cno + ", cname=" + cname + ", term="
				+ term + ", studydataname=" + studydataname + ", studydata="
				+ studydata + ", uploadDate=" + uploadDate + ", uploadNo="
				+ uploadNo + "]";
	}
	
	
	
	
}
