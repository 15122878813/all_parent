package com.toec.common.vo;

import java.io.Serializable;

/**
 * 
 * 借助此对象封装服务端的响应数据
 * 1.响应的状态码  (1.表示正常数据，0表示异常数据)
 * 2.响应消息 （呈现给用户的消息，例如一个弹框中的数据）
 * 3.响应数据  （要呈现的正常数据，例如日志正常信息）
 * 4....
 *
 */
public class JsonResult implements Serializable{
	/**
	 * 
	 */
	//状态码
	private Integer state=1;
	//状态码对应的信息
	private String message="OK";
	//正常数据
	private Object data;
	private static final long serialVersionUID = 2700437712464346658L;
	public JsonResult(Object data) {
		super();
		this.data = data;
	}
	public JsonResult(String message) {
		super();
		this.message = message;
	}
	public JsonResult(Throwable e) {
		this.state=0;
		this.message=e.getMessage();
		//错误信息
	}
	public JsonResult() {
		super();
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}