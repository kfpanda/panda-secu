/**
 * 版权所有：公众信息
 * 项目名称:calendar
 * 创建者: dozen.zhang
 * 创建日期: 2015年11月15日
 * 文件说明: 
 */

package com.kfpanda.secu.shiro.action;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfpanda.core.page.Page;
import com.kfpanda.secu.action.BaseAction;
import com.kfpanda.secu.bean.sys.SysRole;
import com.kfpanda.secu.bean.sys.SysUser;
import com.kfpanda.secu.bean.sys.SysUserRole;
import com.kfpanda.secu.service.SysRoleService;
import com.kfpanda.secu.service.SysUserRoleService;
import com.kfpanda.secu.service.SysUserService;
import com.kfpanda.util.DateUtil;
import com.util.common.RequestUtil;
import com.util.common.ResultUtil;
import com.util.common.StringUtil;
import com.util.common.ValidateUtil;
import com.util.common.rule.CheckBox;
import com.util.common.rule.DateValue;
import com.util.common.rule.Digits;
import com.util.common.rule.EmailRule;
import com.util.common.rule.Length;
import com.util.common.rule.NotEmpty;
import com.util.common.rule.PhoneRule;
import com.util.common.rule.Rule;
@Controller
@RequestMapping("/sysUser")
public class SysUserController extends BaseAction{
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
		String username = request.getParameter("username");
		if(!StringUtil.isBlank(username)){
			params.put("username",username);
		}
		String password = request.getParameter("password");
		if(!StringUtil.isBlank(password)){
			params.put("password",password);
		}
		String nkname = request.getParameter("nkname");
		if(!StringUtil.isBlank(nkname)){
			params.put("nkname",nkname);
		}
		String type = request.getParameter("type");
		if(!StringUtil.isBlank(type)){
			params.put("type",type);
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
		String idcard = request.getParameter("idcard");
		if(!StringUtil.isBlank(idcard)){
			params.put("idcard",idcard);
		}
		String sex = request.getParameter("sex");
		if(!StringUtil.isBlank(sex)){
			params.put("sex",sex);
		}
		String birth = request.getParameter("birth");
		if(!StringUtil.isBlank(birth)){
			if(StringUtil.checkNumeric(birth)){
				params.put("birth",birth);
			}else if(StringUtil.checkDateStr(birth, "yyyy-MM-dd")){
				params.put("birth",DateUtil.parseToDate(birth, "yyyy-MM-dd"));
			}
		}


		String birthBegin = request.getParameter("birthBegin");
		if(!StringUtil.isBlank(birthBegin)){
			if(StringUtil.checkNumeric(birthBegin)){
				params.put("birthBegin",birthBegin);
			}else if(StringUtil.checkDateStr(birthBegin, "yyyy-MM-dd")){
				params.put("birthBegin",DateUtil.parseToDate(birthBegin, "yyyy-MM-dd"));
			}
		}
		String birthEnd = request.getParameter("birthEnd");
		if(!StringUtil.isBlank(birthEnd)){
			if(StringUtil.checkNumeric(birthEnd)){
				params.put("birthEnd",birthEnd);
			}else if(StringUtil.checkDateStr(birthEnd, "yyyy-MM-dd")){
				params.put("birthEnd",DateUtil.parseToDate(birthEnd, "yyyy-MM-dd"));
			}
		}
		String integral = request.getParameter("integral");
		if(!StringUtil.isBlank(integral)){
			params.put("integral",integral);
		}
		String address = request.getParameter("address");
		if(!StringUtil.isBlank(address)){
			params.put("address",address);
		}
		String weichat = request.getParameter("weichat");
		if(!StringUtil.isBlank(weichat)){
			params.put("weichat",weichat);
		}
		String qq = request.getParameter("qq");
		if(!StringUtil.isBlank(qq)){
			params.put("qq",qq);
		}
		String face = request.getParameter("face");
		if(!StringUtil.isBlank(face)){
			params.put("face",face);
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
		String updatetime = request.getParameter("updatetime");
		if(!StringUtil.isBlank(updatetime)){
			if(StringUtil.checkNumeric(updatetime)){
				params.put("updatetime",updatetime);
			}else if(StringUtil.checkDateStr(updatetime, "yyyy-MM-dd HH:mm:ss")){
				params.put("updatetime",new Timestamp( DateUtil.parseToDate(updatetime, "yyyy-MM-dd HH:mm:ss").getTime()));
			}
		}
		String updatetimeBegin = request.getParameter("updatetimeBegin");
		if(!StringUtil.isBlank(updatetimeBegin)){
			if(StringUtil.checkNumeric(updatetimeBegin)){
				params.put("updatetimeBegin",updatetimeBegin);
			}else if(StringUtil.checkDateStr(updatetimeBegin, "yyyy-MM-dd HH:mm:ss")){
				params.put("updatetimeBegin",new Timestamp( DateUtil.parseToDate(updatetimeBegin, "yyyy-MM-dd HH:mm:ss").getTime()));
			}
		}
		String updatetimeEnd = request.getParameter("updatetimeEnd");
		if(!StringUtil.isBlank(updatetimeEnd)){
			if(StringUtil.checkNumeric(updatetimeEnd)){
				params.put("updatetimeEnd",updatetimeEnd);
			}else if(StringUtil.checkDateStr(updatetimeEnd, "yyyy-MM-dd HH:mm:ss")){
				params.put("updatetimeEnd",new Timestamp( DateUtil.parseToDate(updatetimeEnd, "yyyy-MM-dd HH:mm:ss").getTime()));
			}
		}

		params.put("page",page);
		List<SysUser> sysUsers = sysUserService.listByParams4Page(params);
		return ResultUtil.getResult(sysUsers, page);
	}

	@RequestMapping(value = "/view")
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
		SysUser sysUser =new  SysUser();

		String id = request.getParameter("id");
		if(!StringUtil.isBlank(id)){
			sysUser.setId(Long.valueOf(id));
		}
		String username = request.getParameter("username");
		if(!StringUtil.isBlank(username)){
			sysUser.setUserName(String.valueOf(username));
		}
		String password = request.getParameter("password");
		if(!StringUtil.isBlank(password)){
			sysUser.setPassword(String.valueOf(password));
		}
		String nkname = request.getParameter("nkname");
		if(!StringUtil.isBlank(nkname)){
			sysUser.setNkName(String.valueOf(nkname));
		}
		String type = request.getParameter("type");
		if(!StringUtil.isBlank(type)){
			sysUser.setType(Integer.valueOf(type));
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
			sysUser.setTelNo(String.valueOf(telno));
		}
		String idcard = request.getParameter("idcard");
		if(!StringUtil.isBlank(idcard)){
			sysUser.setIdCard(String.valueOf(idcard));
		}
		String sex = request.getParameter("sex");
		if(!StringUtil.isBlank(sex)){
			sysUser.setSex((byte)(Integer.valueOf(sex).intValue()));
		}
		String birth = request.getParameter("birth");
		if(!StringUtil.isBlank(birth)){
			if(StringUtil.checkNumeric(birth)){
				sysUser.setBirth(new Date(birth));
			}else if(StringUtil.checkDateStr(birth, "yyyy-MM-dd")){
				sysUser.setBirth(DateUtil.parseToDate(birth, "yyyy-MM-dd"));
			}
		}
		String integral = request.getParameter("integral");
		if(!StringUtil.isBlank(integral)){
			sysUser.setIntegral(Integer.valueOf(integral));
		}
		String address = request.getParameter("address");
		if(!StringUtil.isBlank(address)){
			sysUser.setAddress(String.valueOf(address));
		}
		String weichat = request.getParameter("weichat");
		if(!StringUtil.isBlank(weichat)){
			sysUser.setWeiChat(String.valueOf(weichat));
		}
		String qq = request.getParameter("qq");
		if(!StringUtil.isBlank(qq)){
			sysUser.setQq(Long.valueOf(qq));
		}
		String face = request.getParameter("face");
		if(!StringUtil.isBlank(face)){
			sysUser.setFace(String.valueOf(face));
		}
		String remark = request.getParameter("remark");
		if(!StringUtil.isBlank(remark)){
			sysUser.setRemark(String.valueOf(remark));
		}
		String createtime = request.getParameter("createtime");
		if(!StringUtil.isBlank(createtime)){
			if(StringUtil.checkNumeric(createtime)){
				sysUser.setCreateTime(Timestamp.valueOf(createtime));
			}else if(StringUtil.checkDateStr(createtime, "yyyy-MM-dd HH:mm:ss")){
				sysUser.setCreateTime(new Timestamp( DateUtil.parseToDate(createtime, "yyyy-MM-dd HH:mm:ss").getTime()));
			}
		}
		String updatetime = request.getParameter("updatetime");
		if(!StringUtil.isBlank(updatetime)){
			if(StringUtil.checkNumeric(updatetime)){
				sysUser.setUpdateTime(Timestamp.valueOf(updatetime));
			}else if(StringUtil.checkDateStr(updatetime, "yyyy-MM-dd HH:mm:ss")){
				sysUser.setUpdateTime(new Timestamp( DateUtil.parseToDate(updatetime, "yyyy-MM-dd HH:mm:ss").getTime()));
			}
		}

		//valid
		ValidateUtil vu = new ValidateUtil();
		String validStr="";
		vu.add("id", id, "主键",  new Rule[]{new Digits(15,0)});
		vu.add("username", username, "用户名",  new Rule[]{new Length(20),new NotEmpty()});
		vu.add("password", password, "密码",  new Rule[]{new Length(50),new NotEmpty()});
		vu.add("nkname", nkname, "昵称",  new Rule[]{new Length(20)});
		vu.add("type", type, "昵称",  new Rule[]{new Digits(4,0)});
		vu.add("status", status, "状态",  new Rule[]{new Digits(1,0),new CheckBox(new String[]{"1","2","3"}),new NotEmpty()});
		vu.add("email", email, "邮箱地址",  new Rule[]{new Length(50),new EmailRule()});
		vu.add("telno", telno, "手机号码",  new Rule[]{new Length(11),new PhoneRule()});
		vu.add("idcard", idcard, "身份证号码",  new Rule[]{new Length(18)});
		vu.add("sex", sex, "身份证号码",  new Rule[]{new Digits(1,0)});
		vu.add("birth", birth, "出生年月",  new Rule[]{new DateValue("yyyy-MM-dd")});
		vu.add("integral", integral, "积分",  new Rule[]{new Digits(11,0)});
		vu.add("address", address, "地址",  new Rule[]{new Length(50)});
		vu.add("weichat", weichat, "积分",  new Rule[]{new Length(20)});
		vu.add("qq", qq, "积分",  new Rule[]{new Digits(11,0)});
		vu.add("face", face, "头像",  new Rule[]{new Length(100)});
		vu.add("remark", remark, "头像",  new Rule[]{new Length(200)});
		vu.add("createtime", createtime, "创建时间",  new Rule[]{new DateValue("yyyy-MM-dd HH:mm:ss")});
		vu.add("updatetime", updatetime, "创建时间",  new Rule[]{new DateValue("yyyy-MM-dd HH:mm:ss")});
		validStr = vu.validateString();
		if(StringUtil.isNotEmpty(validStr)) {
			return ResultUtil.getResult(302,validStr);
		}

		String childids = request.getParameter("childids");
		return sysUserService.saveWithChilds(sysUser,childids);

	}

	@RequestMapping(value = "/del")
	@ResponseBody
	public Object delete(HttpServletRequest request) {
		String idStr = request.getParameter("id");
		if(StringUtil.isBlank(idStr)){
			return getResult(300, "参数错误");
		}
		Long id = Long.valueOf(idStr);
		if(1==sysUserService.delete(id)){
			return this.getResult();
		}else{
			return this.getResult(1);
		}
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
		return  sysUserService.multilDelete(idAry);
	}
}
