package com.kfpanda.secu.mapper.sys;

public class SysUserRoleSql {
	public static final String TABLE_NAME = "sys_user_role";
	public static final String FIELDS = "`id`,`uid`,`roleid`";
	public static final String SAVE_FIELD = "`uid`,`roleid`";
	public static final String BEAN_FIELD_NAME = "#{uid},#{roleid}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
}
