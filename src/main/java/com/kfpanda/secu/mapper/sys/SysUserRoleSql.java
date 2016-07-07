package com.kfpanda.secu.mapper.sys;

import java.util.List;
import java.util.Map;

public class SysUserRoleSql {
	public static final String TABLE_NAME = "sys_user_role";
	public static final String FIELDS = "`id`,`uid`,`rid`";
	public static final String SAVE_FIELD = "`uid`,`rid`";
	public static final String BEAN_FIELD_NAME = "#{uid},#{rid}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";

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

	///List<Long> -> list[0..len]   Long[] -> array[0..len]
	public String getMutiDeleteUidSql(Map<String, List<Long>> param){
		StringBuffer sql = new StringBuffer("DELETE ");
		sql.append(" FROM ").append(TABLE_NAME).append(" WHERE uid in (-1 ");

		List<Long> ridList = param.get("list");
		for(int i = 0; i < ridList.size(); i++){
			sql.append(",#{list[").append(i).append("]}");
		}
		sql.append(")");
		return sql.toString();
	}
}
