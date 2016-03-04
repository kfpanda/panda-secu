/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */

package cola.machine.action;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import cola.machine.service.SysUserResourceService;
import cola.machine.bean.SysUserResource;
import cola.machine.util.ResultUtil;
import cola.machine.util.ValidateUtil;
import cola.machine.util.rules.*;
import core.page.Page;

import cola.machine.util.StringUtil;
import cola.machine.util.ValidateUtil;
import core.util.RequestUtil;
import core.action.ResultDTO;
import cola.machine.util.DateUtil;
@Controller
@RequestMapping("/sysUserResource")
public class SysUserResourceController extends BaseController{
    /** 日志 **/
    private Logger logger = LoggerFactory.getLogger(SysUserResourceController.class);
    /** 权限service **/
    @Autowired
    private SysUserResourceService sysUserResourceService;
    
    /**
     * 说明: 跳转到角色列表页面
     * 
     * @return
     * @return String
     * @author dozen.zhang
     * @date 2015年11月15日下午12:30:45
     */
    @RequestMapping(value = "/list.htm", method = RequestMethod.GET)
    public String list() {
        return "/static/html/SysUserResourceList.html";
    }

 
    /**
     * 说明:ajax请求角色信息
     * 
     * @param curPage
     * @param pageSize
     * @return
     * @return Object
     * @author dozen.zhang
     * @date 2015年11月15日下午12:31:55
     */
    @RequestMapping(value = "/list.json")
    @ResponseBody
    public Object list(HttpServletRequest request) {
        Page page = RequestUtil.getPage(request);
        if(page ==null){
             return this.getWrongResultFromCfg("err.param.page");
        }
        
        HashMap<String,Object> params= new HashMap<String,Object>();
        String id = request.getParameter("id");
        if(!StringUtil.isBlank(id)){
                params.put("id",id);
        }
        String userid = request.getParameter("userid");
        if(!StringUtil.isBlank(userid)){
                params.put("userid",userid);
        }
        String resourceid = request.getParameter("resourceid");
        if(!StringUtil.isBlank(resourceid)){
                params.put("resourceid",resourceid);
        }

        params.put("page",page);
        List<SysUserResource> sysUserResources = sysUserResourceService.listByParams4Page(params);
        return ResultUtil.getResult(sysUserResources, page);
    }
    
    
    
    /**
     * @param id 参数
     * @param request 发请求
     * @return Object
     */
    @RequestMapping(value = "/edit.htm")
    public Object edit( HttpServletRequest request) {
        // 查找所有的角色
        return "/static/html/SysUserResourceEdit.html";
    }
    @RequestMapping(value = "/view.htm")
    public Object viewPage( HttpServletRequest request) {
        return "/static/html/SysUserResourceView.html";
    }
   
      @RequestMapping(value = "/view.json")
    @ResponseBody
    public Object view(HttpServletRequest request) {
    String id = request.getParameter("id");
HashMap<String,Object> result =new HashMap<String,Object>();
if(!StringUtil.isBlank(id)){
    SysUserResource bean = sysUserResourceService.selectByPrimaryKey(Long.valueOf(id));
    result.put("bean", bean);
}
return this.getResult(result);



    
      /*  String id = request.getParameter("id");
        SysUserResource bean = sysUserResourceService.selectByPrimaryKey(Long.valueOf(id));
        HashMap result =new HashMap();
        result.put("bean", bean);
        return this.getResult(bean);*/
    }

    
    /**
     * 说明:保存角色信息
     * 
     * @param request
     * @return
     * @throws Exception
     * @return Object
     * @author dozen.zhang
     * @date 2015年11月15日下午1:33:00
     */
    // @RequiresPermissions(value={"auth:edit" ,"auth:add" },logical=Logical.OR)
    @RequestMapping(value = "/save.json")
    @ResponseBody
    public Object save(HttpServletRequest request) throws Exception {
        SysUserResource sysUserResource =new  SysUserResource();
        /*
        String id = request.getParameter("id");
        if(!StringUtil.isBlank(id)){
            sysUserResource.setId(Long.valueOf(id)) ;
        }
        
        String userid = request.getParameter("userid");
        if(!StringUtil.isBlank(userid)){
            sysUserResource.setUserid(Long.valueOf(userid)) ;
        }
        
        String resourceid = request.getParameter("resourceid");
        if(!StringUtil.isBlank(resourceid)){
            sysUserResource.setResourceid(Long.valueOf(resourceid)) ;
        }
        */
        String id = request.getParameter("id");
        if(!StringUtil.isBlank(id)){
                sysUserResource.setId(Long.valueOf(id));
        }
        String userid = request.getParameter("userid");
        if(!StringUtil.isBlank(userid)){
                sysUserResource.setUserid(Long.valueOf(userid));
        }
        String resourceid = request.getParameter("resourceid");
        if(!StringUtil.isBlank(resourceid)){
                sysUserResource.setResourceid(Long.valueOf(resourceid));
        }

        //valid
        ValidateUtil vu = new ValidateUtil();
        String validStr="";
        vu.add("id", id, "主键",  new Rule[]{new Digits(15,0)});
        vu.add("userid", userid, "用户id",  new Rule[]{new Digits(15,0),new NotEmpty()});
        vu.add("resourceid", resourceid, "资源id",  new Rule[]{new Digits(15,0),new NotEmpty()});
        validStr = vu.validateString();
        if(StringUtil.isNotEmpty(validStr)) {
            return ResultUtil.getResult(302,validStr);
        }

        return sysUserResourceService.save(sysUserResource);
       
    }
    
    @RequestMapping(value = "/del.json")
    @ResponseBody
    public Object delete(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        if(StringUtil.isBlank(idStr)){
            return this.getWrongResultFromCfg("err.param.notnull");
        }
        Long id = Long.valueOf(idStr);
        sysUserResourceService.delete(id);
        return this.getResult(SUCC);
    }
     /**
     * 多行删除
     * @param request
     * @return
     * @author dozen.zhang
     */
    @RequestMapping(value = "/mdel.json")
    @ResponseBody
    public Object multiDelete(HttpServletRequest request) {
        String idStr = request.getParameter("ids");
        if(StringUtil.isBlank(idStr)){
            return this.getWrongResultFromCfg("err.param.notnull");
        }
        String idStrAry[]= idStr.split(",");
        Long idAry[]=new Long[idStrAry.length];
        for(int i=0,length=idAry.length;i<length;i++){
            ValidateUtil vu = new ValidateUtil();
            String validStr="";
            String id = idStrAry[i];
                    vu.add("id", id, "主键",  new Rule[]{});

            try{
                validStr=vu.validateString();
            }catch(Exception e){
                e.printStackTrace();
                validStr="验证程序异常";
                return ResultUtil.getResult(302,validStr);
            }
            
            if(StringUtil.isNotEmpty(validStr)) {
                return ResultUtil.getResult(302,validStr);
            }
            idAry[i]=Long.valueOf(idStrAry[i]);
        }
       return  sysUserResourceService.multilDelete(idAry);
    }

    /**
     * 导出
     * @param request
     * @return
     * @author dozen.zhang
     */
    @RequestMapping(value = "/export.json")
    @ResponseBody   
    public Object exportExcel(HttpServletRequest request){
               HashMap<String,Object> params= new HashMap<String,Object>();
        String id = request.getParameter("id");
        if(!StringUtil.isBlank(id)){
                params.put("id",id);
        }
        String userid = request.getParameter("userid");
        if(!StringUtil.isBlank(userid)){
                params.put("userid",userid);
        }
        String resourceid = request.getParameter("resourceid");
        if(!StringUtil.isBlank(resourceid)){
                params.put("resourceid",resourceid);
        }

        // 查询list集合
        List<SysUserResource> list =sysUserResourceService.listByParams(params);
        // 存放临时文件
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "list.xlsx");
        String folder = request.getSession().getServletContext()
                .getRealPath("/")
                + "xlstmp";
        File folder_file = new File(folder);
        if (!folder_file.exists()) {
            folder_file.mkdir();
        }
        String fileName = folder + File.separator
                + DateUtil.formatToString(new Date(), "yyyyMMddHHmmssSSS")
                + ".xlsx";
        // 得到导出Excle时清单的英中文map
        LinkedHashMap<String, String> colTitle = new LinkedHashMap<String, String>();
        colTitle.put("id", "主键");
        colTitle.put("userid", "用户id");
        colTitle.put("resourceid", "资源id");
        List finalList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SysUserResource sm = list.get(i);
            HashMap map = new HashMap();
            map.put("id",  list.get(i).getId());
            map.put("userid",  list.get(i).getUserid());
            map.put("resourceid",  list.get(i).getResourceid());
            finalList.add(map);
        }
        try {
            if (cola.machine.util.ExcelUtil.getExcelFile(finalList, fileName, colTitle) != null) {
                return this.getResult(SUCC, "导出成功", fileName);
            }
            /*
             * return new ResponseEntity<byte[]>(
             * FileUtils.readFileToByteArray(new File(fileName)), headers,
             * HttpStatus.CREATED);
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.getResult(0, "数据为空，导出失败");
    
    }
    @RequestMapping(value = "/import.json")
    public void importExcel(){
        
    }
}
