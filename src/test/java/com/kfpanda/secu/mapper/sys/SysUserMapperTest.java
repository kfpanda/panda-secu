package com.kfpanda.secu.mapper.sys;

import com.kfpanda.secu.bean.sys.SysUser;
import com.kfpanda.secu.shiro.MD5;
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

	private SysUser createSysUser(String userName, String password){
		SysUser sysUser = new SysUser();
		sysUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
		sysUser.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		sysUser.setUserName(userName);
		sysUser.setPassword(MD5.MD5Salt(sysUser.getUserName(), password));
		sysUser.setNkName(userName);
		sysUser.setStatus(1);
		sysUser.setType(1);
		sysUser.setName("lhl");
		sysUser.setEmail("liuhualuo@163.com");
		sysUser.setTelNo("18989893671");
//		sysUser.setIdCard("");
		sysUser.setSex(0);
		sysUser.setBirth("20160102");
		sysUser.setIntegral(0);
		sysUser.setAddress("");
		sysUser.setWeiChat(null);
		sysUser.setQq(new Long(123456));
		sysUser.setFace(null);
		sysUser.setRemark("remark");
		sysUser.setOpenId(null);

		return sysUser;
	}

	@Test
	public void save(){
		SysUser sysUser = createSysUser("kfpanda", "123456");
		int result = sysUserMapper.save(sysUser);

		sysUserMapper.deleteOne(sysUser.getId());
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteOne(){
		SysUser sysUser = createSysUser("test1", "123456");
		sysUserMapper.save(sysUser);

		int result = sysUserMapper.deleteOne(sysUser.getId());
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		SysUser sysUser = createSysUser("test1", "123456");
		sysUserMapper.save(sysUser);

		sysUser = sysUserMapper.findOne(sysUser.getId());

		sysUserMapper.deleteOne(sysUser.getId());
		Assert.assertTrue(sysUser != null);
	}
	
	@Test
	public void findByUserName(){
		SysUser sysUser = createSysUser("test2222", "123456");
		sysUserMapper.save(sysUser);

		sysUser = sysUserMapper.findByUserName("test2222");

		sysUserMapper.deleteOne(sysUser.getId());
		Assert.assertTrue(sysUser != null);
	}
	
	@Test
	public void findURR(){
		List<SysUser> sysUserList = sysUserMapper.findURR("superadmin");
		Assert.assertTrue(sysUserList.size() > 0);

		SysUser sysUser = sysUserList.get(0);
		Assert.assertTrue(sysUser.getRoles().size() > 0);
		Assert.assertTrue(sysUser.getResources().size() > 0);
	}
}
