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

	private SysRole createSysRole(String name, String code){
		SysRole sysRole = new SysRole();
		sysRole.setCreateTime(new Timestamp(System.currentTimeMillis()));
		sysRole.setName(name);
		sysRole.setCode(code);
		sysRole.setStatus(1);
		sysRole.setSort(0);
		sysRole.setRemark("remark");
		return sysRole;
	}
	@Test
	public void save(){
		SysRole sysRole = createSysRole("资源添加", "ROLE_admin");
		
		int result = sysRoleMapper.save(sysRole);
		
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		SysRole sysRole = createSysRole("资源添加1111", "test1");
		sysRoleMapper.save(sysRole);
		sysRole = sysRoleMapper.findRole("test1");

		sysRoleMapper.deleteOne(sysRole.getId());
	}

	@Test
	public void findRole(){
		SysRole sysRole = sysRoleMapper.findRole("ROLE_admin");
		Assert.assertTrue(sysRole != null);
	}
	
	@Test
	public void findOne(){
		SysRole sysRole = sysRoleMapper.findRole("ROLE_admin");

		sysRole = sysRoleMapper.findOne(sysRole.getId());
		Assert.assertTrue(sysRole != null);
	}
	
	@Test
	public void findRolesByUserName(){
		
		List<SysRole> sysRoleList = sysRoleMapper.findRoles("superadmin");
		Assert.assertTrue(sysRoleList != null && sysRoleList.size() > 0);
	}
}
