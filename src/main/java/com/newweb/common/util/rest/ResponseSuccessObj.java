package com.newweb.common.util.rest;

/**
 * 处理成功时返回对象
 */
public class ResponseSuccessObj {

	private long requestId;

	private Object data;

	public ResponseSuccessObj() {
		this.requestId = RestResult.generateRequestId();
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
