package com.newweb.common.security;

import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;

import java.util.Set;

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





}
