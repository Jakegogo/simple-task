/*
 * Copyright (c) 2012 by XUANWU INFORMATION TECHNOLOGY CO. 
 *             All rights reserved                         
 */
package com.newweb.common.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newweb.common.security.RequestPermission;
import com.newweb.common.security.SecurityConstance;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;

/**
 * Url过滤器
 */
public class ShiroUrlBasedFilter extends HttpMethodPermissionFilter {

	@Override
	public boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) {
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hresp = (HttpServletResponse) resp;
//		if (SessionUtil.getCurUser() == null && !hreq.getRequestURI().endsWith("/")) {
//			// Session TimeOut!
//			hresp.setHeader(SecurityConstance.HEADER_ACCESS_STATE, "login");
//			return false;
//		}
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			hresp.setHeader(SecurityConstance.HEADER_ACCESS_STATE, "login");
			return false;
		}


		String url = hreq.getServletPath();
		if (StringUtils.isBlank(url)) {
			url = hreq.getPathInfo();// fixed for IBM WebSphere
		}

		String action = this.getHttpMethodAction(req);

		RequestPermission requestPermission = new RequestPermission(url, action);
		if (subject.isPermitted(requestPermission)) {
			return true;
		}

		hresp.setHeader(SecurityConstance.HEADER_ACCESS_STATE, "unauthorized");
		return false;
	}

	@Override
	protected void postHandle(ServletRequest req, ServletResponse resp) throws Exception {

	}

}
