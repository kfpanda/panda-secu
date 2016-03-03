package com.kfpanda.secu.mapper.sys;

import com.kfpanda.secu.bean.sys.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class SysUserMapperTest {
	
	@Resource
	private SysUserMapper sysUserMapper;
	
	@Test
	public void save(){
		SysUser sysUser = new SysUser();
		sysUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
		sysUser.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		sysUser.setUserName("kfpanda");
		sysUser.setPassword("123456");
		sysUser.setNkName("kfpanda");
		sysUser.setStatus(1);
		sysUser.setType(1);
		sysUser.setName("lhl");
		sysUser.setEmail("liuhualuo@163.com");
		sysUser.setTelNo("18989893671");
//		sysUser.setIdCard("");
		sysUser.setSex(true);
		sysUser.setBirth(new Date());
		sysUser.setIntegral(0);
		sysUser.setAddress("");
		sysUser.setWeiChat(null);
		sysUser.setQq(new Long(123456));
		sysUser.setFace(null);
		sysUser.setRemark("remark");
		sysUser.setOpenId(null);
		
		int result = sysUserMapper.save(sysUser);
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		int result = sysUserMapper.deleteById(new Long(33384));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		SysUser sysUser = sysUserMapper.findOne(new Long(1));
		Assert.assertTrue(sysUser != null);
	}
	
	@Test
	public void findByUserName(){
		SysUser sysUser = sysUserMapper.findByUserName("superadmin");
		Assert.assertTrue(sysUser != null);
	}
	
	@Test
	public void findURR(){
		List<SysUser> sysUserList = sysUserMapper.findURR("superadmin");
		Assert.assertTrue(sysUserList.size() > 0);
	}
}
