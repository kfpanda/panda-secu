package com.kfpanda.secu.bean.sys;

import java.io.Serializable;
import java.sql.Timestamp;


public class SysSession implements Serializable{
	private static final long	serialVersionUID	= 6042963404088903293L;
	
	private Long id;
	private Timestamp createTime;			//创建时间
	private String sessionId;
	private String session;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
