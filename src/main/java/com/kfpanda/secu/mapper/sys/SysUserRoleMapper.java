package com.kfpanda.secu.mapper.sys;

import com.kfpanda.secu.bean.sys.SysRoleResource;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.kfpanda.secu.bean.sys.SysUserRole;
import org.apache.ibatis.annotations.Select;

public interface SysUserRoleMapper {
	@Insert(SysUserRoleSql.SAVE_SQL)
    int save(SysUserRole sysUserRole);
	
    @Delete(SysUserRoleSql.DELBYID_SQL)
    int deleteById(Long id);

    @Select(SysUserRoleSql.FINDBYID_SQL)
    SysUserRole findOne(Long id);
}
