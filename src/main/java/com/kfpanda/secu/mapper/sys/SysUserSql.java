package com.kfpanda.secu.mapper.sys;


import com.kfpanda.secu.bean.sys.SysUser;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

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
			+ "r.status AS sr_status, r.sort AS sr_sort, r.remark AS sr_remark, rs.id AS rs_id, rs.createtime AS rs_createtime, rs.pid AS rs_pid,"
			+ " rs.name AS rs_name, rs.code AS rs_code, rs.type AS rs_type, rs.url AS rs_url, rs.status AS rs_status, rs.sort AS rs_sort, "
			+ "rs.remark AS rs_remark FROM sys_user u LEFT JOIN sys_user_role ur ON u.id=ur.uid LEFT JOIN sys_role r ON ur.rid=r.id "
			+ "LEFT JOIN sys_role_resource rr ON r.id=rr.roleid LEFT JOIN sys_resource rs ON rr.rid=rs.id WHERE u.username=#{userName}";

	public String getPagefindSql(Map<String, Object> param){
		StringBuffer sql = new StringBuffer("SELECT ");
		sql.append(FIELDS).append(" FROM ").append(TABLE_NAME).append(" WHERE 1=1 ");

		if(param.get("name") != null && StringUtils.isNotBlank(param.get("name").toString())){
			sql.append("AND name like concat('%',#{name},'%') ");
		}
		if(param.get("userName") != null && StringUtils.isNotBlank(param.get("userName").toString())){
			sql.append("AND username=#{userName} ");
		}
		if(param.get("status") != null){
			sql.append("AND status=#{status} ");
		}
		if(param.get("type") != null){
			sql.append("AND type=#{type} ");
		}
		if(param.get("telNo") != null && StringUtils.isNotBlank(param.get("telNo").toString())){
			sql.append("AND telno=#{telNo} ");
		}
		sql.append(" order by updatetime desc limit #{page.offset},#{page.pageSize}");

		return sql.toString();
	}

	public String getUpdateSql(SysUser sysUser){
		StringBuffer sql = new StringBuffer("UPDATE ");
		sql.append(TABLE_NAME).append(" SET updatetime=CURRENT_TIMESTAMP()");

		if(StringUtils.isNotBlank(sysUser.getName())){
			sql.append(",name=#{name}");
		}
		if(StringUtils.isNotBlank(sysUser.getNkName())){
			sql.append(",nkname=#{nkName}");
		}
		if(StringUtils.isNotBlank(sysUser.getTelNo())){
			sql.append(",telno=#{telNo}");
		}
		if(sysUser.getStatus() != null){
			sql.append(",status=#{status}");
		}
		if(sysUser.getType() != null){
			sql.append(",type=#{type}");
		}
		if(StringUtils.isNotBlank(sysUser.getEmail())){
			sql.append(",email=#{email}");
		}
		if(StringUtils.isNotBlank(sysUser.getIdCard())){
			sql.append(",idcard=#{idCard}");
		}
		if(sysUser.getSex() != null){
			sql.append(",sex=#{sex}");
		}
		if(StringUtils.isNotBlank(sysUser.getBirth())){
			sql.append(",birth=#{birth}");
		}
		if(StringUtils.isNotBlank(sysUser.getAddress())){
			sql.append(",address=#{address}");
		}
		sql.append(" WHERE username=#{userName}");

		return sql.toString();
	}
	
}
