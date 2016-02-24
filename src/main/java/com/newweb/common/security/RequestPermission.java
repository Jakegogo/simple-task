package com.newweb.common.security;

import org.apache.shiro.authz.Permission;

/**
 * 访问权限
 * 支持rest风格，添加user:read,user:create,user:update,user:delete
 * Created by Jake on 2/24 0024.
 */
public class RequestPermission implements Permission, Comparable {

    private String url;

    private String method;

    private static String ALL_METHOD_ALLOW = "all";

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestPermission)) return false;

        RequestPermission that = (RequestPermission) o;

        if (!url.equals(that.url)) return false;
        return matchMethod(that);

    }

    /**
     * 匹配方法
     * @param that RequestPermission
     * @return
     */
    public boolean matchMethod(RequestPermission that) {
        if (ALL_METHOD_ALLOW.equals(method) || ALL_METHOD_ALLOW.equals(that.method)) {
            return true;
        }
        if (method == null) {
            return false;
        }
        return method.equals(that.method);
    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (!(o instanceof RequestPermission)) return -1;

        RequestPermission that = (RequestPermission) o;

        int cmp = url.compareTo(that.url);
        if (cmp != 0) {
            return cmp;
        }
        if (method == null) {
            if (this.method == null) return 0;
            return -1;
        }
        return method.compareTo(that.method);
    }

    @Override
    public String toString() {
        return "{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
