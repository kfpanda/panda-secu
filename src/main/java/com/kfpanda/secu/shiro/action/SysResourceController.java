/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */

package com.kfpanda.secu.shiro.action;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.language.bm.Rule;
import org.apache.tools.ant.taskdefs.Length;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfpanda.core.page.Page;
import com.kfpanda.secu.action.ResultAction;
import com.kfpanda.secu.bean.sys.SysResource;
import com.kfpanda.secu.service.SysResourceService;
import com.kfpanda.util.DateUtil;
import com.util.common.RequestUtil;
import com.util.common.ResultUtil;
import com.util.common.StringUtil;
import com.util.common.ValidateUtil;
import com.util.common.rule.CheckBox;
import com.util.common.rule.Digits;
@Controller
@RequestMapping("/sysResource")
public class SysResourceController extends ResultAction{
	/** 日志 **/
	private Logger logger = LoggerFactory.getLogger(SysResourceController.class);
	/** 权限service **/
	@Autowired
	private SysResourceService sysResourceService;

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
		return "/static/html/SysResourceList.html";
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
			return this.getResult(200,"参数错误");
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
		String code = request.getParameter("code");
		if(!StringUtil.isBlank(code)){
			params.put("code",code);
		}
		String type = request.getParameter("type");
		if(!StringUtil.isBlank(type)){
			params.put("type",type);
		}
		String intro = request.getParameter("intro");
		if(!StringUtil.isBlank(intro)){
			params.put("intro",intro);
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

		params.put("page",page);
		List<SysResource> sysResources = sysResourceService.listByParams4Page(params);
		return ResultUtil.getResult(sysResources, page);
	}


	@RequestMapping(value = "/view.json")
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
	@RequestMapping(value = "/save.json")
	@ResponseBody
	public Object save(HttpServletRequest request) throws Exception {
		SysResource sysResource =new  SysResource();
		String id = request.getParameter("id");
		if(!StringUtil.isBlank(id)){
			sysResource.setId(Long.valueOf(id));
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
		String intro = request.getParameter("intro");
		if(!StringUtil.isBlank(intro)){
			sysResource.setIntro(String.valueOf(intro));
		}
		String url = request.getParameter("url");
		if(!StringUtil.isBlank(url)){
			sysResource.setUrl(String.valueOf(url));
		}
		String sort = request.getParameter("sort");
		if(!StringUtil.isBlank(sort)){
			sysResource.setSort(Long.valueOf(sort));
		}
		String status = request.getParameter("status");
		if(!StringUtil.isBlank(status)){
			sysResource.setStatus(Integer.valueOf(status));
		}
		String remark = request.getParameter("remark");
		if(!StringUtil.isBlank(remark)){
			sysResource.setRemark(String.valueOf(remark));
		}

		//valid
		ValidateUtil vu = new ValidateUtil();
		String validStr="";
		vu.add("id", id, "主键",  new Rule[]{new Digits(15,0)});
		vu.add("name", name, "资源名称",  new Rule[]{new Length(40),new NotEmpty()});
		vu.add("code", code, "资源代码",  new Rule[]{new Length(40),new NotEmpty()});
		vu.add("type", type, "资源分类",  new Rule[]{new Length(15),new NotEmpty()});
		vu.add("intro", intro, "资源说明",  new Rule[]{new Length(40)});
		vu.add("url", url, "资源对应URL",  new Rule[]{new Length(255)});
		vu.add("sort", sort, "排序id",  new Rule[]{new Digits(15,0)});
		vu.add("status", status, "状态",  new Rule[]{new Digits(1,0),new CheckBox(new String[]{"1","2"}),new NotEmpty()});
		vu.add("remark", remark, "备注",  new Rule[]{new Length(40)});
		validStr = vu.validateString();
		if(StringUtil.isNotEmpty(validStr)) {
			return ResultUtil.getResult(302,validStr);
		}

		return sysResourceService.save(sysResource);

	}

	@RequestMapping(value = "/del.json")
	@ResponseBody
	public Object delete(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		if(StringUtil.isBlank(idStr)){
			return this.getWrongResultFromCfg("err.param.notnull");
		}
		Long id = Long.valueOf(idStr);
		sysResourceService.delete(id);
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
		return  sysResourceService.multilDelete(idAry);
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
		String code = request.getParameter("code");
		if(!StringUtil.isBlank(code)){
			params.put("code",code);
		}
		String type = request.getParameter("type");
		if(!StringUtil.isBlank(type)){
			params.put("type",type);
		}
		String intro = request.getParameter("intro");
		if(!StringUtil.isBlank(intro)){
			params.put("intro",intro);
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
		colTitle.put("name", "资源名称");
		colTitle.put("code", "资源代码");
		colTitle.put("type", "资源分类");
		colTitle.put("intro", "资源说明");
		colTitle.put("url", "资源对应URL");
		colTitle.put("sort", "排序id");
		colTitle.put("status", "状态");
		colTitle.put("remark", "备注");
		List finalList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			SysResource sm = list.get(i);
			HashMap map = new HashMap();
			map.put("id",  list.get(i).getId());
			map.put("name",  list.get(i).getName());
			map.put("code",  list.get(i).getCode());
			map.put("type",  list.get(i).getType());
			map.put("intro",  list.get(i).getIntro());
			map.put("url",  list.get(i).getUrl());
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
