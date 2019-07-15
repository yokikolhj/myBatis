package com.shirly.data.model;

public class DataResponse {
	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;
	private Object data;
	private Object count;
	
	public DataResponse() {
		this.setCount(0);
		this.setCode("");
		this.setMsg("");
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public Object getCount() {
		return count;
	}
	public void setCount(Object count) {
		this.count = count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
