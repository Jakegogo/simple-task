package com.newweb.common.security;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;

import java.util.Set;
import java.util.TreeSet;

/**
 * 访问权限
 * 支持rest风格，添加user:read,user:create,user:update,user:delete
 * Created by Jake on 2/24 0024.
 */
public class RequestPermission implements Permission{

    private String url;

    private String method;

    private transient Set<String> methods;

    public RequestPermission(){}

    public RequestPermission(String url, String method) {
        this.url = url;
        this.method = method;
        trimUrls();
    }


    // 修剪url
    private void trimUrls() {
        if (url.endsWith("\\/")) {
            url = url.substring(0, url.length() - 2);
        }
    }

    private Set<String> getMethodSet() {
        if (this.methods != null) {
            return this.methods;
        }

        if (this.method == null || this.method.isEmpty()) {
            return this.methods = new TreeSet<String>();
        }

        Set methods = new TreeSet<String>();
        String[] ms = this.method.split(";");
        for (String m : ms) {
            methods.add(m);
        }

        return this.methods = methods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestPermission)) return false;

        RequestPermission that = (RequestPermission) o;

        if (!url.equals(that.url)) return false;
        return !(method != null ? !method.equals(that.method) : that.method != null);
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
     * @param that RequestPermission
     * @return
     */
    public boolean matchMethod(RequestPermission that) {
        if (method == null) {
            return false;
        }
        if (getMethodSet().contains(ALL_METHOD_ALLOW)
                || that.getMethodSet().contains(ALL_METHOD_ALLOW)) {
            return true;
        }
        return method.equals(that.method);
    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }
}
