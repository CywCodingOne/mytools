package com.one.tools.exception;

public class paraValidateException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1680084270984257899L;

	private String code = "";
	private String message = "";
	
	public paraValidateException(){
		
	}
	
	public paraValidateException(String code){
		this.code = code;
		this.message = ExceptionUtils.getErrorMsgByCode(code);
	}
	
	public paraValidateException(String code, String message){
		this.code = code;
		this.message = message;
	}
	
	public paraValidateException(String code, String message, Throwable cause){
		super(cause);
		this.code = code;
		this.message = message;
	}
	
	public paraValidateException(String code, Throwable cause){
		super(cause);
		this.code = code;
		this.message = ExceptionUtils.getErrorMsgByCode(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
