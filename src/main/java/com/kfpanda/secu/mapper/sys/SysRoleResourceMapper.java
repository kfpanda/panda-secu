package com.kfpanda.secu.mapper.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import com.kfpanda.secu.bean.sys.SysRoleResource;


public interface SysRoleResourceMapper {
    
    @Insert(SysRoleResourceSql.SAVE_SQL)
    int save(SysRoleResource sysRoleResource);
    
    @Delete(SysRoleResourceSql.DELBYID_SQL)
    int deleteById(Long id);

    List<SysRoleResource> listByParams4Page(Map<String, Object> params);

    SysRoleResource findOne(Long id);

    List<SysRoleResource> listByParams(Map<String, Object> params);

}