package com.kfpanda.secu.bean.sys;

public class SysRoleResource {
	private Long id;
	private Long roleId;
	private Long rId;
	
	public SysRoleResource(Long roleId, Long rId) {
		super();
		this.roleId = roleId;
		this.rId = rId;
	}

	public SysRoleResource(Long id, Long roleId, Long rId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.rId = rId;
	}

	public SysRoleResource() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getrId() {
		return rId;
	}
	public void setrId(Long rId) {
		this.rId = rId;
	}
}