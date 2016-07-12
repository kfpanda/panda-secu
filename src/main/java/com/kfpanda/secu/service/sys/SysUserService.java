package com.kfpanda.secu.service.sys;

import java.util.List;

import com.kfpanda.core.page.Pageable;
import com.kfpanda.secu.bean.sys.SysUser;
import com.kfpanda.secu.bean.sys.SysUserResource;
import com.kfpanda.secu.bean.sys.SysUserRole;
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
	private SysUserResourceMapper userResourceMapper;
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

	public int userRoleAdds(String uids, String roleIds){
		String[] uidArr = uids.split(",");
		String[] ridArr = roleIds.split(",");
		int result = 0;
		for(int i = 0; i < uidArr.length; i++){
			for(int j = 0; j < ridArr.length; j++){
				try {
					SysUserRole userRole = new SysUserRole();
					userRole.setUid(Long.parseLong(uidArr[i]));
					userRole.setRid(Long.parseLong(ridArr[j]));
					userRoleMapper.save(userRole);
				}catch (Exception ex){
					logger.error("sys_user_role add error.", ex);
				}
				result++;
			}
		}
		return result;
	}

	public int userResourceAdds(String uids, String rids){
		String[] uidArr = uids.split(",");
		String[] ridArr = rids.split(",");
		int result = 0;
		for(int i = 0; i < uidArr.length; i++){
			for(int j = 0; j < ridArr.length; j++){
				try {
					SysUserResource userResource = new SysUserResource();
					userResource.setUid(Long.parseLong(uidArr[i]));
					userResource.setRid(Long.parseLong(ridArr[j]));
					userResourceMapper.save(userResource);
				}catch (Exception ex){
					logger.error("sys_user_resource add error.", ex);
				}
				result++;
			}
		}
		return result;
	}

}