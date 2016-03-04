package com.kfpanda.secu.shiro.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kfpanda.secu.config.SessionConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfpanda.secu.action.BaseAction;
import com.kfpanda.secu.action.ResultDTO;
import com.kfpanda.secu.bean.sys.SysUser;

@Controller
public class ResourceCodeAuthAction extends BaseAction{
	/**
	 * 资源验证
	 */
    @ResponseBody
	@RequestMapping(value = "/resource", method = RequestMethod.POST)
	public ResultDTO resource(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		//获取session中的用户信息
		Object user_session = request.getSession().getAttribute(SessionConfig.USER_SESSION_KEY);
		if(user_session == null){
			return null;
		}
		SysUser sysUser = (SysUser) user_session;
		//获取token
		UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUserName(), sysUser.getPassword());
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
		// 验证是否登录成功
		if (currentUser.isAuthenticated()) {
			System.out.println(request.getParameter("key"));
			ret.put("auth_resource", currentUser.isPermitted(request.getParameter("key")));
			//放入用户信息到session
//			request.getSession().setAttribute(SessionConfig.USER_SESSION_KEY, value)
		} else {
			token.clear();
		}
		return getResult(ret);
	}
	
}
