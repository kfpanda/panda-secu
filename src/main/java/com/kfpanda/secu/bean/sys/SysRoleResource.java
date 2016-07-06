package com.kfpanda.secu.bean.sys;

public class SysRoleResource {
	private Long id;
	private Long roleId;
	private Long rid;
	
	public SysRoleResource(Long roleId, Long rid) {
		super();
		this.roleId = roleId;
		this.rid = rid;
	}

	public SysRoleResource(Long id, Long roleId, Long rid) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.rid = rid;
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
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
}