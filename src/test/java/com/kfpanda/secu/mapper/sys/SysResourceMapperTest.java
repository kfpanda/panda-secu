package com.kfpanda.secu.mapper.sys;

import java.sql.Timestamp;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.kfpanda.secu.bean.sys.SysResource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class SysResourceMapperTest {
	
	@Resource
	private SysResourceMapper sysResourceMapper;
	
	@Test
	public void save(){
		SysResource sysResource = new SysResource();
		sysResource.setCreateTime(new Timestamp(System.currentTimeMillis()));
		sysResource.setPId(new Long(0));
		sysResource.setName("资源添加");
		sysResource.setCode("resource add");
		sysResource.setType("url");
		sysResource.setUrl("/resource/add");
		sysResource.setStatus(1);
		sysResource.setOrder(0);
		sysResource.setRemark("remark");
		
		int result = sysResourceMapper.save(sysResource);
		
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		
		int result = sysResourceMapper.deleteById(new Long(21));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		
		SysResource sysReousrce = sysResourceMapper.findOne(new Long(1));
		Assert.assertTrue(sysReousrce != null);
	}
}
