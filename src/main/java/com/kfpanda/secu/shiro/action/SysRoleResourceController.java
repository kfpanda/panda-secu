/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */

package com.kfpanda.secu.shiro.action;
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
import com.kfpanda.secu.bean.sys.SysRoleResource;
import com.kfpanda.secu.service.SysRoleResourceService;
import com.util.common.RequestUtil;
import com.util.common.ResultUtil;
import com.util.common.StringUtil;
import com.util.common.ValidateUtil;
import com.util.common.rule.Digits;
import com.util.common.rule.NotEmpty;
import com.util.common.rule.Rule;
@Controller
@RequestMapping("/sysRoleResource")
public class SysRoleResourceController extends BaseAction{
	/** 日志 **/
	private Logger logger = LoggerFactory.getLogger(SysRoleResourceController.class);
	/** 权限service **/
	@Autowired
	private SysRoleResourceService sysRoleResourceService;


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
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(HttpServletRequest request) {
		Page page = RequestUtil.getPage(request);
		if(page ==null){
			return getResult(300, "参数错误");
		}

		HashMap<String,Object> params= new HashMap<String,Object>();
		String id = request.getParameter("id");
		if(!StringUtil.isBlank(id)){
			params.put("id",id);
		}
		String roleid = request.getParameter("roleid");
		if(!StringUtil.isBlank(roleid)){
			params.put("roleid",roleid);
		}
		String rid = request.getParameter("rid");
		if(!StringUtil.isBlank(rid)){
			params.put("rid",rid);
		}

		params.put("page",page);
		List<SysRoleResource> sysRoleResources = sysRoleResourceService.listByParams4Page(params);
		return ResultUtil.getResult(sysRoleResources, page);
	}

	@RequestMapping(value = "/view")
	@ResponseBody
	public Object view(HttpServletRequest request) {
		String id = request.getParameter("id");
		HashMap<String,Object> result =new HashMap<String,Object>();
		if(!StringUtil.isBlank(id)){
			SysRoleResource bean = sysRoleResourceService.selectByPrimaryKey(Long.valueOf(id));
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
		SysRoleResource sysRoleResource =new  SysRoleResource();
		String id = request.getParameter("id");
		if(!StringUtil.isBlank(id)){
			sysRoleResource.setId(Long.valueOf(id));
		}
		String roleid = request.getParameter("roleid");
		if(!StringUtil.isBlank(roleid)){
			sysRoleResource.setRoleId(Long.valueOf(roleid));
		}
		String rid = request.getParameter("rid");
		if(!StringUtil.isBlank(rid)){
			sysRoleResource.setrId(Long.valueOf(rid));
		}

		//valid
		ValidateUtil vu = new ValidateUtil();
		String validStr="";
		vu.add("id", id, "主键",  new Rule[]{new Digits(15,0)});
		vu.add("roleid", roleid, "角色id",  new Rule[]{new Digits(15,0),new NotEmpty()});
		vu.add("rid", rid, "资源id",  new Rule[]{new Digits(15,0),new NotEmpty()});
		validStr = vu.validateString();
		if(StringUtil.isNotEmpty(validStr)) {
			return ResultUtil.getResult(302,validStr);
		}

		return sysRoleResourceService.save(sysRoleResource);

	}

	@RequestMapping(value = "/del")
	@ResponseBody
	public Object delete(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		if(StringUtil.isBlank(idStr)){
			return getResult(300, "参数错误");
		}
		Long id = Long.valueOf(idStr);
		sysRoleResourceService.delete(id);
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
		return  sysRoleResourceService.multilDelete(idAry);
	}

	/**
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
		String roleid = request.getParameter("roleid");
		if(!StringUtil.isBlank(roleid)){
			params.put("roleid",roleid);
		}
		String rid = request.getParameter("rid");
		if(!StringUtil.isBlank(rid)){
			params.put("rid",rid);
		}

		// 查询list集合
		List<SysRoleResource> list =sysRoleResourceService.listByParams(params);
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
		colTitle.put("roleid", "角色id");
		colTitle.put("rid", "资源id");
		List finalList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			SysRoleResource sm = list.get(i);
			HashMap map = new HashMap();
			map.put("id",  list.get(i).getId());
			map.put("roleid",  list.get(i).getRoleid());
			map.put("rid",  list.get(i).getRid());
			finalList.add(map);
		}
		try {
			if (cola.machine.util.ExcelUtil.getExcelFile(finalList, fileName, colTitle) != null) {
				return this.getResult(SUCC, "导出成功", fileName);
			}
			
			 * return new ResponseEntity<byte[]>(
			 * FileUtils.readFileToByteArray(new File(fileName)), headers,
			 * HttpStatus.CREATED);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.getResult(0, "数据为空，导出失败");

	}
	@RequestMapping(value = "/import")
	public void importExcel(){

	}*/
}
