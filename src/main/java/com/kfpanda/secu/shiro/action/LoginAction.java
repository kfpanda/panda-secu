package com.kfpanda.secu.shiro.action;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kfpanda.secu.action.ErrorEnum;
import com.kfpanda.util.VerifyCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.kfpanda.secu.action.BaseAction;
import com.kfpanda.secu.action.ResultDTO;
import com.kfpanda.secu.config.SessionConfig;
import com.kfpanda.secu.shiro.MD5;
//import com.kfpanda.util.VerifyCodeUtil;

@Controller("loginAction")
@RequestMapping("/auth")
public class LoginAction extends BaseAction {
	private static final Logger logger = LogManager.getLogger(LoginAction.class);
	private static String VERIFY_CODE_ATTR = "verifyCode";

	/**
	 * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
	 */
	@RequestMapping("/verifycode/image")
	public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
		// 将验证码放到HttpSession里面
		request.getSession().setAttribute(VERIFY_CODE_ATTR, verifyCode);
		logger.debug("本次生成的验证码为[{}],已存放到HttpSession中", verifyCode);
		// 设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE,
				Color.BLACK, null);
		// 写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}

	/**
	 * 用户登录
	 */
	@ResponseBody
	@RequestMapping(value = "/login/verifycode", method = RequestMethod.POST)
	public Object loginVerifyCode(@RequestParam(value = "username") String username,
						   @RequestParam(value = "password") String password, @RequestParam(value = "captcha") String captcha,
						   @RequestParam(value = "remember", required = false, defaultValue = "2") Integer remember,
									 HttpServletRequest request) {
		// 获取HttpSession中的验证码
		String verifyCode = (String) request.getSession().getAttribute(VERIFY_CODE_ATTR);
		// 获取用户请求表单中输入的验证码
		if (StringUtils.isEmpty(captcha) || !StringUtils.equals(verifyCode, captcha.toLowerCase())) {
			request.setAttribute("message_login", "验证码不正确");
			return this.getErrorResult(ErrorEnum.VERIFYCODE, captcha);
		}
		return login(username, password, remember);
	}
	/**
	 * 用户登录
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResultDTO login(@RequestParam(value = "username") String username,
						   @RequestParam(value = "password") String password,
						   @RequestParam(value = "remember", required = false, defaultValue = "2") Integer remember) {

		UsernamePasswordToken token = new UsernamePasswordToken(username, MD5.MD5Salt(username, password));
//		token.setRememberMe(true);
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			logger.info("user({}) is not exists.", username);
			return getErrorResult(ErrorEnum.USERNOTEXIST, username);
		} catch (IncorrectCredentialsException ice) {
			logger.info("user({}) password({}) is error.", username, password);
			return getResult(ErrorEnum.PASSERROR);
		} catch (LockedAccountException lae) {
			logger.info("user({}) is lock.", username);
			return getErrorResult(ErrorEnum.ACCOUNTLOCK, username);
		} catch (ExcessiveAttemptsException eae) {
			logger.info("user({}) error more.", username);
			return getErrorResult(ErrorEnum.ERRORMORE);
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			logger.info("user({}) or password({}) error.", username, password);
			return getErrorResult(ErrorEnum.USERPASSERROR);
		}
		// 验证是否登录成功
		if (currentUser.isAuthenticated()) {
			/*currentUser.getSession().setAttribute(NutShiro.SessionKey, currentUser.getPrincipal());*/
			return getResult(currentUser.getSession().getAttribute(SessionConfig.USER_SESSION_KEY));
		} else {
			token.clear();
		}
		return getErrorResult(ErrorEnum.AUTHERROR);
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
