package com.kfpanda.secu.mapper.sys;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.kfpanda.secu.bean.sys.SysRole;

public interface SysRoleMapper {
	
	@Insert(SysRoleSql.SAVE_SQL)
    int save(SysRole sysRole);
	
    @Delete(SysRoleSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(SysRoleSql.FINDBYID_SQL)
    SysRole findOne(Long id);
    
    @Select(SysRoleSql.FINDROLES_SQL)
    List<SysRole> findRoles(String userName);
}