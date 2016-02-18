package com.kfpanda.secu.bean.sys;

public class SysUserRole {

	private Long id;
	private Long uId;
	private Long roleid;

	public SysUserRole() {
		super();
	}

	public SysUserRole(Long id, Long uId, Long roleid) {
		super();
		this.id = id;
		this.uId = uId;
		this.roleid = roleid;
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

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
}