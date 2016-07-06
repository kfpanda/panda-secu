package com.kfpanda.secu.bean.sys;

public class SysUserResource {
	
	private Long id;
	private Long uid;
	private Long rid;

	public SysUserResource() {
		super();
	}
	public SysUserResource(Long id, Long uid, Long rid) {
		super();
		this.id = id;
		this.uid = uid;
		this.rid = rid;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}
}