package com.kfpanda.secu.mapper.sys;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.kfpanda.secu.bean.sys.SysUserResource;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SysUserResourceMapper {
	@Insert(SysUserResourceSql.SAVE_SQL)
    int save(SysUserResource sysUserResource);
	
    @Delete(SysUserResourceSql.DELBYID_SQL)
    int deleteOne(Long id);

    @Select(SysUserResourceSql.FINDBYID_SQL)
    SysUserResource findOne(Long id);

    @SelectProvider(type = SysUserResourceSql.class, method = "getMutiDeleteRidSql")
    void mutiDeleteRid(List<Long> ridList);

}
