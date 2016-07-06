/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */

package com.kfpanda.secu.action.sys;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kfpanda.core.page.Page;
import com.kfpanda.secu.action.BaseAction;
import com.kfpanda.secu.bean.sys.SysResource;
import com.kfpanda.secu.service.sys.SysResourceService;
import com.kfpanda.util.DateUtil;
import com.util.common.RequestUtil;
import com.util.common.ResultUtil;
import com.util.common.StringUtil;
import com.util.common.ValidateUtil;
import com.util.common.rule.CheckBox;
import com.util.common.rule.DateValue;
import com.util.common.rule.Digits;
import com.util.common.rule.Length;
import com.util.common.rule.NotEmpty;
import com.util.common.rule.Rule;

@Controller
@RequestMapping("/sysResource")
public class SysResourceAction extends BaseAction{
	/** 日志 **/
	private Logger logger = LoggerFactory.getLogger(SysResourceAction.class);
	/** 权限service **/
	@Autowired
	private SysResourceService sysResourceService;

	/**
	 * 说明:ajax请求角色信息
	 * 
	 * @return
	 * @return Object
	 * @author dozen.zhang
	 * @date 2015年11月15日下午12:31:55
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(HttpServletRequest request) {
		Page page = RequestUtil.getPage(request);
		if (page == null) {
			return getResult(300, "参数错误");
		}
		HashMap<String,Object> params= new HashMap<String,Object>();
		String id = request.getParameter("id");
		if(!StringUtil.isBlank(id)){
			params.put("id",id);
		}
		String pid = request.getParameter("pid");
		if(!StringUtil.isBlank(pid)){
			params.put("pid",pid);
		}
		String name = request.getParameter("name");
		if(!StringUtil.isBlank(name)){
			params.put("name",name);
		}
		String code = request.getParameter("code");
		if(!StringUtil.isBlank(code)){
			params.put("code",code);
		}
		String type = request.getParameter("type");
		if(!StringUtil.isBlank(type)){
			params.put("type",type);
		}
		String url = request.getParameter("url");
		if(!StringUtil.isBlank(url)){
			params.put("url",url);
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
		List<SysResource> sysResources = sysResourceService.listByParams4Page(params);
		return ResultUtil.getResult(sysResources, page);
	}

	@RequestMapping(value = "/view")
	@ResponseBody
	public Object view(HttpServletRequest request) {
		String id = request.getParameter("id");
		HashMap<String,Object> result =new HashMap<String,Object>();
		if(!StringUtil.isBlank(id)){
			SysResource bean = sysResourceService.selectByPrimaryKey(Long.valueOf(id));
			result.put("bean", bean);
		}
		return this.getResult(result);
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
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(HttpServletRequest request) throws Exception {
		SysResource sysResource =new  SysResource();
		String id = request.getParameter("id");
		if(!StringUtil.isBlank(id)){
			sysResource.setId(Long.valueOf(id));
		}
		String pid = request.getParameter("pid");
		if(!StringUtil.isBlank(pid)){
			sysResource.setPid(Long.valueOf(pid));
		}
		String name = request.getParameter("name");
		if(!StringUtil.isBlank(name)){
			sysResource.setName(String.valueOf(name));
		}
		String code = request.getParameter("code");
		if(!StringUtil.isBlank(code)){
			sysResource.setCode(String.valueOf(code));
		}
		String type = request.getParameter("type");
		if(!StringUtil.isBlank(type)){
			sysResource.setType(String.valueOf(type));
		}
		String url = request.getParameter("url");
		if(!StringUtil.isBlank(url)){
			sysResource.setUrl(String.valueOf(url));
		}
		String sort = request.getParameter("sort");
		if(!StringUtil.isBlank(sort)){
			sysResource.setSort(Integer.valueOf(sort));
		}
		String status = request.getParameter("status");
		if(!StringUtil.isBlank(status)){
			sysResource.setStatus(Integer.valueOf(status));
		}
		String remark = request.getParameter("remark");
		if(!StringUtil.isBlank(remark)){
			sysResource.setRemark(String.valueOf(remark));
		}
		String createtime = request.getParameter("createtime");
		if(!StringUtil.isBlank(createtime)){
			if(StringUtil.checkNumeric(createtime)){
				sysResource.setCreateTime(Timestamp.valueOf(createtime));
			}else if(StringUtil.checkDateStr(createtime, "yyyy-MM-dd HH:mm:ss")){
				sysResource.setCreateTime(new Timestamp( DateUtil.parseToDate(createtime, "yyyy-MM-dd HH:mm:ss").getTime()));
			}
		}

		//valid
		ValidateUtil vu = new ValidateUtil();
		String validStr="";
		vu.add("id", id, "主键",  new Rule[]{new Digits(10,0)});
		vu.add("pid", pid, "主键",  new Rule[]{new Digits(10,0)});
		vu.add("name", name, "资源名称",  new Rule[]{new Length(20),new NotEmpty()});
		vu.add("code", code, "资源代码",  new Rule[]{new Length(20),new NotEmpty()});
		vu.add("type", type, "资源分类",  new Rule[]{new Length(20),new NotEmpty()});
		vu.add("url", url, "资源对应URL",  new Rule[]{new Length(255)});
		vu.add("sort", sort, "排序id",  new Rule[]{new Digits(15,0)});
		vu.add("status", status, "状态",  new Rule[]{new Digits(1,0),new CheckBox(new String[]{"1","2"}),new NotEmpty()});
		vu.add("remark", remark, "备注",  new Rule[]{new Length(20)});
		vu.add("createtime", createtime, "创建时间",  new Rule[]{new DateValue("yyyy-MM-dd HH:mm:ss")});
		validStr = vu.validateString();
		if(StringUtil.isNotEmpty(validStr)) {
			return ResultUtil.getResult(302,validStr);
		}

		return sysResourceService.save(sysResource);

	}

	@RequestMapping(value = "/del")
	@ResponseBody
	public Object delete(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		if(StringUtil.isBlank(idStr)){
			return getResult(300, "参数错误");
		}
		Long id = Long.valueOf(idStr);
		sysResourceService.delete(id);
		return this.getResult();
	}
	/**
	 * 多行删除
	 * @param request
	 * @return
	 * @author dozen.zhang
	 */
	@RequestMapping(value = "/mdel")
	@ResponseBody
	public Object multiDelete(HttpServletRequest request) {
		String idStr = request.getParameter("ids");
		if(StringUtil.isBlank(idStr)){
			return getResult(300, "参数错误");  
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
		return  sysResourceService.multilDelete(idAry);
	}

	/*  *//**
	 * 导出
	 * @param request
	 * @return
	 * @author dozen.zhang
	 *//*
    @RequestMapping(value = "/export")
    @ResponseBody   
    public Object exportExcel(HttpServletRequest request){
               HashMap<String,Object> params= new HashMap<String,Object>();
        String id = request.getParameter("id");
        if(!StringUtil.isBlank(id)){
                params.put("id",id);
        }
        String pid = request.getParameter("pid");
        if(!StringUtil.isBlank(pid)){
                params.put("pid",pid);
        }
        String name = request.getParameter("name");
        if(!StringUtil.isBlank(name)){
                params.put("name",name);
        }
        String code = request.getParameter("code");
        if(!StringUtil.isBlank(code)){
                params.put("code",code);
        }
        String type = request.getParameter("type");
        if(!StringUtil.isBlank(type)){
                params.put("type",type);
        }
        String url = request.getParameter("url");
        if(!StringUtil.isBlank(url)){
                params.put("url",url);
        }
        String order = request.getParameter("order");
        if(!StringUtil.isBlank(order)){
                params.put("order",order);
        }
        String status = request.getParameter("status");
        if(!StringUtil.isBlank(status)){
                params.put("status",status);
        }
        String remark = request.getParameter("remark");
        if(!StringUtil.isBlank(remark)){
                params.put("remark",remark);
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
        List<SysResource> list =sysResourceService.listByParams(params);
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
        colTitle.put("pid", "主键");
        colTitle.put("name", "资源名称");
        colTitle.put("code", "资源代码");
        colTitle.put("type", "资源分类");
        colTitle.put("url", "资源对应URL");
        colTitle.put("order", "排序id");
        colTitle.put("status", "状态");
        colTitle.put("remark", "备注");
        colTitle.put("createtime", "创建时间");
        List finalList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            SysResource sm = list.get(i);
            HashMap map = new HashMap();
            map.put("id",  list.get(i).getId());
            map.put("pid",  list.get(i).getPId());
            map.put("name",  list.get(i).getName());
            map.put("code",  list.get(i).getCode());
            map.put("type",  list.get(i).getType());
            map.put("url",  list.get(i).getUrl());
            map.put("order",  list.get(i).getOrder());
            map.put("status",  list.get(i).getStatus());
            map.put("remark",  list.get(i).getRemark());
            map.put("createtime",  list.get(i).getCreateTime());
            finalList.add(map);
        }
        try {
            if (cola.machine.util.ExcelUtil.getExcelFile(finalList, fileName, colTitle) != null) {
                return this.getResult();
            }

	  * return new ResponseEntity<byte[]>(
	  * FileUtils.readFileToByteArray(new File(fileName)), headers,
	  * HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.getResult(0, "数据为空，导出失败");

    }*/

	/*    @RequestMapping(value = "/import")
    public void importExcel(){

    }*/
}
