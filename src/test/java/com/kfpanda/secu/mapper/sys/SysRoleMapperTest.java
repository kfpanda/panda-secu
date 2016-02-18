package com.kfpanda.secu.mapper.sys;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.kfpanda.secu.bean.sys.SysRole;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class SysRoleMapperTest {
	
	@Resource
	private SysRoleMapper sysRoleMapper;
	
	@Test
	public void save(){
		SysRole sysRole = new SysRole();
		sysRole.setCreateTime(new Timestamp(System.currentTimeMillis()));
		sysRole.setName("资源添加");
		sysRole.setCode("ROLE_admin");
		sysRole.setStatus(1);
		sysRole.setOrder(0);
		sysRole.setRemark("remark");
		
		int result = sysRoleMapper.save(sysRole);
		
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		
		int result = sysRoleMapper.deleteById(new Long(34));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		
		SysRole sysRole = sysRoleMapper.findOne(new Long(1));
		Assert.assertTrue(sysRole != null);
	}
	
	@Test
	public void findRolesByUserName(){
		
		List<SysRole> sysRoleList = sysRoleMapper.findRoles("superadmin");
		Assert.assertTrue(sysRoleList != null && sysRoleList.size() > 0);
	}
}
