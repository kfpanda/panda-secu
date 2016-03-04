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
import com.kfpanda.secu.bean.sys.SysResource;
import com.kfpanda.secu.mapper.sys.SysResourceMapper;
import com.util.common.ResultUtil;
import com.util.common.ValidateUtil;


@Service("sysResourceService")
public class SysResourceService extends BaseService {
    private static final Logger logger = LoggerFactory
            .getLogger(SysResourceService.class);
    @Resource
    private SysResourceMapper sysResourceMapper;
    /**
     * 说明:list by page and params
     * @param page
     * @return
     * @return List<Role>
     * @author dozen.zhang
     * @date 2015年11月15日下午12:36:24
     */
    public List<SysResource> listByParams4Page(HashMap params) {
        return sysResourceMapper.listByParams4Page(params);
    }
     public List<SysResource> listByParams(HashMap params) {
        return sysResourceMapper.listByParams(params);
    }

    /*
     * 说明:
     * @param SysResource
     * @return
     * @return Object
     * @author dozen.zhang
     * @date 2015年11月15日下午1:33:54
     */
    public ResultDTO save(SysResource sysResource) {
        // 进行字段验证
       ValidateUtil<SysResource> vu = new ValidateUtil<SysResource>();
        ResultDTO result = 
        		vu.valid(sysResource);
        if (result.getR() != 1) {
            return result;
        }
         //逻辑业务判断判断
       
       //判断是更新还是插入
        if (sysResource.getId()==null) {
            sysResourceMapper.save(sysResource);
        } else {
             sysResourceMapper.updateByPrimaryKey(sysResource);
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
        sysResourceMapper.deleteById(id);
    }   
    /**
    * 说明:根据主键获取数据
    * description:delete by key
    * @param id
    * @return void
    * @author dozen.zhang
    * @date 2015年12月27日下午10:56:38
    */
    public SysResource selectByPrimaryKey(Long id){
       return sysResourceMapper.findOne(id);
    }
    /**多id删除
     * @param idAry
     * @return
     * @author dozen.zhang
     */
    public ResultDTO multilDelete(Long[] idAry) {
        for(int i=0;i<idAry.length;i++){
            sysResourceMapper.deleteById(idAry[i]);
        }
        return ResultUtil.getSuccResult();
    }
}
