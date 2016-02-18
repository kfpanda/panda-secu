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
	
	@Test
	public void save(){
		SysSession sysSession = new SysSession();
		sysSession.setCreateTime(new Timestamp(System.currentTimeMillis()));
		sysSession.setSessionId("123");
		sysSession.setSession("资源添加");
		
		int result = sysSessionMapper.save(sysSession);
		
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		
		int result = sysSessionMapper.deleteById(new Long(21));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		
		SysSession sysReousrce = sysSessionMapper.findOne(new Long(1));
		Assert.assertTrue(sysReousrce != null);
	}
}
