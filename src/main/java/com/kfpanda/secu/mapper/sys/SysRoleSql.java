package com.kfpanda.secu.mapper.sys;


import com.kfpanda.secu.bean.sys.SysRole;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class SysRoleSql {
	
	public static final String TABLE_NAME = "sys_role";
	public static final String FIELDS = "`id`,`createtime`,`updatetime`,`name`,`code`,`status`,`sort`,`remark`";
	public static final String SAVE_FIELD = "`createtime`,`updatetime`,`name`,`code`,`status`,`sort`,`remark`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{updateTime},#{name},#{code},#{status},#{sort},#{remark}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static  final String FINDROLEBYCODE_SQL =  "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE code=#{code}";

	public static final String FINDROLES_SQL = "SELECT sr.* FROM sys_user su, sys_user_role ur, sys_role sr WHERE su.id=ur.uid AND ur.rid=sr.id AND su.username=#{userName}";

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

		if(param.get("name") != null && StringUtils.isNotBlank(param.get("name").toString())){
			sql.append("AND name like concat('%',#{name},'%') ");
		}
		if(param.get("code") != null && StringUtils.isNotBlank(param.get("code").toString())){
			sql.append("AND code=#{code} ");
		}
		if(param.get("status") != null){
			sql.append("AND status=#{status} ");
		}
		sql.append(" order by updatetime desc limit #{page.offset},#{page.pageSize}");

		return sql.toString();
	}

	public String getUpdateSql(SysRole sysRole){
		StringBuffer sql = new StringBuffer("UPDATE ");
		sql.append(TABLE_NAME).append(" SET updatetime=CURRENT_TIMESTAMP()");

		if(StringUtils.isNotBlank(sysRole.getName())){
			sql.append(",name=#{name}");
		}
		if(StringUtils.isNotBlank(sysRole.getCode())){
			sql.append(",code=#{code}");
		}
		if(sysRole.getStatus() != null){
			sql.append(",status=#{status}");
		}
		if(sysRole.getSort() != null){
			sql.append(",sort=#{sort}");
		}
		if(StringUtils.isNotBlank(sysRole.getRemark())){
			sql.append(",remark=#{remark}");
		}
		sql.append(" WHERE id=#{id}");

		return sql.toString();
	}
}
