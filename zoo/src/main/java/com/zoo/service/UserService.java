package com.zoo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.awifi.util.StringUtils;
import com.zoo.bean.Collect;
import com.zoo.bean.SysUser;
import com.zoo.dao.CollectMapper;
import com.zoo.dao.SysUserMapper;
import com.zoo.dao.VideoNewMapper;

@Service
public class UserService {

	/** * 引入 SysUserMapper */
	@Resource
	private SysUserMapper sysUserMapper;
	/** * 引入 CollectMapper */
	@Resource
	private CollectMapper collectMapper;
	/** * 引入 VideoNewMapper */
	@Resource
	private VideoNewMapper videoNewMapper;
	
	/**
	 * 视频收藏
	 * @param vid 视频id
	 * @param pmac MAC
	 * @param vtype 视频主题
	 * @return String
	 * @author xhb 
	 */
	public String userVidioCollect(Long vid, String pmac, String vtype) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pmac", pmac);
		//查询用户是否存在
		SysUser count = sysUserMapper.selectCountByPmac(map);
		if(count==null){
			SysUser sysUser = new SysUser();
			//新建用户数据
			sysUser.setPmac(pmac);
			sysUser.setUsername("n" + System.currentTimeMillis());
			sysUser.setPassword("n" + System.currentTimeMillis());
			sysUser.setUpdatetime( new Date());
			sysUser.setCreatetime(new Date());
			if(sysUserMapper.insertSelective(sysUser) != 1){
				return "create.user.fall";
			}
			count = sysUserMapper.selectCountByPmac(map);
		}
		//查询视频是否存在
		if(null == videoNewMapper.selectByPrimaryKey(vid)){
			return "null.collect.video";
		}
		Collect collect = new Collect();
		collect.setUid(count.getId());
		collect.setVid(vid);
		//是否已收藏
		if(collectMapper.selectByCollect(collect) != null){
			return "can.not.collect.again";
		}
		if(StringUtils.isNotEmpty(vtype)){
			collect.setVtype(vtype);
		}
		//加入收藏
		if(1 != collectMapper.insertSelective(collect)){
			return "create.collect.fall";
		}
		return "success";
	}
}
