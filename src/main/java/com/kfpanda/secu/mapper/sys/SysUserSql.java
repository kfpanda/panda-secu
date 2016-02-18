package com.kfpanda.secu.mapper.sys;


public class SysUserSql {
	
	public static final String TABLE_NAME = "sys_user";
	public static final String FIELDS = "`id`,`createtime`,`updatetime`,`username`,`password`,`nkname`,`status`," +
						"`type`,`name`,`email`,`telno`,`idcard`,`sex`,`birth`,`integral`,`address`,`weichat`,`qq`,`face`,`remark`,`openid`";
	public static final String SAVE_FIELD = "`createtime`,`updatetime`,`username`,`password`,`nkname`,`status`," +
						"`type`,`name`,`email`,`telno`,`idcard`,`sex`,`birth`,`integral`,`address`,`weichat`,`qq`,`face`,`remark`,`openid`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{updateTime},#{userName},#{password},#{nkName},#{status},"
			+ "#{type},#{name},#{email},#{telNo},#{idCard},#{sex},#{birth},#{integral},#{address},#{weiChat},#{qq},#{face},#{remark},#{openId}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String UPDATE_SQL = "UPDATE " + TABLE_NAME + " SET updatetime=CURRENT_TIMESTAMP,username=#{userName}"
						+ ",password=#{password},nkname=#{nkName},status=#{status},type=#{type},name=#{name},email=#{email}"
						+",telno=#{telNo},idcard=#{idCard},sex=#{sex},birth=#{birth},integral=#{integral},address=#{address}"
						+",weichat=#{weiChat},qq=#{qq},face=#{face},remark=#{remark},openid=#{openId} WHERE id=#{id}";
	public static final String FINDBYUSERNAME_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE username=#{userName}";
	
	public static final String FINDURR_SQL = "SELECT u.*, r.id AS sr_id, r.createtime AS sr_createtime, r.name AS sr_name, r.code AS sr_code, "
			+ "r.status AS sr_status, r.order AS sr_order, r.remark AS sr_remark, rs.id AS rs_id, rs.createtime AS rs_createtime, rs.pid AS rs_pid," 
			+ " rs.name AS rs_name, rs.code AS rs_code, rs.type AS rs_type, rs.url AS rs_url, rs.status AS rs_status, rs.order AS rs_order, " 
			+ "rs.remark AS rs_remark FROM sys_user u LEFT JOIN sys_user_role ur ON u.id=ur.uid LEFT JOIN sys_role r ON ur.roleid=r.id " 
			+ "LEFT JOIN sys_role_resource rr ON r.id=rr.roleid LEFT JOIN sys_resource rs ON rr.rid=rs.id WHERE u.username=#{userName}";
	
}
