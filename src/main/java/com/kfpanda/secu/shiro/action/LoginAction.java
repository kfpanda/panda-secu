package com.kfpanda.secu.shiro.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.kfpanda.secu.action.BaseAction;
import com.kfpanda.secu.action.ResultDTO;
import com.kfpanda.secu.bean.sys.SysUser;
import com.kfpanda.secu.config.SessionConfig;
import com.util.common.safe.MD5;
//import com.kfpanda.util.VerifyCodeUtil;

@Controller("loginAction")
@RequestMapping("/auth")
public class LoginAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

	/**
	 * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
	 */
/*	@RequestMapping("/verifycode/image")
	public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
		// 将验证码放到HttpSession里面
		request.getSession().setAttribute("verifyCode", verifyCode);
		System.out.println("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
		// 设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE,
				Color.BLACK, null);
		// 写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}*/

	/**
	 * 用户登录
	 */
    @ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResultDTO login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "remember" ,required = false ,defaultValue = "2") Integer remember) {
		//String resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX + "/";
		// 获取HttpSession中的验证码
		/*String verifyCode = (String) request.getSession().getAttribute("verifyCode");
		// 获取用户请求表单中输入的验证码
		String submitCode = WebUtils.getCleanParam(request, "verifyCode");
		System.out.println("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");
		if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(verifyCode, submitCode.toLowerCase())) {
			request.setAttribute("message_login", "验证码不正确");
			return resultPageURL;
		}*/
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, MD5.MD5Salt(username, password));
		token.setRememberMe(true);
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			logger.info("user(", username, ") is not exists.");
			return getResult(-2, "用户帐号不存在.");
		} catch (IncorrectCredentialsException ice) {
			logger.info("user(", username, ") password(", password, ") is error.");
			return getResult(-3, "用户密码不正确.");
		} catch (LockedAccountException lae) {
			logger.info("user(", username, ") is lock.");
			return getResult(-4, "用户账户锁定.");
		} catch (ExcessiveAttemptsException eae) {
			logger.info("user(", username, ") error more.");
			return getResult(-5, "错误次数过多.");
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			logger.info("user(", username, ") or password(", password, ") error.");
			return getResult(-6, "用户名或密码不正确.");
		}
		// 验证是否登录成功
		if (currentUser.isAuthenticated()) {
			return getResult(currentUser.getSession().getAttribute(SessionConfig.USER_SESSION_KEY));
		} else {
			token.clear();
		}
		return getResult(-1, "认证错误.");
	}

	/**
	 * 用户登出
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityUtils.getSubject().logout();
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
	}
	
}
