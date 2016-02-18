package com.kfpanda.secu.mapper.sys;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.kfpanda.secu.bean.sys.SysSession;

public interface SysSessionMapper {
	
	@Insert(SysSessionSql.SAVE_SQL)
    int save(SysSession sysSession);
	
    @Delete(SysSessionSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Delete(SysSessionSql.DELBYSESSIONID_SQL)
    int deleteBySessionId(String sessionId);
    
    @Select(SysSessionSql.FINDBYID_SQL)
	SysSession findOne(Long id);
    
    @Select(SysSessionSql.FINDBYSESSIONID_SQL)
    SysSession findOneBySessionId(String sessionId);
    
    @Update(SysSessionSql.UPDATEBYSESSIONID_SQL)
    int update(String sessionId, String session);
}