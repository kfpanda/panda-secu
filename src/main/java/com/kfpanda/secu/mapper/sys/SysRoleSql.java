package com.kfpanda.secu.mapper.sys;


public class SysRoleSql {
	
	public static final String TABLE_NAME = "sys_role";
	public static final String FIELDS = "`id`,`createtime`,`name`,`code`,`status`,`sort`,`remark`";
	public static final String SAVE_FIELD = "`createtime`,`name`,`code`,`status`,`sort`,`remark`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{name},#{code},#{status},#{sort},#{remark}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static  final String FINDROLEBYCODE_SQL =  "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE code=#{code}";

	public static final String FINDROLES_SQL = "SELECT sr.* FROM sys_user su, sys_user_role ur, sys_role sr WHERE su.id=ur.uid AND ur.rid=sr.id AND su.username=#{userName}";
}
