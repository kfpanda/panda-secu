package com.kfpanda.secu.mapper.sys;


public class SysSessionSql {
	
	public static final String TABLE_NAME = "sys_session";
	public static final String FIELDS = "`id`,`createtime`,`updatetime`,`sessionid`,`session`";
	public static final String SAVE_FIELD = "`createtime`,`updatetime`,`sessionid`,`session`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{updateTime},#{sessionId},#{session}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYSESSIONID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE sessionid=#{sessionId}";
	
	public static final String DELBYSESSIONID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE sessionid=#{sessionId}";
	public static final String UPDATEBYSESSIONID_SQL = "UPDATE " + TABLE_NAME + " SET session=#{session} WHERE sessionid=#{sessionId}";
	
}
