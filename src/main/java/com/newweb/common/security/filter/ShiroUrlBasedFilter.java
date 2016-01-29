/*
 * Copyright (c) 2012 by XUANWU INFORMATION TECHNOLOGY CO. 
 *             All rights reserved                         
 */
package com.newweb.common.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newweb.common.security.SecurityConstance;
import com.newweb.common.security.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * Url过滤器
 */
public class ShiroUrlBasedFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws Exception {
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hresp = (HttpServletResponse) resp;
		if (SessionUtil.getCurUser() == null && !hreq.getRequestURI().endsWith("/")) {
			// Session TimeOut!
			hresp.setHeader(SecurityConstance.HEADER_ACCESS_STATE, "login");
			return false;
		}

		boolean isPermitted = false;
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			RolePermission perm = new RolePermission();
			String url = hreq.getServletPath();
			if (StringUtils.isBlank(url)) {
				url = hreq.getPathInfo();// fixed for IBM WebSphere
			}
			perm.setBaseUrl(url);
			isPermitted = subject.isPermitted(perm);
			if (!isPermitted) {
				hresp.setHeader(SecurityConstance.HEADER_ACCESS_STATE, "unauthorized");
			}
		} else {
			hresp.setHeader(SecurityConstance.HEADER_ACCESS_STATE, "login");
		}
		return isPermitted;
	}

	@Override
	protected void postHandle(ServletRequest req, ServletResponse resp) throws Exception {

	}

}
