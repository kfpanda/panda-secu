package com.zoo.dao;

import java.util.Map;

import com.zoo.bean.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);
    int insert(SysUser record);
    int insertSelective(SysUser record);
    SysUser selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(SysUser record);
    int updateByPrimaryKey(SysUser record);
    
    /**
     * 查询是否有用户
     * @param map
     * @return int
     * @author xhb 
     */
    SysUser selectCountByPmac(Map<String, Object> map);
}