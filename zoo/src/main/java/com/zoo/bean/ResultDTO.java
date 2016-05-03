package com.zoo.bean;

import com.awifi.core.page.Page;




public class ResultDTO {
	/** * 返回值 */
	private Integer r;
	/** * 数据 */
	private Object data;
	/** * 信息 */
	private String msg;
    private Page page;
    
	public ResultDTO(Integer r, String msg, Page page){
		this.r = r;
		this.msg = msg;
		this.page = page;
	}
	public ResultDTO(Integer r, String msg){
		this.r = r;
		this.msg = msg;
	}
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public ResultDTO() {
        // TODO Auto-generated constructor stub
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
    
}

