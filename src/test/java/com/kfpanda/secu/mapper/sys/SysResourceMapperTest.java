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

	private SysResource createSysResource(String name, String code, String url){
		SysResource sysResource = new SysResource();
		sysResource.setCreateTime(new Timestamp(System.currentTimeMillis()));
		sysResource.setPid(new Long(0));
		sysResource.setName(name);
		sysResource.setCode(code);
		sysResource.setType("url");
		sysResource.setUrl(url);
		sysResource.setStatus(1);
		sysResource.setSort(0);
		sysResource.setRemark("remark");
		return sysResource;
	}

	@Test
	public void save(){
		SysResource sysResource = createSysResource("资源添加", "resource_add", "/resource/add");
		
		int result = sysResourceMapper.save(sysResource);
		
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		SysResource sysResource = createSysResource("资源添加111", "resource_add1111", "/resource/add1111");
		sysResourceMapper.save(sysResource);

		int result = sysResourceMapper.deleteById(new Long(2));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		
		SysResource sysReousrce = sysResourceMapper.findOne(new Long(1));
		Assert.assertTrue(sysReousrce != null);
	}
}
