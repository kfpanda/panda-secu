package com.kfpanda.secu.mapper.sys;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.kfpanda.secu.bean.sys.SysSession;
import com.kfpanda.secu.bean.sys.SysSession;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class SysSessionMapperTest {
	
	@Resource
	private SysSessionMapper sysSessionMapper;

	private SysSession createSession(String sessionId, String session){
		SysSession sysSession = new SysSession();
		sysSession.setCreateTime(new Timestamp(System.currentTimeMillis()));
		sysSession.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		sysSession.setSessionId(sessionId);
		sysSession.setSession(session);
		return sysSession;
	}

	@Test
	public void save(){
		SysSession sysSession = createSession("12345", "session session");
		
		int result = sysSessionMapper.save(sysSession);

		sysSessionMapper.deleteOne(sysSession.getId());
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		SysSession sysSession = createSession("12345", "session session");
		sysSessionMapper.save(sysSession);

		int result = sysSessionMapper.deleteOne(sysSession.getId());
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		SysSession sysSession = createSession("12345", "session session");
		sysSessionMapper.save(sysSession);

		SysSession sysReousrce = sysSessionMapper.findOne(sysSession.getId());

		sysSessionMapper.deleteOne(sysSession.getId());
		Assert.assertTrue(sysReousrce != null);
	}
}
