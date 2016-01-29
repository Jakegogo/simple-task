/*   
 * Copyright (c) 2015  by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved  
 */
package com.newweb.common.security;

import org.apache.shiro.SecurityUtils;

/**
 * Session工具类
 * @author Jake
 */
public class SessionUtil {

	/**
	 * 获取session值
	 * @param key KEY
	 * @return
	 */
	public static Object getSessionAttribute(String key) {
		return SecurityUtils.getSubject().getSession().getAttribute(key);
	}

	/**
	 * 设置session值
	 * @param key KEY
	 * @param value Value
	 */
	public static void setSessionAttribute(String key, Object value) {
		SecurityUtils.getSubject().getSession().setAttribute(key, value);
	}

	/**
	 * 移除session值
	 * @param key KEY
	 */
	public static void removeSessionAttribute(String key) {
		SecurityUtils.getSubject().getSession().removeAttribute(key);
	}

	/**
	 * 设置当前用户
	 * @param userSessionBean UserSessionBean
	 */
	protected static void setCurUser(UserSessionBean userSessionBean) {
		SecurityUtils.getSubject().getSession()
				.setAttribute(SecurityConstance.CURRENT_USER, userSessionBean);
	}

	/**
	 * 获取当前用户
	 * @return
	 */
	public static UserSessionBean getCurUser() {
		return (UserSessionBean) SecurityUtils.getSubject().getSession(true)
				.getAttribute(SecurityConstance.CURRENT_USER);
	}
}
