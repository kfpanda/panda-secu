package com.kfpanda.secu.mapper.sys;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.kfpanda.secu.bean.sys.SysResource;

public interface SysResourceMapper {
	
	@Insert(SysResourceSql.SAVE_SQL)
    int save(SysResource sysResource);
	
    @Delete(SysResourceSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(SysResourceSql.FINDBYID_SQL)
	SysResource findOne(Long id);

    List<SysResource> listByParams4Page(Map<String,Object> params);

    List<SysResource> listByParams(Map<String, Object> params);

    void updateById(SysResource sysResource);

}