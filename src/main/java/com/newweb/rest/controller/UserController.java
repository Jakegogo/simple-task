package com.newweb.rest.controller;

import com.newweb.common.util.QueryParameters;
import com.newweb.common.util.rest.RestResult;
import com.newweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 用户控制器
 * Created by Jake on 2/21 0021.
 */
@Component
@Path("user")
public class UserController {

    @Autowired
    private UserService userService;

    @POST
    @Path("/page")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response login(QueryParameters queryParam) {
        return RestResult.success(userService.page(queryParam));
    }





}
