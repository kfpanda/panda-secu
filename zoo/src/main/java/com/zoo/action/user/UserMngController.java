package com.zoo.action.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awifi.util.StringUtils;
import com.zoo.action.BaseAction;
import com.zoo.service.UserService;


@Controller
@RequestMapping(value = "/user")
public class UserMngController extends BaseAction {

	/** * 引入 UserService */
	@Resource
	private UserService userService;

	/**
	 * 用户视频收藏接口
	 * @param vid 视频id
	 * @param pmac MAC
	 * @param vtype 视频主题
	 * @return Object
	 * @author xhb 
	 */
	@RequestMapping(value = "/collect")
	@ResponseBody
	public Object index(@RequestParam(value = "vid", required = false) Long vid,
			@RequestParam(value = "pmac", required = false) String pmac,
			@RequestParam(value = "vtype", required = false) String vtype) {
		//返回登录页面
		if(StringUtils.isEmpty(pmac)){
			return getResult(-1, "MAC不可为空");
		}
		if(vid == null){
			return getResult(-1, "视频id不可为空");
		}
		String ret = userService.userVidioCollect(vid, pmac, vtype);
		if("success".equals(ret)){
			return getResult(1, ret);
		}
		return getResult(-1, ret);
	}

}
