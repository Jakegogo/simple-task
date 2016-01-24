package com.newweb.common.util.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Random;

/**
 * Rest结果返回包装
 */
public class RestResult {

	public static Response success(Object data) {
		ResponseSuccessObj result = new ResponseSuccessObj();
		result.setData(data);
		return Response.ok().type(MediaType.APPLICATION_JSON).entity(result).build();
	}

	public static Response success() {
		ResponseSuccessObj result = new ResponseSuccessObj();
		return Response.ok().type(MediaType.APPLICATION_JSON).entity(result).build();
	}

	public static Response failure(int errorcode, String errormsg) {
		return failure(errorcode,errormsg,Status.INTERNAL_SERVER_ERROR.getStatusCode());
	}
	
	public static Response failure(int errorcode, String errormsg, int status) {
		ResponseFailureObj result = new ResponseFailureObj(errorcode, errormsg);
		return Response.status(status).type(MediaType.APPLICATION_JSON).entity(result).build();
	}


	private static int randomSed = 10000;

	public static long generateRequestId() {
		long curTime = System.currentTimeMillis();
		int sed = new Random().nextInt(randomSed) + randomSed;
		return Long.valueOf(curTime + "" + sed);
	}

}
