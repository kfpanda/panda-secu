package com.kfpanda.secu.action.sys;
import java.util.ArrayList;
import java.util.List;

import com.kfpanda.core.page.Pageable;
import com.kfpanda.secu.action.ErrorEnum;
import com.kfpanda.secu.bean.sys.SysRole;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.kfpanda.secu.action.BaseAction;
import com.kfpanda.secu.service.sys.SysRoleService;

/**
 * 角色管理类。
 * @author kfpanda
 * @date 2016/7/7
 */
@Controller
@RequestMapping("/role")
public class SysRoleAction extends BaseAction{
	private static final Logger logger = LogManager.getLogger(SysRoleAction.class);

	/** 权限service **/
	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 分页查询。
	 * @return Object
	 * @author kfpanda
	 * @date 2016年11月15日下午12:31:55
	 */
	@RequestMapping(value = "/find")
	public @ResponseBody Object pageFind(
			@RequestParam(value = "name", required = false) String name, @RequestParam(value = "code", required = false) String code,
			String sort, @RequestParam(value = "status", required = false) Integer status, @ModelAttribute Pageable page) {

		List<SysRole> sysRoles = sysRoleService.pageFind(name, code, status, page);
		return this.getResult(sysRoles, page);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(
			@RequestParam(value = "name") String name, @RequestParam(value = "code") String code,
			@RequestParam(value = "sort", required = false) Integer sort, @RequestParam(value = "status") Integer status,
			@RequestParam(value = "remark", required = false) String remark) {

		if(StringUtils.isBlank(name) || StringUtils.isBlank(code) || status < 0){
			return this.getErrorResult(ErrorEnum.NOTNULL, "name, code, status");
		}
		SysRole sysRole = new SysRole();
		sysRole.setName(name);
		sysRole.setCode(code);
		sysRole.setStatus(status);
		sysRole.setSort(sort);
		sysRole.setRemark(remark);
		Integer result = sysRoleService.save(sysRole);
		if(result == 1){
			return this.getResult();
		}
		return this.getErrorResult(ErrorEnum.SQLUPDATE, result.toString());
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(@RequestParam(value = "id") Long id,
			@RequestParam(value = "pid", required = false) Long pid, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "code") String code, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "url", required = false) String url, @RequestParam(value = "status", required = false) Integer status,
			@RequestParam(value = "sort", required = false) Integer sort, @RequestParam(value = "remark", required = false) String remark) {

		if(StringUtils.isBlank(code) || id == null || id < 1){
			return this.getErrorResult(ErrorEnum.NOTNULL, "id, code");
		}
		SysRole sysRole = new SysRole();
		sysRole.setId(id);
		sysRole.setName(name);
		sysRole.setCode(code);
		sysRole.setStatus(status);
		sysRole.setSort(sort);
		sysRole.setRemark(remark);
		Integer result = sysRoleService.update(sysRole);
		if(result == 1){
			return this.getResult(result);
		}
		return this.getErrorResult(ErrorEnum.SQLUPDATE, result.toString());
	}

	@RequestMapping(value = "/del")
	public @ResponseBody Object delete(@RequestParam(value = "id") Long id) {
		if(id == null || id < 1){
			return this.getResult(0);
		}
		sysRoleService.delete(id);
		return this.getResult(1);
	}

	@RequestMapping(value = "/mdel")
	public @ResponseBody Object multiDelete(@RequestParam(value = "ids") String ids) {
		if(StringUtils.isBlank(ids)){
			return this.getResult(0);
		}
		String[] idArr = ids.split(",");
		List<Long> idList = new ArrayList<Long>();
		for(int i = 0; i < idArr.length; i++){
			String id = idArr[i];
			try{
				idList.add(Long.valueOf(id));
			}catch (Exception ex){
				logger.warn("ids exist string. ({})", ids, ex);
				return this.getErrorResult(ErrorEnum.FORMAT, "ids", ids);
			}
		}
		sysRoleService.multilDelete(idList);
		return  this.getResult(idList.size());
	}
}
