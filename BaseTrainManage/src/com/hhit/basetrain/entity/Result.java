/**
 * 
 */
package com.hhit.basetrain.entity;

import java.io.Serializable;

/**
 * @author Jiya
 * @date 2016-4-17t下午01:57:48
 * 返回结果实体类
 */
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 返回结果状态*/
	private int status;
	/** 返回消息*/
	private String msg;
	/** 返回数据*/
	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [data=" + data + ", msg=" + msg + ", status=" + status
				+ "]";
	}
}
