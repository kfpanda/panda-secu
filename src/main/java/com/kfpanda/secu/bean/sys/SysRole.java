package com.kfpanda.secu.bean.sys;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class SysRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2640828845731155413L;

	private Long id;
	private Timestamp createTime;			//创建时间
	private String name;
	private String code;
	private Integer status;
	private Integer order;
	private String remark;
	
	private List<SysResource> resources;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public SysRole() {
		super();
	}

	public SysRole(Long id, Timestamp createTime, String name, String code, Integer status,
			Integer order, String remark) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.name = name;
		this.code = code;
		this.status = status;
		this.order = order;
		this.remark = remark;
	}
	public SysRole( Timestamp createTime, String name, String code, Integer status,
			Integer order, String remark) {
		super();
		this.createTime = createTime;
		this.name = name;
		this.code = code;
		this.status = status;
		this.order = order;
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysRole other = (SysRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public List<SysResource> getResources() {
		return resources;
	}
	public void setResources(List<SysResource> resources) {
		this.resources = resources;
	}
}