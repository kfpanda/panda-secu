package com.kfpanda.secu.mapper.sys;

import com.kfpanda.secu.bean.sys.SysRole;
import com.kfpanda.secu.bean.sys.SysUserRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class SysUserRoleMapperTest {
	
	@Resource
	private SysUserRoleMapper sysUserRoleMapper;

	private SysUserRole createSysUserRole(Long uId, Long rId){
		SysUserRole sysRole = new SysUserRole();
		sysRole.setRid(rId);
		sysRole.setUid(uId);
		return sysRole;
	}
	@Test
	public void save(){
		SysUserRole sysUserRole = createSysUserRole(5L, 1L);
		
		int result = sysUserRoleMapper.save(sysUserRole);
		
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		SysUserRole sysUserRole = createSysUserRole(5L, 1L);
		sysUserRoleMapper.save(sysUserRole);

//		int result = sysUserRoleMapper.deleteById(2L);
//		Assert.assertTrue(result == 1);
	}

	@Test
	public void findOne(){
		SysUserRole sysUserRole = sysUserRoleMapper.findOne(1L);
		Assert.assertTrue(sysUserRole != null);
	}
}
