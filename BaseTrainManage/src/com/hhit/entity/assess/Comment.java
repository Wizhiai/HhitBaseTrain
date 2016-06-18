/**
 * 
 */
package com.hhit.entity.assess;

/**
 *@author hulijie
 * @date 2016-5-30t下午02:51:38
 * TODO
 */
public class Comment {
	private int id;
	private String content;
	private int emotion;
	private String time;
	private String username;
	private String userno;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the userno
	 */
	public String getUserno() {
		return userno;
	}
	/**
	 * @param userno the userno to set
	 */
	public void setUserno(String userno) {
		this.userno = userno;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the emotion
	 */
	public int getEmotion() {
		return emotion;
	}
	/**
	 * @param emotion the emotion to set
	 */
	public void setEmotion(int emotion) {
		this.emotion = emotion;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
}
