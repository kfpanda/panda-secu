/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */

package com.kfpanda.secu.service.sys;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import com.kfpanda.core.page.Pageable;
import com.kfpanda.secu.bean.sys.SysRole;
import com.kfpanda.secu.mapper.sys.SysRoleResourceMapper;
import com.kfpanda.secu.mapper.sys.SysUserRoleMapper;
import com.kfpanda.secu.service.BaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.kfpanda.secu.mapper.sys.SysRoleMapper;

@Service("sysRoleService")
public class SysRoleService extends BaseService {
    private static final Logger logger = LogManager.getLogger(SysRoleService.class);
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysRoleResourceMapper roleResourceMapper;
    @Resource
    private SysUserRoleMapper userRoleMapper;

    public SysRole findOne(Long id){
        return sysRoleMapper.findOne(id);
    }

    public int save(SysRole SysRole) {
        return sysRoleMapper.save(SysRole);
    }

    public int update(SysRole sysRole){
        return sysRoleMapper.update(sysRole);
    }

    public void delete(Long  id){
        List<Long> ridList = new ArrayList<>();
        ridList.add(id);
        //删除用户角色关系
        userRoleMapper.mutiDeleteRid(ridList);
        //删除角色资源关系
        roleResourceMapper.mutiDeleteRoleId(ridList);
        //删除资源
        sysRoleMapper.deleteOne(id);
    }

    /**
     * 分页查询角色信息。
     * @param name
     * @param code
     * @param status
     * @param page
     * @return
     */
    public List<SysRole> pageFind(String name, String code, Integer status, Pageable page) {
        return sysRoleMapper.pageFind(name, code, status, page);
    }

    /**
     * 删除多条记录。
     * @param ids
     * @return
     */
    public void multilDelete(List<Long> ids) {
        if(ids == null || ids.size() < 1){
            return ;
        }
        //删除用户角色关系
        userRoleMapper.mutiDeleteRid(ids);
        //删除角色资源关系
        roleResourceMapper.mutiDeleteRoleId(ids);
        //删除资源
        sysRoleMapper.multiDelete(ids);
    }
}
