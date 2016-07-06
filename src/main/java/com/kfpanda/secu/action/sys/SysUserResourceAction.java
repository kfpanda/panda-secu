/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */

package com.kfpanda.secu.action.sys;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfpanda.core.page.Page;
import com.kfpanda.secu.action.BaseAction;
import com.kfpanda.secu.bean.sys.SysUserResource;
import com.kfpanda.secu.service.sys.SysUserResourceService;
import com.util.common.RequestUtil;
import com.util.common.ResultUtil;
import com.util.common.StringUtil;
import com.util.common.ValidateUtil;
import com.util.common.rule.Digits;
import com.util.common.rule.NotEmpty;
import com.util.common.rule.Rule;
@Controller
@RequestMapping("/sysUserResource")
public class SysUserResourceAction extends BaseAction
{
	/** 日志 **/
	private Logger logger = LoggerFactory.getLogger(SysUserResourceAction.class);
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
		String uid = request.getParameter("uid");
		if(!StringUtil.isBlank(uid)){
			params.put("uid",uid);
		}
		String rid = request.getParameter("rid");
		if(!StringUtil.isBlank(rid)){
			params.put("rid",rid);
		}

		params.put("page",page);
		List<SysUserResource> sysUserResources = sysUserResourceService.listByParams4Page(params);
		return ResultUtil.getResult(sysUserResources, page);
	}

	@RequestMapping(value = "/view")
	@ResponseBody
	public Object view(HttpServletRequest request) {
		String id = request.getParameter("id");
		HashMap<String,Object> result =new HashMap<String,Object>();
		if(!StringUtil.isBlank(id)){
			SysUserResource bean = sysUserResourceService.selectByPrimaryKey(Long.valueOf(id));
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
		SysUserResource sysUserResource =new  SysUserResource();
		String id = request.getParameter("id");
		if(!StringUtil.isBlank(id)){
			sysUserResource.setId(Long.valueOf(id));
		}
		String uid = request.getParameter("uid");
		if(!StringUtil.isBlank(uid)){
			sysUserResource.setUid(Long.valueOf(uid));
		}
		String rid = request.getParameter("rid");
		if(!StringUtil.isBlank(rid)){
			sysUserResource.setRid(Long.valueOf(rid));
		}

		//valid
		ValidateUtil vu = new ValidateUtil();
		String validStr="";
		vu.add("id", id, "主键",  new Rule[]{new Digits(10,0)});
		vu.add("uid", uid, "用户id",  new Rule[]{new Digits(10,0),new NotEmpty()});
		vu.add("rid", rid, "资源id",  new Rule[]{new Digits(10,0),new NotEmpty()});
		validStr = vu.validateString();
		if(StringUtil.isNotEmpty(validStr)) {
			return ResultUtil.getResult(302,validStr);
		}

		return sysUserResourceService.save(sysUserResource);

	}

	@RequestMapping(value = "/del")
	@ResponseBody
	public Object delete(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		if(StringUtil.isBlank(idStr)){
			return getResult(300, "参数错误");
		}
		Long id = Long.valueOf(idStr);
		sysUserResourceService.delete(id);
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
		return  sysUserResourceService.multilDelete(idAry);
	}

}
