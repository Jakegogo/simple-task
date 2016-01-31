package com.newweb.common.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Description Default DB Realm
 * @author <a href="mailto:liushuaiying@139130.net">Shuaiying.Liu</a>
 * @Data 2012-9-5
 * @Version 1.0.0
 */
public class ShiroDBRealm extends AuthorizingRealm {


	@Override
	@SuppressWarnings("unchecked")
	public boolean isPermitted(PrincipalCollection principals, String permission) {
		ShiroAuthorizationInfo info = (ShiroAuthorizationInfo) getAuthorizationInfo(principals);
		if (info.getPermission(permission) != null) {
			return true;
		}

//		List<String> permissions = (List<String>) SessionUtil
//				.getSessionAttribute(AttributeConfig.bindSessionPermissions);
//		for (String permiss : permissions) {
//			if (permission.startsWith(permiss)) {
//				return true;
//			}
//		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {
		ShiroAuthorizationInfo info = (ShiroAuthorizationInfo) getAuthorizationInfo(principals);
//		RolePermission targetPerm = (RolePermission) permission;
//		RolePermission perm = info.getPermission(targetPerm.getBaseUrl());
//		if (perm != null) {
//			targetPerm.setPermissionId(perm.getPermissionId());
//			return true;
//		}
//
//		if (targetPerm.getBaseUrl().startsWith("/files/download/")) {// 下载目录对登录用户开放
//			return true;
//		}
//
//		List<String> permissions = (List<String>) SessionUtil
//				.getSessionAttribute(AttributeConfig.bindSessionPermissions);
//		for (String permiss : permissions) {
//			if (targetPerm.getBaseUrl().startsWith(permiss)) {
//				return true;
//			}
//		}
		return false;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		checkNotNull(principals, "PrincipalCollection method argument cannot be null.");
		ShiroAuthorizationInfo info = new ShiroAuthorizationInfo();
//		info.addPermission(rootPathPerm); // root path "/"
//		info.addPermission(mainPerm); // main page
//		info.addPermission(homePerm);
//		info.addPermission(commonPerm);
		// TODO add other permission
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		checkNotNull(username, "Null username are not allowed by this realm.");
//		AdminDTO adminDTO = adminService.getByUserName(username);
//		String password = "";
//		if (adminDTO == null) {
//			throw new UnknownAccountException("User is not exist!");
//		}
//		if (adminDTO.getState() != 0) {
//			throw new LockedAccountException("User is locked!");
//		}
//
//		SessionUtil.setCurUser(adminDTO);
//		password = adminDTO.getPassword();
//
//		List<com.xuanwu.xcloud.pae.domain.model.system.Permission> ls = permissionService
//				.findPermissionsByUserId(adminDTO.getId());
//		List<String> permissions = new ArrayList<String>();
//		for (com.xuanwu.xcloud.pae.domain.model.system.Permission per : ls) {
//			String controller = per.getController();
//			if (StringUtils.isNotBlank(controller)) {
//				permissions.add(controller);
//			}
//		}
//
//		SessionUtil.setSessionAttribute(AttributeConfig.bindSessionPermissions, permissions);

		// TODO check user from DB
		return new SimpleAuthenticationInfo(username, "password", getName());
	}

	private void checkNotNull(Object reference, String message) {
		if (reference == null) {
			throw new AuthenticationException(message);
		}
	}

}
