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

import com.kfpanda.secu.mapper.sys.SysRoleResourceMapper;
import com.kfpanda.secu.mapper.sys.SysUserResourceMapper;
import com.kfpanda.secu.service.BaseService;
import com.kfpanda.core.page.Pageable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.kfpanda.secu.bean.sys.SysResource;
import com.kfpanda.secu.mapper.sys.SysResourceMapper;

@Service("sysResourceService")
public class SysResourceService extends BaseService {
    private static final Logger logger = LogManager.getLogger(SysResourceService.class);

    @Resource
    private SysResourceMapper sysResourceMapper;
    @Resource
    private SysRoleResourceMapper roleResourceMapper;
    @Resource
    private SysUserResourceMapper userResourceMapper;

    public SysResource findOne(Long id){
        return sysResourceMapper.findOne(id);
    }

    public int save(SysResource sysResource) {
        return sysResourceMapper.save(sysResource);
    }

    public int update(SysResource sysResource) {
        return sysResourceMapper.update(sysResource);
    }

    public void delete(Long  id){
        List<Long> ridList = new ArrayList<>();
        ridList.add(id);
        //删除用户资源关系
        userResourceMapper.mutiDeleteRid(ridList);
        //删除角色资源关系
        roleResourceMapper.mutiDeleteRid(ridList);
        //删除资源
        sysResourceMapper.deleteOne(id);
    }

    /**
     * 分页查询资源。
     * @param pid
     * @param name
     * @param code
     * @param type
     * @param url
     * @param status
     * @param page
     * @return
     */
    public List<SysResource> pageFind(Long pid, String name, String code, String type, String url,
                                               Integer status, Pageable page) {
        return sysResourceMapper.pageFind(pid, name, code, type, url, status, page);
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
        //删除用户跟资源关系
        userResourceMapper.mutiDeleteRid(ids);
        //删除角色跟资源关系
        roleResourceMapper.mutiDeleteRid(ids);
        //删除资源
        sysResourceMapper.multiDelete(ids);
    }
}
