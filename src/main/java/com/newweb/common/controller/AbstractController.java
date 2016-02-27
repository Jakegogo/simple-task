package com.newweb.common.controller;

import com.newweb.common.service.AbstractEntityService;
import com.newweb.common.util.QueryParameters;
import com.newweb.common.util.rest.RestResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

/**
 * 抽象controller基类
 * Created by Jake on 2/27 0027.
 */
public abstract class AbstractController {

    /**
     * 获取实体service对象
     * @return
     */
    public abstract AbstractEntityService getService();

    /**
     * 分页查询
     * @param queryParam QueryParameters
     * @return
     */
    @POST
    @Path("/page")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response page(QueryParameters queryParam) {
        return RestResult.success(getService().page(queryParam));
    }


    /**
     * 获取对象
     * @param id Serializable
     * @return
     */
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response get(Serializable id) {
        return RestResult.success(getService().get(id));
    }


    /**
     * 新增/修改对象
     * @param dto Object
     * @return
     */
    @PUT
    @Produces({ MediaType.APPLICATION_JSON })
    public Response save(Object dto) {
        getService().save(dto);
        return RestResult.success();
    }

    /**
     * 删除对象
     * @param id Serializable
     * @return
     */
    @DELETE
    @Produces({ MediaType.APPLICATION_JSON })
    public Response remove(Serializable id) {
        getService().remove(id);
        return RestResult.success();
    }


}
