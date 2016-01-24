package com.newweb.common.util.rest;

/**
 * 处理失败时返回对象
 */
public class ResponseFailureObj {

	private long requestId;

	private int errorCode;

	private String errorMsg;
	
	public ResponseFailureObj(int errorCode, String errorMsg) {
		this.requestId = RestResult.generateRequestId();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;		
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
   
}
