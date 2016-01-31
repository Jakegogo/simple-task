package com.newweb.controller;

import com.newweb.common.exception.EbaseRuntimeException;
import com.newweb.common.util.rest.RestResult;
import com.newweb.persist.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Jake on 1/24 0024.
 */
@Component
@Path("testcontroller")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GET
    public Response getdefined(){
        return RestResult.success(userMapper.get("312312312"));
    }

    @GET
    @Path("/{id}")
    public Response getdefined(@PathParam("id") Integer id){
        if(id==1) {
            throw new EbaseRuntimeException("异常测试", null);
        }
        return RestResult.success();
    }

}
