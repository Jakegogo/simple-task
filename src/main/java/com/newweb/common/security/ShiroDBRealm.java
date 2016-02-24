package com.newweb.common.security;

import com.newweb.domain.user.User;
import com.newweb.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


/**
 * Default DB Realm
 */
public class ShiroDBRealm extends AuthorizingRealm {

	@Autowired
	protected UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		checkNotNull(principals, "PrincipalCollection method argument cannot be null.");
		String username = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.findRoles(username));
		authorizationInfo.setObjectPermissions(userService.findPermissions(username));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		checkNotNull(username, "Null username are not allowed by this realm.");
		User user = userService.findByUsername(username);
		if(user == null) {
			throw new UnknownAccountException();//没找到帐号
		}
		if(Boolean.TRUE.equals(user.getUserLocked())) {
			throw new LockedAccountException(); //帐号锁定
		}
		// 交给 AuthenticatingRealm 使用 CredentialsMatcher 进行密码匹配，如果觉得人家
		// 的不好可以在此判断或自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getUserName(), //用户名
				user.getUserPassword(), //密码
				getName() //realm name
		);
		return authenticationInfo;
	}

	private PatternMatcher pathMatcher = new AntPathMatcher();

	public PatternMatcher getPathMatcher() {
		return this.pathMatcher;
	}


	/**
	 * 匹配路径
	 * @param pattern 表达式
	 * @param path 路径
	 * @return
	 */
	protected boolean pathMatches(String pattern, String path) {
		PatternMatcher pathMatcher = this.getPathMatcher();
		return pathMatcher.matches(pattern, path);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {
		RequestPermission requestPermission = (RequestPermission) permission;
		SimpleAuthorizationInfo info = (SimpleAuthorizationInfo) getAuthorizationInfo(principals);
		if (info.getObjectPermissions().contains(requestPermission)) {
			return true;
		}

		Set<Permission> permissions = info.getObjectPermissions();
		for (Permission permiss : permissions) {
			RequestPermission p = (RequestPermission) permiss;
			if (pathMatches(p.getUrl(), requestPermission.getUrl()) && p.matchMethod(requestPermission)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检查空
	 * @param reference 对象
	 * @param message 抛出异常的提示
	 */
	private void checkNotNull(Object reference, String message) {
		if (reference == null) {
			throw new AuthenticationException(message);
		}
	}

}
