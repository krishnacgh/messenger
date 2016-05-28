package com.appspot.krishnacgh.messenger.model;

public class ErrorMessage {
	
	private String errorName;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(String errorName, int errorCode, String documentation) {
		super();
		this.errorName = errorName;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	

}
