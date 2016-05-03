/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */
package com.kfpanda.secu.service;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.kfpanda.secu.action.ResultDTO;
import com.kfpanda.secu.bean.sys.SysUserRole;
import com.kfpanda.secu.mapper.sys.SysUserRoleMapper;
import com.util.common.ResultUtil;
import com.util.common.ValidateUtil;

@Service("sysUserRoleService")
public class SysUserRoleService extends BaseService {
	private static final Logger logger = LoggerFactory.getLogger(SysUserRoleService.class);
	@Resource
	private SysUserRoleMapper sysUserRoleMapper;
	/**
	 * 新增用户角色关系
	 * @param sysUserRole
	 * @return ResultDTO
	 * @author xhb 
	 */
	public ResultDTO save(SysUserRole sysUserRole) {
		// 进行字段验证
		ValidateUtil<SysUserRole> vu = new ValidateUtil<SysUserRole>();
		ResultDTO result = vu.valid(sysUserRole);
		if (result.getR() != 1) {
			return result;
		}
		if(sysUserRoleMapper.save(sysUserRole)!=1){
			return ResultUtil.getFailResult();
		}else{
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
		if (sysUserRoleMapper.deleteById(id) != 1) {
			return ResultUtil.getFailResult();
		} else {
			return ResultUtil.getSuccResult();
		}
	}
	public List<SysUserRole> listByParams(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object multilDelete(Long[] idAry) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<SysUserRole> listByParams4Page(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	public SysUserRole selectByPrimaryKey(Long valueOf) {
		// TODO Auto-generated method stub
		return null;
	}   

}
