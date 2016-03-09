package com.kfpanda.secu.bean.sys;

public class SysUserRole {

	private Long id;
	private Long uId;
	private Long roleId;

	public SysUserRole() {
		super();
	}

	public SysUserRole(Long id, Long uId, Long roleId) {
		super();
		this.id = id;
		this.uId = uId;
		this.roleId = roleId;
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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}