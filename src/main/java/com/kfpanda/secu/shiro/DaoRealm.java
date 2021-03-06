package com.kfpanda.secu.shiro;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import com.kfpanda.core.json.JsonUtils;
import com.kfpanda.secu.config.SessionConfig;
import com.kfpanda.secu.mapper.sys.SysUserResourceMapper;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Repository;

import com.kfpanda.secu.bean.sys.SysResource;
import com.kfpanda.secu.bean.sys.SysRole;
import com.kfpanda.secu.bean.sys.SysUser;
import com.kfpanda.secu.mapper.sys.SysUserMapper;
import com.kfpanda.util.StringUtils;

@Repository("daoRealm")
public class DaoRealm extends AuthorizingRealm{
	private static final Logger logger = LogManager.getLogger(DaoRealm.class);
	
	@Resource
	private SysUserMapper sysUserMapper;
	@Resource
	private SysUserResourceMapper sysUserResourceMapper;
	
	 /** 
     * 为当前登录的Subject授予角色和权限 
     * 本例中该方法的调用时机为需授权资源被访问时
     * 并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
     * 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
     * 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
     */  
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
		String userName = (String) super.getAvailablePrincipal(principals);
		List<String> roleList = new ArrayList<String>();
		List<String> permissionList = new ArrayList<String>();
		// 从数据库中获取当前登录用户的详细信息
		List<SysUser> sysUserList = sysUserMapper.findURR(userName);
		for (SysUser sysUser : sysUserList) {
			List<SysResource> resources = sysUserResourceMapper.findResourcesByUid(sysUser.getId());
			if(resources != null){
				for (SysResource res : resources){
					if (StringUtils.isNotEmpty(res.getCode())) {
						permissionList.add(res.getCode());
					}
				}
			}
			if (null != sysUser) {
				// 实体类User中包含有用户角色的实体类信息
				if (null != sysUser.getRoles() && sysUser.getRoles().size() > 0) {
					// 获取当前登录用户的角色
					for (SysRole role : sysUser.getRoles()) {
						roleList.add(role.getName());
						// 实体类Role中包含有角色权限的实体类信息
						if (null != role.getResources() && role.getResources().size() > 0) {
							// 获取权限
							for (SysResource resource : role.getResources()) {
								if (StringUtils.isNotEmpty(resource.getCode())) {
									permissionList.add(resource.getCode());
								}
							}
						}
					}
				}
			} else {
				throw new AuthorizationException();
			}
		}
		// 为当前用户设置角色和权限
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		simpleAuthorInfo.addRoles(roleList);
		simpleAuthorInfo.addStringPermissions(permissionList);
//		logger.debug("current user rolelist:(", JsonUtils.toJsonString(roleList), "); permissionlist:(", JsonUtils.toJsonString(permissionList),")");

		/*
		 * SimpleAuthorizationInfo simpleAuthorInfo = new
		 * SimpleAuthorizationInfo(); //实际中可能会像上面注释的那样从数据库取得
		 * if(null!=currentUsername && "jadyer".equals(currentUsername)){
		 * //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
		 * simpleAuthorInfo.addRole("admin"); //添加权限
		 * simpleAuthorInfo.addStringPermission("admin:manage");
		 * System.out.println("已为用户[jadyer]赋予了[admin]角色和[admin:manage]权限");
		 * return simpleAuthorInfo; }else if(null!=currentUsername &&
		 * "玄玉".equals(currentUsername)){ System.out.println("当前用户[玄玉]无授权");
		 * return simpleAuthorInfo; }
		 */
		// 若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址
		// 详见applicationContext.xml中的<bean id="shiroFilter">的配置
		return simpleAuthorInfo;
	}
  
      
    /** 
     * 验证当前登录的Subject
     * 本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */
    @Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		// 获取基于用户名和密码的令牌
		// 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
		// 两个token的引用都是一样的,本例中是org.apache.shiro.authc.UsernamePasswordToken@33799a1e
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		logger.info("验证当前Subject时获取到token:"
				+ ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
		
		SysUser sysUser = sysUserMapper.findByUserName(token.getUsername());

		if (null != sysUser) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(sysUser.getUserName(), sysUser.getPassword(),
					sysUser.getNkName());
			//隐藏密码
			sysUser.setPassword(null);
			this.setSession(SessionConfig.USER_SESSION_KEY, sysUser);
			return authcInfo;
		}
		// 没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
		return null;
	}
     
      
    /** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession();
            logger.info("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }
    
}
