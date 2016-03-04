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

import cola.machine.service.SysUserService;
import cola.machine.bean.SysUser;
import cola.machine.util.ResultUtil;
import cola.machine.util.ValidateUtil;
import cola.machine.util.rules.*;
import core.page.Page;

import cola.machine.util.StringUtil;
import cola.machine.util.ValidateUtil;
import core.util.RequestUtil;
import core.action.ResultDTO;
import cola.machine.util.DateUtil;
import cola.machine.bean.SysUserRole;
import cola.machine.service.SysUserRoleService;
import cola.machine.bean.SysRole;
import cola.machine.service.SysRoleService;
@Controller
@RequestMapping("/sysUser")
public class SysUserController extends BaseController{
    /** 日志 **/
    private Logger logger = LoggerFactory.getLogger(SysUserController.class);
    /** 权限service **/
    @Autowired
    private SysUserService sysUserService;
    
    @Autowired
    private SysUserRoleService sysUserRoleService;

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
        return "/static/html/SysUserList.html";
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
        String username = request.getParameter("username");
        if(!StringUtil.isBlank(username)){
                params.put("username",username);
        }
        String password = request.getParameter("password");
        if(!StringUtil.isBlank(password)){
                params.put("password",password);
        }
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
                params.put("status",status);
        }
        String email = request.getParameter("email");
        if(!StringUtil.isBlank(email)){
                params.put("email",email);
        }
        String telno = request.getParameter("telno");
        if(!StringUtil.isBlank(telno)){
                params.put("telno",telno);
        }
        String createtime = request.getParameter("createtime");
        if(!StringUtil.isBlank(createtime)){
            if(StringUtil.checkNumeric(createtime)){
                params.put("createtime",createtime);
            }else if(StringUtil.checkDateStr(createtime, "yyyy-MM-dd HH:mm:ss")){
                params.put("createtime",new Timestamp( DateUtil.parseToDate(createtime, "yyyy-MM-dd HH:mm:ss").getTime()));
            }
        }
        String createtimeBegin = request.getParameter("createtimeBegin");
        if(!StringUtil.isBlank(createtimeBegin)){
            if(StringUtil.checkNumeric(createtimeBegin)){
                params.put("createtimeBegin",createtimeBegin);
            }else if(StringUtil.checkDateStr(createtimeBegin, "yyyy-MM-dd HH:mm:ss")){
                params.put("createtimeBegin",new Timestamp( DateUtil.parseToDate(createtimeBegin, "yyyy-MM-dd HH:mm:ss").getTime()));
            }
        }
        String createtimeEnd = request.getParameter("createtimeEnd");
        if(!StringUtil.isBlank(createtimeEnd)){
            if(StringUtil.checkNumeric(createtimeEnd)){
                params.put("createtimeEnd",createtimeEnd);
            }else if(StringUtil.checkDateStr(createtimeEnd, "yyyy-MM-dd HH:mm:ss")){
                params.put("createtimeEnd",new Timestamp( DateUtil.parseToDate(createtimeEnd, "yyyy-MM-dd HH:mm:ss").getTime()));
            }
        }

        params.put("page",page);
        List<SysUser> sysUsers = sysUserService.listByParams4Page(params);
        return ResultUtil.getResult(sysUsers, page);
    }
    
    
    
    /**
     * @param id 参数
     * @param request 发请求
     * @return Object
     */
    @RequestMapping(value = "/edit.htm")
    public Object edit( HttpServletRequest request) {
        // 查找所有的角色
        return "/static/html/SysUserEdit.html";
    }
    @RequestMapping(value = "/view.htm")
    public Object viewPage( HttpServletRequest request) {
        return "/static/html/SysUserView.html";
    }
   
      @RequestMapping(value = "/view.json")
    @ResponseBody
    public Object view(HttpServletRequest request) {
    String id = request.getParameter("id");
HashMap<String,Object> result =new HashMap<String,Object>();
if(!StringUtil.isBlank(id)){
    SysUser bean = sysUserService.selectByPrimaryKey(Long.valueOf(id));
    result.put("bean", bean);
    HashMap<String,String> params =new HashMap<String,String>();
    params.put("SysRole",id);
    List<SysUserRole> childMaps =sysUserRoleService.listByParams(new HashMap<String,String>());
    result.put("childMaps", childMaps);
}
List<SysRole> childs =sysRoleService.listByParams(new HashMap<String,String>());
result.put("childs", childs);
return this.getResult(result);



    
      /*  String id = request.getParameter("id");
        SysUser bean = sysUserService.selectByPrimaryKey(Long.valueOf(id));
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
        SysUser sysUser =new  SysUser();
        /*
        String id = request.getParameter("id");
        if(!StringUtil.isBlank(id)){
            sysUser.setId(Long.valueOf(id)) ;
        }
        
        String username = request.getParameter("username");
        if(!StringUtil.isBlank(username)){
            sysUser.setUsername(String.valueOf(username)) ;
        }
        
        String password = request.getParameter("password");
        if(!StringUtil.isBlank(password)){
            sysUser.setPassword(String.valueOf(password)) ;
        }
        
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
            sysUser.setStatus(Integer.valueOf(status)) ;
        }
        
        String email = request.getParameter("email");
        if(!StringUtil.isBlank(email)){
            sysUser.setEmail(String.valueOf(email)) ;
        }
        
        String telno = request.getParameter("telno");
        if(!StringUtil.isBlank(telno)){
            sysUser.setTelno(String.valueOf(telno)) ;
        }
        
        String createtime = request.getParameter("createtime");
        if(!StringUtil.isBlank(createtime)){
            sysUser.setCreatetime(Timestamp.valueOf(createtime)) ;
        }
        */
        String id = request.getParameter("id");
        if(!StringUtil.isBlank(id)){
                sysUser.setId(Long.valueOf(id));
        }
        String username = request.getParameter("username");
        if(!StringUtil.isBlank(username)){
                sysUser.setUsername(String.valueOf(username));
        }
        String password = request.getParameter("password");
        if(!StringUtil.isBlank(password)){
                sysUser.setPassword(String.valueOf(password));
        }
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
                sysUser.setStatus(Integer.valueOf(status));
        }
        String email = request.getParameter("email");
        if(!StringUtil.isBlank(email)){
                sysUser.setEmail(String.valueOf(email));
        }
        String telno = request.getParameter("telno");
        if(!StringUtil.isBlank(telno)){
                sysUser.setTelno(String.valueOf(telno));
        }
        String createtime = request.getParameter("createtime");
        if(!StringUtil.isBlank(createtime)){
            if(StringUtil.checkNumeric(createtime)){
                sysUser.setCreatetime(Timestamp.valueOf(createtime));
            }else if(StringUtil.checkDateStr(createtime, "yyyy-MM-dd HH:mm:ss")){
                sysUser.setCreatetime(new Timestamp( DateUtil.parseToDate(createtime, "yyyy-MM-dd HH:mm:ss").getTime()));
            }
        }

        //valid
        ValidateUtil vu = new ValidateUtil();
        String validStr="";
        vu.add("id", id, "主键",  new Rule[]{new Digits(15,0)});
        vu.add("username", username, "用户名",  new Rule[]{new Length(40),new NotEmpty()});
        vu.add("password", password, "密码",  new Rule[]{new Length(40),new NotEmpty()});
        vu.add("status", status, "状态",  new Rule[]{new Digits(1,0),new CheckBox(new String[]{"1","2","3"}),new NotEmpty()});
        vu.add("email", email, "邮箱地址",  new Rule[]{new Length(40),new NotEmpty(),new EmailRule()});
        vu.add("telno", telno, "手机号码",  new Rule[]{new Length(11),new PhoneRule()});
        vu.add("createtime", createtime, "创建时间",  new Rule[]{new DateValue("yyyy-MM-dd HH:mm:ss")});
        validStr = vu.validateString();
        if(StringUtil.isNotEmpty(validStr)) {
            return ResultUtil.getResult(302,validStr);
        }

        String childids = request.getParameter("childids");
        return sysUserService.saveWithChilds(sysUser,childids);
       
    }
    
    @RequestMapping(value = "/del.json")
    @ResponseBody
    public Object delete(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        if(StringUtil.isBlank(idStr)){
            return this.getWrongResultFromCfg("err.param.notnull");
        }
        Long id = Long.valueOf(idStr);
        sysUserService.delete(id);
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
       return  sysUserService.multilDelete(idAry);
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
        String username = request.getParameter("username");
        if(!StringUtil.isBlank(username)){
                params.put("username",username);
        }
        String password = request.getParameter("password");
        if(!StringUtil.isBlank(password)){
                params.put("password",password);
        }
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
                params.put("status",status);
        }
        String email = request.getParameter("email");
        if(!StringUtil.isBlank(email)){
                params.put("email",email);
        }
        String telno = request.getParameter("telno");
        if(!StringUtil.isBlank(telno)){
                params.put("telno",telno);
        }
        String createtime = request.getParameter("createtime");
        if(!StringUtil.isBlank(createtime)){
            if(StringUtil.checkNumeric(createtime)){
                params.put("createtime",createtime);
            }else if(StringUtil.checkDateStr(createtime, "yyyy-MM-dd HH:mm:ss")){
                params.put("createtime",new Timestamp( DateUtil.parseToDate(createtime, "yyyy-MM-dd HH:mm:ss").getTime()));
            }
        }
        String createtimeBegin = request.getParameter("createtimeBegin");
        if(!StringUtil.isBlank(createtimeBegin)){
            if(StringUtil.checkNumeric(createtimeBegin)){
                params.put("createtimeBegin",createtimeBegin);
            }else if(StringUtil.checkDateStr(createtimeBegin, "yyyy-MM-dd HH:mm:ss")){
                params.put("createtimeBegin",new Timestamp( DateUtil.parseToDate(createtimeBegin, "yyyy-MM-dd HH:mm:ss").getTime()));
            }
        }
        String createtimeEnd = request.getParameter("createtimeEnd");
        if(!StringUtil.isBlank(createtimeEnd)){
            if(StringUtil.checkNumeric(createtimeEnd)){
                params.put("createtimeEnd",createtimeEnd);
            }else if(StringUtil.checkDateStr(createtimeEnd, "yyyy-MM-dd HH:mm:ss")){
                params.put("createtimeEnd",new Timestamp( DateUtil.parseToDate(createtimeEnd, "yyyy-MM-dd HH:mm:ss").getTime()));
            }
        }

        // 查询list集合
        List<SysUser> list =sysUserService.listByParams(params);
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
        colTitle.put("username", "用户名");
        colTitle.put("password", "密码");
        colTitle.put("status", "状态");
        colTitle.put("email", "邮箱地址");
        colTitle.put("telno", "手机号码");
        colTitle.put("createtime", "创建时间");
        List finalList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SysUser sm = list.get(i);
            HashMap map = new HashMap();
            map.put("id",  list.get(i).getId());
            map.put("username",  list.get(i).getUsername());
            map.put("password",  list.get(i).getPassword());
            map.put("status",  list.get(i).getStatus());
            map.put("email",  list.get(i).getEmail());
            map.put("telno",  list.get(i).getTelno());
            map.put("createtime",  list.get(i).getCreatetime());
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
