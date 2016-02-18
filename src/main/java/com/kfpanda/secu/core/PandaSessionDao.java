package com.kfpanda.secu.core;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.stereotype.Repository;
import com.kfpanda.secu.bean.sys.SysSession;
import com.kfpanda.secu.mapper.sys.SysSessionMapper;
import com.util.common.SerializableUtils;

@Repository
public class PandaSessionDao extends CachingSessionDAO {
	@Resource
	private SysSessionMapper sysSessionMapper;
	
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		SysSession sysSession = new SysSession();
		sysSession.setCreateTime(new Timestamp(System.currentTimeMillis()));
		sysSession.setSessionId((String)sessionId);
		sysSession.setSession(SerializableUtils.serialize(session));
		sysSessionMapper.save(sysSession);
		return session.getId();
	}

	protected void doUpdate(Session session) {
		if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
			return; // 如果会话过期/停止 没必要再更新了
		}
		sysSessionMapper.update(session.getId().toString(), SerializableUtils.serialize(session));
	}
	
	protected void doDelete(Session session) {
		sysSessionMapper.deleteBySessionId(session.getId().toString());
	}
	
	protected Session doReadSession(Serializable sessionId) {
		SysSession sysSession = sysSessionMapper.findOneBySessionId(sessionId.toString());
		if (sysSession == null){
			return null;
		}
		return SerializableUtils.deserialize(sysSession.getSession());
	}
}