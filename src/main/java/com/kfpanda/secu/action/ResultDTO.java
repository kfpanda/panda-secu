package com.kfpanda.secu.action;

import com.kfpanda.core.page.Pageable;


public class ResultDTO {
	private Integer r;
	private Object data;
	private String msg;
	private Pageable page;
	
	public ResultDTO(Integer r, Object data, String msg){
		this.r = r;
		this.data = data;
		this.msg = msg;
	}
	
	public ResultDTO(Integer r, Object data, String msg, Pageable page){
		this.r = r;
		this.data = data;
		this.msg = msg;
		this.page = page;
	}

	public ResultDTO() {
	}

	public ResultDTO(int i, String msg) {
		this.r=1;
		this.msg=msg;
	}

	public Integer getR() {
		return r;
	}
	public void setR(Integer r) {
		this.r = r;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Pageable getPage() {
		return page;
	}
	public void setPage(Pageable page) {
		this.page = page;
	}

	public void clone(ResultDTO result){
		this.r = result.r;
		this.data = result.data;
		this.msg = result.msg;
		this.page = result.page;
	}
}

