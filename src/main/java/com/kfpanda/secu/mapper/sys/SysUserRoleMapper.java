package com.kfpanda.secu.mapper.sys;

import org.apache.ibatis.annotations.*;

import com.kfpanda.secu.bean.sys.SysUserRole;

import java.util.List;

public interface SysUserRoleMapper {
	@Insert(SysUserRoleSql.SAVE_SQL)
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(SysUserRole sysUserRole);
	
    @Delete(SysUserRoleSql.DELBYID_SQL)
    int deleteOne(Long id);

    @Select(SysUserRoleSql.FINDBYID_SQL)
    SysUserRole findOne(Long id);

    @SelectProvider(type = SysUserRoleSql.class, method = "getMutiDeleteRidSql")
    void mutiDeleteRid(List<Long> ridList);

    @SelectProvider(type = SysUserRoleSql.class, method = "getMutiDeleteUidSql")
    void mutiDeleteUid(List<Long> uidList);
}
