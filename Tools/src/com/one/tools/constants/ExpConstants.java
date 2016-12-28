package com.one.tools.constants;

public class ExpConstants {
	
	public static final String PARAM_CHECK_SUCCESS_CODE = "20000";
	public static final String PARAM_CHECK_SUCCESS_MSG = "类校验通过";
	
	public static final String CLASS_CHECK_ERROR = "20001";
	public static final String CLASS_CHECK_MSG = "类校验出错";
	
	public static final String FIELD_CHECK_ERROR = "20002";
	public static final String FIELD_CHECK_MSG = "字段校验出错";
	
	public static final String NONE_REQUIRED_FIELD_ERROR = "20003";
	public static final String NONE_REQURED_FIELD_MSG = "缺少必填字段";
	
	public static final String OVER_LENGTH_FIELD_ERROR = "20004";
	public static final String OVER_LENGTH_FIELD_MSG = "字段长度不通过";
	
	public static final String EXPRESSION_MATCH_ERROR = "20005";
	public static final String EXPRESSION_MATCH_MSG = "正则表达式校验失败";
	
	public static final String DATATYPE_MATCH_ERROR = "20006";
	public static final String DATATYPE_MATCH_MSG = "数据类型校验失败";
	
	public static final String DATATYPE_NOT_EXIST_ERROR = "20007";
	public static final String DATATYPE_NOT_EXIST_MSG = "指定的数据类型不存在或不合法或不在可校验范围之内";
	
}
