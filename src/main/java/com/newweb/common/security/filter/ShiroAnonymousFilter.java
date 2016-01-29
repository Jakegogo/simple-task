package com.newweb.common.security.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.newweb.common.security.SecurityConstance;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;

/**
 * 匿名过滤器
 */
public class ShiroAnonymousFilter extends PathMatchingFilter {

	@Override
	protected boolean preHandle(ServletRequest req, ServletResponse resp)
			throws Exception {
		HttpServletResponse hresp = (HttpServletResponse)resp;
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated())
			return true;
		hresp.setHeader(SecurityConstance.HEADER_ACCESS_STATE, "login");
		return true;
	}
	
}
