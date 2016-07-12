package com.kfpanda.secu.mapper.sys;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.kfpanda.core.page.Pageable;
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
		SysResource sysResource = createSysResource("测试资源添加", "test_resource_add", "/test/resource/add");
		
		int result = sysResourceMapper.save(sysResource);

		sysResourceMapper.deleteOne(sysResource.getId());
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteOne(){
		SysResource sysResource = createSysResource("测试资源添加", "test_resource_add", "/test/resource/add");
		sysResourceMapper.save(sysResource);

		sysResourceMapper.deleteOne(sysResource.getId());
	}
	
	@Test
	public void findOne(){
		SysResource sysResource = createSysResource("测试资源添加", "test_resource_add", "/test/resource/add");
		sysResourceMapper.save(sysResource);

		sysResource = sysResourceMapper.findOne(sysResource.getId());

		sysResourceMapper.deleteOne(sysResource.getId());
		Assert.assertTrue(sysResource != null);
	}

	@Test
	public void update(){
		SysResource sysResource = createSysResource("测试资源添加", "test_resource_add", "/test/resource/add");
		sysResourceMapper.save(sysResource);

		sysResource.setRemark("modify modify modify");
		sysResource.setCode("test1111111");
		sysResourceMapper.update(sysResource);

		sysResource = sysResourceMapper.findOne(sysResource.getId());

		sysResourceMapper.deleteOne(sysResource.getId());
		Assert.assertTrue(sysResource.getCode().equals("test1111111"));
	}

	@Test
	public void multiDelete(){
		List<Long> ids = new ArrayList<>();

		SysResource sysResource = createSysResource("测试资源添加1", "test_resource_add1", "/test/resource/add");
		sysResourceMapper.save(sysResource);
		ids.add(sysResource.getId());
		sysResource = createSysResource("测试资源添加2", "test_resource_add2", "/test/resource/add");
		sysResourceMapper.save(sysResource);
		ids.add(sysResource.getId());
		sysResource = createSysResource("测试资源添加3", "test_resource_add3", "/test/resource/add");
		sysResourceMapper.save(sysResource);
		ids.add(sysResource.getId());

		sysResourceMapper.multiDelete(ids);
	}

	@Test
	public void pageFind(){
		SysResource sysResource = createSysResource("测试资源添加", "test_resource_add", "/test/resource/add");
		sysResourceMapper.save(sysResource);

		Pageable page = new Pageable(0, 1, null);
		List<SysResource> sysResourceList = sysResourceMapper.pageFind(null, sysResource.getName(), sysResource.getCode(), null, null, null, page);

		sysResourceMapper.deleteOne(sysResource.getId());
		Assert.assertTrue(sysResourceList.size() > 0);
	}
}
