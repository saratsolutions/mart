package com.mart.rest.exception;

@SuppressWarnings("serial")
public class MartServiceException extends RuntimeException {
	private String errorCode;
	private String errorDesc;

	public MartServiceException() {
	}

	public MartServiceException(String errorCode, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

}
