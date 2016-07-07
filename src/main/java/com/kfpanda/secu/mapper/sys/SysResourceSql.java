package com.kfpanda.secu.mapper.sys;


import com.kfpanda.secu.bean.sys.SysResource;
import com.util.common.StringUtil;
import org.apache.commons.lang3.StringUtils;
import sun.org.mozilla.javascript.internal.ObjToIntMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SysResourceSql {
	
	public static final String TABLE_NAME = "sys_resource";
	public static final String FIELDS = "`id`,`pid`,`name`,`code`,`type`,`url`,`status`,`sort`,`remark`,`createtime`,`updatetime`";
	public static final String SAVE_FIELD = "`pid`,`name`,`code`,`type`,`url`,`status`,`sort`,`remark`,`createtime`,`updatetime`";
	public static final String BEAN_FIELD_NAME = "#{pid},#{name},#{code},#{type},#{url},#{status},#{sort},#{remark},#{createTime},#{updateTime}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";

	///List<Long> -> list[0..len]   Long[] -> array[0..len]
	public String getMutiDeleteSql(Map<String, List<Long>> param){
		StringBuffer sql = new StringBuffer("DELETE ");
		sql.append(" FROM ").append(TABLE_NAME).append(" WHERE id in (-1 ");

		List<Long> idList = param.get("list");
		for(int i = 0; i < idList.size(); i++){
			sql.append(",#{list[").append(i).append("]}");
		}
		sql.append(")");
		return sql.toString();
	}

	public String getPagefindSql(Map<String, Object> param){
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(FIELDS).append(" FROM ").append(TABLE_NAME).append(" WHERE 1=1 ");

		if(param.get("pid") != null){
			sql.append("AND pid=#{pid} ");
		}
		if(param.get("name") != null && StringUtils.isNotBlank(param.get("name").toString())){
			sql.append("AND name like concat('%',#{name},'%') ");
		}
		if(param.get("code") != null && StringUtils.isNotBlank(param.get("code").toString())){
			sql.append("AND code=#{code} ");
		}
		if(param.get("type") != null && StringUtils.isNotBlank(param.get("type").toString())){
			sql.append("AND type=#{type} ");
		}
		if(param.get("url") != null && StringUtils.isNotBlank(param.get("url").toString())){
			sql.append("AND url=#{url} ");
		}
		if(param.get("status") != null){
			sql.append("AND status=#{status} ");
		}
		sql.append(" order by updatetime desc limit #{page.offset},#{page.pageSize}");

		return sql.toString();
	}

	public String getUpdateSql(SysResource sysResource){
		StringBuffer sql = new StringBuffer("UPDATE ");
		sql.append(TABLE_NAME).append(" SET updatetime=CURRENT_TIMESTAMP()");

		if(sysResource.getPid() != null){
			sql.append(",pid=#{pid}");
		}
		if(StringUtils.isNotBlank(sysResource.getName())){
			sql.append(",name=#{name}");
		}
		if(StringUtils.isNotBlank(sysResource.getCode())){
			sql.append(",code=#{code}");
		}
		if(StringUtils.isNotBlank(sysResource.getType())){
			sql.append(",type=#{type}");
		}
		if(StringUtils.isNotBlank(sysResource.getUrl())){
			sql.append(",url=#{url}");
		}
		if(sysResource.getStatus() != null){
			sql.append(",status=#{status}");
		}
		if(sysResource.getSort() != null){
			sql.append(",sort=#{sort}");
		}
		if(StringUtils.isNotBlank(sysResource.getRemark())){
			sql.append(",remark=#{remark}");
		}
		sql.append(" WHERE id=#{id}");

		return sql.toString();
	}
	
}
