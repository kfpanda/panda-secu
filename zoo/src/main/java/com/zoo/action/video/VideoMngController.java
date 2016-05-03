package com.zoo.action.video;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awifi.core.page.Page;
import com.util.page.PageContext;
import com.zoo.action.BaseAction;
import com.zoo.service.VideoService;


@Controller
@RequestMapping(value = "/video")
public class VideoMngController extends BaseAction {

	/** * 引入 UserService */
	@Resource
	private VideoService videoService;

	/**
	 * 视频列表
	 * @param zbname 主播名
	 * @param vname 视频名称
	 * @param type 视频类型
	 * @return Object
	 * @author xhb 
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object videoList(@RequestParam(value = "zbname", required = false) String zbname,
			@RequestParam(value = "vname", required = false) String vname,
			@RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "curpage", required = false) Integer curPage,
            @RequestParam(value = "pagesize", required = false) Integer pageSize) {
		Map<String, String> ret = videoService.vidioList(zbname, vname, type);
        if(curPage == null){
        	curPage = 1;
        }
        if(pageSize==null){
        	pageSize=10;
        }
        Page page= PageContext.initContext(pageSize, curPage);
        page.setPagination(true);
        page.setPageSize(pageSize);
		page.setCurPage(curPage);
		if("OK".equals(ret.get("type"))){
			return getResult(1, ret.get("ret"),page);
		}
		return getResult(-1, ret.get("ret"));
	}

}
