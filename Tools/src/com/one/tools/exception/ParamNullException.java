package com.one.tools.exception;

/**
 * @description 参数为空异常类
 * @author one-coder
 * @date 2016年10月28日 上午1:47:34
 */
public class ParamNullException extends Exception{
	public ParamNullException() {
		// TODO Auto-generated constructor stub
		this("	ParamNullException: null param is illegal !");
	}
	
	public ParamNullException(String msg){
		super(msg);
	}
}
