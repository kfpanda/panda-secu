package com.kfpanda.secu.bean.sys;

public class SysUserResource {
	
	private Long id;
	private Long uId;
	private Long rId;

	public SysUserResource() {
		super();
	}
	public SysUserResource(Long id, Long uId, Long rId) {
		super();
		this.id = id;
		this.uId = uId;
		this.rId = rId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getuId() {
		return uId;
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	public void setrId(Long rId) {
		this.rId = rId;
	}
	public Long getrId() {
		return rId;
	}
	
}