package com.kfpanda.secu.mapper.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import com.kfpanda.secu.bean.sys.SysRoleResource;


public interface SysRoleResourceMapper {
    
    @Insert(SysRoleResourceSql.SAVE_SQL)
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(SysRoleResource sysRoleResource);
    
    @Delete(SysRoleResourceSql.DELBYID_SQL)
    int deleteOne(Long id);

    @Select(SysRoleResourceSql.FINDBYID_SQL)
    SysRoleResource findOne(Long id);

    @SelectProvider(type = SysRoleResourceSql.class, method = "getMutiDeleteRidSql")
    void mutiDeleteRid(List<Long> ridList);

    @SelectProvider(type = SysRoleResourceSql.class, method = "getMutiDeleteRoleIdSql")
    void mutiDeleteRoleId(List<Long> roleIdList);
}