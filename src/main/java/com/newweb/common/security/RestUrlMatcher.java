package com.newweb.common.security;

import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;

/**
 * REST风格路径匹配
 * Created by Administrator on 2016-3-17.
 */
public class RestUrlMatcher {

    private static String ALL_METHOD_ALLOW = "all";

    private static PatternMatcher pathMatcher = new AntPathMatcher();

    public PatternMatcher getPathMatcher() {
        return this.pathMatcher;
    }

    /**
     * 判断权限规则是否匹配
     * @param parttern PermissionParttern 权限规则
     * @param requestPermission PermissionParttern 请求权限
     * @return
     */
    public boolean matches(PermissionParttern parttern, RequestPermission requestPermission) {
        return pathMatches(parttern.getUrl(), requestPermission.getUrl()) &&
                methodMatches(parttern, requestPermission);
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

    /**
     * 匹配方法
     * @param parttern
     * @param requestPermission
     * @return
     */
    public boolean methodMatches(PermissionParttern parttern, RequestPermission requestPermission) {
        if (parttern.getMethodSet() == null) {
            return false;
        }
        if (parttern.getMethodSet().contains(ALL_METHOD_ALLOW)) {
            return true;
        }
        return parttern.getMethodSet().equals(requestPermission.getMethod());
    }

}
