package com.kfpanda.secu.mapper.sys;


public class SysResourceSql {
	
	public static final String TABLE_NAME = "sys_resource";
	public static final String FIELDS = "`id`,`pid`,`name`,`code`,`type`,`url`,`status`,`sort`,`remark`,`createtime`";
	public static final String SAVE_FIELD = "`pid`,`name`,`code`,`type`,`url`,`status`,`sort`,`remark`,`createtime`";
	public static final String BEAN_FIELD_NAME = "#{pid},#{name},#{code},#{type},#{url},#{status},#{sort},#{remark},#{createTime}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	
}
