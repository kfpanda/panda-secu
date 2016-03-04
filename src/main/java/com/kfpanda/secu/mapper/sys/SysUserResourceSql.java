package com.kfpanda.secu.mapper.sys;

public class SysUserResourceSql {
	public static final String TABLE_NAME = "sys_user_resource";
	public static final String FIELDS = "`id`,`uid`,`rid`";
	public static final String SAVE_FIELD = "`uid`,`rid`";
	public static final String BEAN_FIELD_NAME = "#{uid},#{rid}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
}
