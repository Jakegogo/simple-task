package com.newweb.common.security;

import org.apache.shiro.authz.Permission;

/**
 * 用户请求权限
 * Created by Jake on 3/19 0019.
 */
public class RequestPermission implements Permission {

    protected String url;

    protected String method;

    private RequestPermission(){}

    public RequestPermission(String url, String method) {
        this.url = trimUrl(url);
        this.method = method;
    }


    // 修剪url
    private String trimUrl(String url) {
        if (url.endsWith("\\/")) {
            return url.substring(0, url.length() - 2);
        }
        return url;
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
