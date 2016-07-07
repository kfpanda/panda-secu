package com.kfpanda.secu.mapper.sys;

import org.apache.ibatis.annotations.*;
import com.kfpanda.secu.bean.sys.SysSession;

public interface SysSessionMapper {
	
	@Insert(SysSessionSql.SAVE_SQL)
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(SysSession sysSession);
	
    @Delete(SysSessionSql.DELBYID_SQL)
    int deleteOne(Long id);
    
    @Delete(SysSessionSql.DELBYSESSIONID_SQL)
    int deleteBySessionId(String sessionId);
    
    @Select(SysSessionSql.FINDBYID_SQL)
	SysSession findOne(Long id);
    
    @Select(SysSessionSql.FINDBYSESSIONID_SQL)
    SysSession findOneBySessionId(String sessionId);
    
    @Update(SysSessionSql.UPDATEBYSESSIONID_SQL)
    int update(String sessionId, String session);
}