package com.kfpanda.secu.bean.sys;

import java.io.Serializable;
import java.sql.Timestamp;

public class SysResource implements Serializable {
	private static final long serialVersionUID = -3167749849144835451L;
	private Long id;
	private Timestamp createTime;			//创建时间
	private Timestamp updateTime;
	private Long pid;
	private String name;
	private String code;
	private String type;
	private String url;
	private Integer status;
	private Integer sort;
	private String remark;

	public SysResource() {
		super();
	}
	public SysResource(Long id, Timestamp createTime, Timestamp updateTime, Long pid, String name, String code,
			String type, String url, Integer status, Integer sort,
			String remark) {
		super();
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.code = code;
		this.type = type;
		this.url = url;
		this.status = status;
		this.sort = sort;
		this.remark = remark;
	}
	public SysResource( Timestamp createTime, Timestamp updateTime, Long pid, String name, String code,
			String type, String url, Integer status, Integer sort,
			String remark) {
		super();
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.pid = pid;
		this.name = name;
		this.code = code;
		this.type = type;
		this.url = url;
		this.status = status;
		this.sort = sort;
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return pid;
	}
	
	public void setPid(Long pid) {
		this.pid = pid;
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

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
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
		SysResource other = (SysResource) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}