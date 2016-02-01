package com.newweb.common.security;

import com.newweb.domain.security.Permission;
import com.newweb.domain.user.User;
import com.newweb.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


/**
 * Default DB Realm
 */
public class ShiroDBRealm extends AuthorizingRealm {

	@Autowired
	protected UserService userService;

	@Override
	@SuppressWarnings("unchecked")
	public boolean isPermitted(PrincipalCollection principals, String permission) {
		SimpleAuthorizationInfo info = (SimpleAuthorizationInfo) getAuthorizationInfo(principals);
		if (info.getStringPermissions().contains(permission)) {
			return true;
		}

		Set<String> permissions = info.getStringPermissions();
		for (String permiss : permissions) {
			if (permission.startsWith(permiss)) {
				return true;
			}
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean isPermitted(PrincipalCollection principals, org.apache.shiro.authz.Permission permission) {
		SimpleAuthorizationInfo info = (SimpleAuthorizationInfo) getAuthorizationInfo(principals);
		Permission targetPerm = (Permission) permission;
		return isPermitted(principals, targetPerm.getPermissionUrl());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		checkNotNull(principals, "PrincipalCollection method argument cannot be null.");
		String username = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.findRoles(username));
		authorizationInfo.setStringPermissions(userService.findPermissions(username));
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

	private void checkNotNull(Object reference, String message) {
		if (reference == null) {
			throw new AuthenticationException(message);
		}
	}

}
