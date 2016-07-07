package com.kfpanda.secu.mapper.sys;

import com.kfpanda.core.page.Pageable;
import org.apache.ibatis.annotations.*;

import com.kfpanda.secu.bean.sys.SysResource;
import org.apache.ibatis.mapping.StatementType;

import javax.annotation.Generated;
import java.util.List;

public interface SysResourceMapper {
	
	@Insert(SysResourceSql.SAVE_SQL)
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(SysResource sysResource);
    @Delete(SysResourceSql.DELBYID_SQL)
    int deleteOne(Long id);
    
    @Select(SysResourceSql.FINDBYID_SQL)
	SysResource findOne(Long id);

    @UpdateProvider(type = SysResourceSql.class, method = "getUpdateSql")
    int update(SysResource sysResource);

    @SelectProvider(type = SysResourceSql.class, method = "getMutiDeleteSql")
    void multiDelete(List<Long> ids);

    @SelectProvider(type = SysResourceSql.class, method = "getPagefindSql")
    List<SysResource> pageFind(@Param("pid") Long pid, @Param("name") String name, @Param("code") String code, @Param("type") String type,
                               @Param("url") String url, @Param("status") Integer status, @Param("page")Pageable page);

}