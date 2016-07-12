package com.kfpanda.secu.mapper.sys;

import java.util.List;
import java.util.Map;

public class SysUserResourceSql {
	public static final String TABLE_NAME = "sys_user_resource";
	public static final String FIELDS = "`id`,`uid`,`rid`";
	public static final String SAVE_FIELD = "`uid`,`rid`";
	public static final String BEAN_FIELD_NAME = "#{uid},#{rid}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";

	public static final String FINDBYUSERNAME_SQL = "SELECT r.* FROM sys_user u, sys_user_resource ur, sys_resource r WHERE u.id=ur.uid AND ur.rid=r.id AND u.username=#{userName}";

	public static final String FINDBYUID_SQL = "SELECT r.* FROM sys_user_resource ur, sys_resource r WHERE ur.rid=r.id AND ur.uid=#{userId}";

	///List<Long> -> list[0..len]   Long[] -> array[0..len]
	public String getMutiDeleteRidSql(Map<String, List<Long>> param){
		StringBuffer sql = new StringBuffer("DELETE ");
		sql.append(" FROM ").append(TABLE_NAME).append(" WHERE rid in (-1 ");

		List<Long> ridList = param.get("list");
		for(int i = 0; i < ridList.size(); i++){
			sql.append(",#{list[").append(i).append("]}");
		}
		sql.append(")");
		return sql.toString();
	}
}
