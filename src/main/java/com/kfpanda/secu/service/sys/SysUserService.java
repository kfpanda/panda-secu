package com.kfpanda.secu.service.sys;

import java.util.List;

import com.kfpanda.core.page.Pageable;
import com.kfpanda.secu.bean.sys.SysUser;
import com.kfpanda.secu.mapper.sys.SysUserMapper;
import com.kfpanda.secu.mapper.sys.SysUserResourceMapper;
import com.kfpanda.secu.mapper.sys.SysUserRoleMapper;
import com.kfpanda.secu.service.BaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserService extends BaseService {
	private static final Logger logger = LogManager.getLogger(SysUserService.class);
	
	@Resource
	private SysUserMapper sysUserMapper;
	@Resource
	private SysUserResourceMapper roleResourceMapper;
	@Resource
	private SysUserRoleMapper userRoleMapper;

	public SysUser findOne(Long id){
		return sysUserMapper.findOne(id);
	}

	public int save(SysUser sysUser) {
		return sysUserMapper.save(sysUser);
	}

	public int update(SysUser sysUser){
		return sysUserMapper.update(sysUser);
	}

	/**
	 * 分页查询用户信息。
	 * @param name
	 * @param userName
	 * @param telNo
	 * @param status
	 * @param type
     * @param page
     * @return
     */
	public List<SysUser> pageFind(String userName, String name, String telNo, Integer status, Integer type, Pageable page) {
		return sysUserMapper.pageFind(userName, name, telNo, status, type, page);
	}

}