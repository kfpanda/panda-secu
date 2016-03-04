/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */
package com.kfpanda.secu.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kfpanda.secu.action.ResultDTO;
import com.kfpanda.secu.bean.sys.SysUserResource;
import com.kfpanda.secu.mapper.sys.SysUserResourceMapper;
import com.util.common.ResultUtil;
import com.util.common.ValidateUtil;

@Service("sysUserResourceService")
public class SysUserResourceService extends BaseService {
	private static final Logger logger = LoggerFactory .getLogger(SysUserResourceService.class);
	@Resource
	private SysUserResourceMapper sysUserResourceMapper;

	/**
	 * 新增角色资源关系
	 * @param sysUserResource
	 * @return ResultDTO
	 * @author xhb 
	 */
	public ResultDTO save(SysUserResource sysUserResource) {
		// 进行字段验证
		ValidateUtil<SysUserResource> vu = new ValidateUtil<SysUserResource>();
		ResultDTO result = vu.valid(sysUserResource);
		if (result.getR() != 1) {
			return result;
		}
		if (sysUserResourceMapper.save(sysUserResource) != 1) {
			return ResultUtil.getFailResult();
		} else {
			return ResultUtil.getSuccResult();
		}
	}
	/**
	 * 说明:根据主键删除数据
	 * description:delete by key
	 * @param id
	 * @return void
	 * @author dozen.zhang
	 * @return 
	 * @date 2015年12月27日下午10:56:38
	 */
	public ResultDTO delete(Long id) {
		if (sysUserResourceMapper.deleteById(id) != 1) {
			return ResultUtil.getFailResult();
		} else {
			return ResultUtil.getSuccResult();
		}

	}   
}
