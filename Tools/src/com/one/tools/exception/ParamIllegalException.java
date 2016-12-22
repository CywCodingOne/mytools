package com.one.tools.exception;

import java.util.List;
import java.util.Map;

public class ParamIllegalException extends Exception{

	public static final String STRING = "java.lang.String";
	public static final String INT = "int";
	public static final String LONG = "long";
	public static final String FLOAT = "float";
	public static final String DOUBLE = "double";
	public static final String CHAR = "char";
	public static final String BOOLEAN = "boolean";
	public static final String ARRAY = "array";
	public static final String LIST = "java.util.List<E>";
	public static final String MAP = "java.util.Map<K,V>";
	
	public ParamIllegalException(){
		this("ParamIllegalException: \n	the param is illegal !");
	}
	
	public ParamIllegalException(String msg){
		super("" + msg);
	}
	
	public ParamIllegalException(String msg, String type){
		this("ParamIllegalException: \n	" + msg + ", \"" + type + "\" is expected !");
	}
}
