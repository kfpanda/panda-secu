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

import cola.machine.service.SysRoleService;
import cola.machine.bean.SysRole;
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
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController{
    /** 日志 **/
    private Logger logger = LoggerFactory.getLogger(SysRoleController.class);
    /** 权限service **/
    @Autowired
    private SysRoleService sysRoleService;
    
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
        return "/static/html/SysRoleList.html";
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
        String name = request.getParameter("name");
        if(!StringUtil.isBlank(name)){
                params.put("name",name);
        }
        String intro = request.getParameter("intro");
        if(!StringUtil.isBlank(intro)){
                params.put("intro",intro);
        }
        String sort = request.getParameter("sort");
        if(!StringUtil.isBlank(sort)){
                params.put("sort",sort);
        }
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
                params.put("status",status);
        }
        String remark = request.getParameter("remark");
        if(!StringUtil.isBlank(remark)){
                params.put("remark",remark);
        }

        params.put("page",page);
        List<SysRole> sysRoles = sysRoleService.listByParams4Page(params);
        return ResultUtil.getResult(sysRoles, page);
    }
    
    
    
    /**
     * @param id 参数
     * @param request 发请求
     * @return Object
     */
    @RequestMapping(value = "/edit.htm")
    public Object edit( HttpServletRequest request) {
        // 查找所有的角色
        return "/static/html/SysRoleEdit.html";
    }
    @RequestMapping(value = "/view.htm")
    public Object viewPage( HttpServletRequest request) {
        return "/static/html/SysRoleView.html";
    }
   
      @RequestMapping(value = "/view.json")
    @ResponseBody
    public Object view(HttpServletRequest request) {
    String id = request.getParameter("id");
HashMap<String,Object> result =new HashMap<String,Object>();
if(!StringUtil.isBlank(id)){
    SysRole bean = sysRoleService.selectByPrimaryKey(Long.valueOf(id));
    result.put("bean", bean);
}
return this.getResult(result);



    
      /*  String id = request.getParameter("id");
        SysRole bean = sysRoleService.selectByPrimaryKey(Long.valueOf(id));
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
        SysRole sysRole =new  SysRole();
        /*
        String id = request.getParameter("id");
        if(!StringUtil.isBlank(id)){
            sysRole.setId(Long.valueOf(id)) ;
        }
        
        String name = request.getParameter("name");
        if(!StringUtil.isBlank(name)){
            sysRole.setName(String.valueOf(name)) ;
        }
        
        String intro = request.getParameter("intro");
        if(!StringUtil.isBlank(intro)){
            sysRole.setIntro(String.valueOf(intro)) ;
        }
        
        String sort = request.getParameter("sort");
        if(!StringUtil.isBlank(sort)){
            sysRole.setSort(Long.valueOf(sort)) ;
        }
        
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
            sysRole.setStatus(Integer.valueOf(status)) ;
        }
        
        String remark = request.getParameter("remark");
        if(!StringUtil.isBlank(remark)){
            sysRole.setRemark(String.valueOf(remark)) ;
        }
        */
        String id = request.getParameter("id");
        if(!StringUtil.isBlank(id)){
                sysRole.setId(Long.valueOf(id));
        }
        String name = request.getParameter("name");
        if(!StringUtil.isBlank(name)){
                sysRole.setName(String.valueOf(name));
        }
        String intro = request.getParameter("intro");
        if(!StringUtil.isBlank(intro)){
                sysRole.setIntro(String.valueOf(intro));
        }
        String sort = request.getParameter("sort");
        if(!StringUtil.isBlank(sort)){
                sysRole.setSort(Long.valueOf(sort));
        }
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
                sysRole.setStatus(Integer.valueOf(status));
        }
        String remark = request.getParameter("remark");
        if(!StringUtil.isBlank(remark)){
                sysRole.setRemark(String.valueOf(remark));
        }

        //valid
        ValidateUtil vu = new ValidateUtil();
        String validStr="";
        vu.add("id", id, "主键",  new Rule[]{new Digits(15,0)});
        vu.add("name", name, "角色名",  new Rule[]{new Length(40),new NotEmpty()});
        vu.add("intro", intro, "角色说明",  new Rule[]{new Length(40),new NotEmpty()});
        vu.add("sort", sort, "排序",  new Rule[]{new Digits(15,0),new NotEmpty()});
        vu.add("status", status, "状态",  new Rule[]{new Digits(1,0),new CheckBox(new String[]{"1","2"}),new NotEmpty()});
        vu.add("remark", remark, "备注",  new Rule[]{new Length(255)});
        validStr = vu.validateString();
        if(StringUtil.isNotEmpty(validStr)) {
            return ResultUtil.getResult(302,validStr);
        }

        return sysRoleService.save(sysRole);
       
    }
    
    @RequestMapping(value = "/del.json")
    @ResponseBody
    public Object delete(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        if(StringUtil.isBlank(idStr)){
            return this.getWrongResultFromCfg("err.param.notnull");
        }
        Long id = Long.valueOf(idStr);
        sysRoleService.delete(id);
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
       return  sysRoleService.multilDelete(idAry);
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
        String name = request.getParameter("name");
        if(!StringUtil.isBlank(name)){
                params.put("name",name);
        }
        String intro = request.getParameter("intro");
        if(!StringUtil.isBlank(intro)){
                params.put("intro",intro);
        }
        String sort = request.getParameter("sort");
        if(!StringUtil.isBlank(sort)){
                params.put("sort",sort);
        }
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
                params.put("status",status);
        }
        String remark = request.getParameter("remark");
        if(!StringUtil.isBlank(remark)){
                params.put("remark",remark);
        }

        // 查询list集合
        List<SysRole> list =sysRoleService.listByParams(params);
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
        colTitle.put("name", "角色名");
        colTitle.put("intro", "角色说明");
        colTitle.put("sort", "排序");
        colTitle.put("status", "状态");
        colTitle.put("remark", "备注");
        List finalList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SysRole sm = list.get(i);
            HashMap map = new HashMap();
            map.put("id",  list.get(i).getId());
            map.put("name",  list.get(i).getName());
            map.put("intro",  list.get(i).getIntro());
            map.put("sort",  list.get(i).getSort());
            map.put("status",  list.get(i).getStatus());
            map.put("remark",  list.get(i).getRemark());
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
