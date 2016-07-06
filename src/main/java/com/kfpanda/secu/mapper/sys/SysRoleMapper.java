package com.kfpanda.secu.mapper.sys;

import java.util.List;
import java.util.Map;
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

    @Select(SysRoleSql.FINDROLEBYCODE_SQL)
    SysRole findRole(String roleCode);
    
    @Select(SysRoleSql.FINDROLES_SQL)
    List<SysRole> findRoles(String userName);

    List<SysRole> listByParams4Page(Map<String, Object> params);

    List<SysRole> listByParams(Map<String, Object> params);

    void updateById(SysRole sysRole);
}