package com.kfpanda.secu.mapper.sys;


public class SysRoleResourceSql {
    public static final String TABLE_NAME = "sys_role_resource";
    public static final String FIELDS = "`id`,`roleid`,`rid`";
    public static final String SAVE_FIELD = "`roleid`,`rid`";
    public static final String BEAN_FIELD_NAME = "#{roleid},#{rid}";
    
    public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
    public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
}
