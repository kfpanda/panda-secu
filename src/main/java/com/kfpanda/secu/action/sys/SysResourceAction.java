package com.kfpanda.secu.action.sys;
import java.io.File;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.kfpanda.core.page.Pageable;
import com.kfpanda.secu.action.ErrorEnum;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.kfpanda.secu.action.BaseAction;
import com.kfpanda.secu.bean.sys.SysResource;
import com.kfpanda.secu.service.sys.SysResourceService;
import com.kfpanda.util.DateUtil;

/**
 * 资源管理类。
 * @author kfpanda
 * @date 2016/7/7
 */
@Controller
@RequestMapping("/resource")
public class SysResourceAction extends BaseAction{
	private static final Logger logger = LogManager.getLogger(SysResourceAction.class);

	/** 权限service **/
	@Autowired
	private SysResourceService sysResourceService;

	/**
	 * 分页查询。
	 * @return Object
	 * @author kfpanda
	 * @date 2016年11月15日下午12:31:55
	 */
	@RequiresPermissions("resource:find")
	@RequestMapping(value = "/find")
	public @ResponseBody Object pageFind(
			@RequestParam(value = "pid", required = false) Long pid, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "code", required = false) String code, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "url", required = false) String url, @RequestParam(value = "status", required = false) Integer status,
			@ModelAttribute Pageable page) {

		List<SysResource> sysResources = sysResourceService.pageFind(pid, name, code, type, url, status, page);
		return this.getResult(sysResources, page);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@RequiresPermissions(value={"resource:add"})
	public @ResponseBody Object add(
			@RequestParam(value = "pid", required = false) Long pid, @RequestParam(value = "name") String name,
			@RequestParam(value = "code") String code, @RequestParam(value = "type") String type,
			@RequestParam(value = "url", required = false) String url, @RequestParam(value = "status") Integer status,
			@RequestParam(value = "sort", required = false) Integer sort, @RequestParam(value = "remark", required = false) String remark) {

		if(StringUtils.isBlank(name) || StringUtils.isBlank(code) || StringUtils.isBlank(type) || status < 0){
			return this.getErrorResult(ErrorEnum.NOTNULL, "name, code, type, status");
		}
		SysResource sysResource = new SysResource();
		sysResource.setPid(pid);
		sysResource.setName(name);
		sysResource.setCode(code);
		sysResource.setType(type);
		sysResource.setUrl(url);
		sysResource.setStatus(status);
		sysResource.setSort(sort);
		sysResource.setRemark(remark);
		Integer result = sysResourceService.save(sysResource);
		if(result == 1){
			return this.getResult();
		}
		return this.getErrorResult(ErrorEnum.SQLUPDATE, result.toString());
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@RequiresPermissions(value={"resource:update"})
	public @ResponseBody Object update(@RequestParam(value = "id") Long id,
			@RequestParam(value = "pid", required = false) Long pid, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "code") String code, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "url", required = false) String url, @RequestParam(value = "status", required = false) Integer status,
			@RequestParam(value = "sort", required = false) Integer sort, @RequestParam(value = "remark", required = false) String remark) {

		if(StringUtils.isBlank(code) || id == null || id < 1){
			return this.getErrorResult(ErrorEnum.NOTNULL, "id, code");
		}
		SysResource sysResource = new SysResource();
		sysResource.setId(id);
		sysResource.setPid(pid);
		sysResource.setName(name);
		sysResource.setCode(code);
		sysResource.setType(type);
		sysResource.setUrl(url);
		sysResource.setStatus(status);
		sysResource.setSort(sort);
		sysResource.setRemark(remark);
		Integer result = sysResourceService.update(sysResource);
		if(result == 1){
			return this.getResult(result);
		}
		return this.getErrorResult(ErrorEnum.SQLUPDATE, result.toString());
	}

	@RequestMapping(value = "/del")
	@RequiresPermissions(value={"resource:del"})
	public @ResponseBody Object delete(@RequestParam(value = "id") Long id) {
		if(id == null || id < 1){
			return this.getResult(0);
		}
		sysResourceService.delete(id);
		return this.getResult(1);
	}

	@RequestMapping(value = "/mdel")
	@RequiresPermissions(value={"resource:mdel"})
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
		sysResourceService.multilDelete(idList);
		return  this.getResult(idList.size());
	}

    @RequestMapping(value = "/export")
	@RequiresPermissions(value={"resource:export"})
    public @ResponseBody Object exportExcel(@RequestParam(value = "pid", required = false) Long pid, @RequestParam(value = "name", required = false) String name,
							  @RequestParam(value = "code") String code, @RequestParam(value = "type") String type,
							  @RequestParam(value = "url", required = false) String url, @RequestParam(value = "status") Integer status,
							  @RequestParam(value = "sort", required = false) Integer sort, @RequestParam(value = "remark", required = false) String remark,
							  HttpServletRequest request){

        // 查询list集合
        List<SysResource> list = null;
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
            map.put("pid",  list.get(i).getPid());
            map.put("name",  list.get(i).getName());
            map.put("code",  list.get(i).getCode());
            map.put("type",  list.get(i).getType());
            map.put("url",  list.get(i).getUrl());
            map.put("order",  list.get(i).getSort());
            map.put("status",  list.get(i).getStatus());
            map.put("remark",  list.get(i).getRemark());
            map.put("createtime",  list.get(i).getCreateTime());
            finalList.add(map);
        }
		try {
			/*if (cola.machine.util.ExcelUtil.getExcelFile(finalList, fileName, colTitle) != null) {
				return this.getResult();
			}*/

			return new ResponseEntity<byte[]>(
					FileUtils.readFileToByteArray(new File(fileName)), headers,
					HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.getResult(0, "数据为空，导出失败");

    }

	    @RequestMapping(value = "/import")
    public void importExcel(){

    }
}
