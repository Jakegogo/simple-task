package com.newweb.rest.controller;

import com.newweb.common.util.rest.RestResult;
import com.newweb.constance.ErrorCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * 登录控制器
 * Created by Administrator on 2016-2-1.
 */
@Path("/")
@Component
public class LoginController {

    @POST
    @Path("login")
    public Response login(@FormParam("username") String username, @FormParam("password") String password) {
        String error;
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            return RestResult.success("success");
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独 catch 处理
            error = "其他错误：" + e.getMessage();
        }
        return RestResult.failure(ErrorCode.LOGIN_FAILURE, error);
    }

    @GET
    @Path("logout")
    public Response logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return RestResult.success();
        } catch (Exception e) {
            return RestResult.failure(ErrorCode.LOGIN_FAILURE, e.getMessage());
        }
    }

}
