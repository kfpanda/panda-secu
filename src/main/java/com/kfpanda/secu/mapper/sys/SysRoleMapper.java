package com.kfpanda.secu.mapper.sys;

import java.util.List;

import com.kfpanda.core.page.Pageable;
import org.apache.ibatis.annotations.*;
import com.kfpanda.secu.bean.sys.SysRole;

public interface SysRoleMapper {
	
	@Insert(SysRoleSql.SAVE_SQL)
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(SysRole sysRole);
	
    @Delete(SysRoleSql.DELBYID_SQL)
    int deleteOne(Long id);
    
    @Select(SysRoleSql.FINDBYID_SQL)
    SysRole findOne(Long id);

    @Select(SysRoleSql.FINDROLEBYCODE_SQL)
    SysRole findRole(String roleCode);
    
    @Select(SysRoleSql.FINDROLES_SQL)
    List<SysRole> findRoles(String userName);

    @UpdateProvider(type = SysRoleSql.class, method = "getUpdateSql")
    int update(SysRole sysRole);

    @SelectProvider(type = SysRoleSql.class, method = "getMutiDeleteSql")
    void multiDelete(List<Long> ids);

    @SelectProvider(type = SysRoleSql.class, method = "getPagefindSql")
    List<SysRole> pageFind(@Param("name") String name, @Param("code") String code, @Param("status") Integer status, @Param("page")Pageable page);

}