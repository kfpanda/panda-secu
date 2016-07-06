/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */

package com.kfpanda.secu.service.sys;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.kfpanda.secu.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.kfpanda.secu.action.ResultDTO;
import com.kfpanda.secu.bean.sys.SysRole;
import com.kfpanda.secu.mapper.sys.SysRoleMapper;
import com.util.common.ResultUtil;
import com.util.common.ValidateUtil;

@Service("sysRoleService")
public class SysRoleService extends BaseService {
    private static final Logger logger = LoggerFactory
            .getLogger(SysRoleService.class);
    @Resource
    private SysRoleMapper sysRoleMapper;
    /**
     * 说明:list by page and params
     * @param page
     * @return
     * @return List<Role>
     * @author dozen.zhang
     * @date 2015年11月15日下午12:36:24
     */
    public List<SysRole> listByParams4Page(Map<String,Object> params) {
        return sysRoleMapper.listByParams4Page(params);
    }
     public List<SysRole> listByParams(Map<String,Object> params) {
        return sysRoleMapper.listByParams(params);
    }

    /*
     * 说明:
     * @param SysRole
     * @return
     * @return Object
     * @author dozen.zhang
     * @date 2015年11月15日下午1:33:54
     */
    public ResultDTO save(SysRole sysRole) {
        // 进行字段验证
       ValidateUtil<SysRole> vu = new ValidateUtil<SysRole>();
        ResultDTO result = vu.valid(sysRole);
        if (result.getR() != 1) {
            return result;
        }
         //逻辑业务判断判断
       
       //判断是更新还是插入
        if (sysRole.getId()==null) {
               
            sysRoleMapper.save(sysRole);
        } else {
             sysRoleMapper.updateById(sysRole);
        }
        return ResultUtil.getSuccResult();
    }
    /**
    * 说明:根据主键删除数据
    * description:delete by key
    * @param id
    * @return void
    * @author dozen.zhang
    * @date 2015年12月27日下午10:56:38
    */
    public void delete(Long  id){
        sysRoleMapper.deleteById(id);
    }   
    /**
    * 说明:根据主键获取数据
    * description:delete by key
    * @param id
    * @return void
    * @author dozen.zhang
    * @date 2015年12月27日下午10:56:38
    */
    public SysRole selectByPrimaryKey(Long id){
       return sysRoleMapper.findOne(id);
    }
    /**多id删除
     * @param idAry
     * @return
     * @author dozen.zhang
     */
    public ResultDTO multilDelete(Long[] idAry) {
        for(int i=0;i<idAry.length;i++){
            sysRoleMapper.deleteById(idAry[i]);
        }
        return ResultUtil.getSuccResult();
    }
}
