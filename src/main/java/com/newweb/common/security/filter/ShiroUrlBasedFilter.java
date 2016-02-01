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
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
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
		PathMatchingFilterChainResolver a = null;
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			hresp.setHeader(SecurityConstance.HEADER_ACCESS_STATE, "login");
			return false;
		}

		String action = this.getHttpMethodAction(req);

		String url = hreq.getServletPath();
		if (StringUtils.isBlank(url)) {
			url = hreq.getPathInfo();// fixed for IBM WebSphere
		}
		if (url.endsWith("\\/")) {
			url = url.substring(0, url.length() - 2);
		}
		// 支持rest风格，添加user:read,user:create,user:update,user:delete
		url += ":" + action;

		if (subject.isPermitted(url)) {
			return true;
		}
		hresp.setHeader(SecurityConstance.HEADER_ACCESS_STATE, "unauthorized");
		return false;
	}

	@Override
	protected void postHandle(ServletRequest req, ServletResponse resp) throws Exception {

	}

}
