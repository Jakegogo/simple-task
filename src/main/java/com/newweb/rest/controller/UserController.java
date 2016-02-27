package com.newweb.rest.controller;

import com.newweb.common.controller.AbstractController;
import com.newweb.common.service.AbstractEntityService;
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
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @Override
    public AbstractEntityService getService() {
        return (AbstractEntityService) userService;
    }



}
