package com.kfpanda.secu.mapper.sys;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kfpanda.secu.bean.sys.SysUser;

public interface SysUserMapper {
	
	@Insert(SysUserSql.SAVE_SQL)
    int save(SysUser sysUser);
	
    @Delete(SysUserSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(SysUserSql.FINDBYID_SQL)
    SysUser findOne(Long id);
    
    @Update(SysUserSql.UPDATE_SQL)
    int update(SysUser sysUser);
    
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
}