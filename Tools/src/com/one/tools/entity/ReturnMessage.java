package com.one.tools.entity;

public class ReturnMessage implements IMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3508489915439957007L;

	private String returnCode;
	private String errorMessage;
	
	public ReturnMessage(){
		
	}
	
	public ReturnMessage(String returnCode){
		this.returnCode = returnCode;
	}
	
	public ReturnMessage(String returnCode, String errorMessage){
		this.returnCode = returnCode;
		this.errorMessage = errorMessage;
	}
	
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("{returnMessage:[");
		builder.append("returnCode=" + this.returnCode + ";");
		builder.append("errorMessage=" + this.errorMessage + "]}");
		
		return builder.toString();
	}
}
