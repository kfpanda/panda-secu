package com.kfpanda.secu.mapper.sys;

import java.util.List;

import com.kfpanda.core.page.Pageable;
import org.apache.ibatis.annotations.*;

import com.kfpanda.secu.bean.sys.SysUser;

public interface SysUserMapper {
	
	@Insert(SysUserSql.SAVE_SQL)
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(SysUser sysUser);
	
    @Delete(SysUserSql.DELBYID_SQL)
    int deleteOne(Long id);
    
    @Select(SysUserSql.FINDBYID_SQL)
    SysUser findOne(Long id);
    
    @Update(SysUserSql.UPDATE_SQL)
    int updateAll(SysUser sysUser);
    
    @Select(SysUserSql.FINDBYUSERNAME_SQL)
    SysUser findByUserName(String userName);
    
    /**
     * 根据用户名，获取用户信息及用户角色信息及角色对应的资源信息。
     * @param userName
     * @return
     * @author kfpanda
     */
    @ResultMap(value="sysUserResult")
    @Select(SysUserSql.FINDURR_SQL)
    List<SysUser> findURR(String userName);

    @UpdateProvider(type = SysUserSql.class, method = "getUpdateSql")
    int update(SysUser sysUser);

    @SelectProvider(type = SysUserSql.class, method = "getPagefindSql")
    List<SysUser> pageFind(@Param("userName") String userName, @Param("name") String name, @Param("telNo") String telNo,
                           @Param("status") Integer status, @Param("type") Integer type, @Param("page")Pageable page);
}