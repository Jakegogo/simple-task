package com.newweb.controller;

import com.newweb.common.exception.EbaseRuntimeException;
import com.newweb.common.util.rest.RestResult;
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

    @GET
    public Response getdefined(){
        return RestResult.success();
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
