package com.kfpanda.secu.mapper.sys;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.kfpanda.secu.bean.sys.SysUserResource;

public interface SysUserResourceMapper {
	@Insert(SysUserResourceSql.SAVE_SQL)
    int save(SysUserResource sysUserResource);
	
    @Delete(SysUserResourceSql.DELBYID_SQL)
    int deleteById(Long id);
}
