package com.newweb.common.security;

import org.apache.shiro.authz.Permission;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 访问权限
 * 支持rest风格，添加user:read,user:create,user:update,user:delete
 * Created by Jake on 2/24 0024.
 */
public class PermissionParttern implements Permission {

    private String url;

    private String method;

    private transient Set<String> methods;

    public PermissionParttern(){}

    /**
     * 获取rest请求方法集合
     * @return Set<String>
     */
    public Set<String> getMethodSet() {
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

        return this.methods = Collections.unmodifiableSet(methods);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "PermissionParttern{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

}
