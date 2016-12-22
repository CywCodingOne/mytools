package com.one.tools.validate;

import java.io.Serializable;

public class CheckObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8057928128888184036L;

	/**
     * 是否必填校验
     */
    private String isRequired;

    /**
     * 必填校验错误提示
     */
    private String requiredMsg;
    
    /**
     * 长度校验
     */
    private String maxlength;
    
    /**
     * 长度校验错误提示
     */
    private String maxlengthMsg;
    
    /**
     * 正则表达式校验
     */
    private String expression;

    /**
     * 正则表达式校验错误提示
     */
    private String expressionMsg;

    /**
     * 数据类型校验
     */
    private String datatype;
    
    /**
     * 数据类型校验错误提示
     */
    private String datatypeMsg;
    
    /**
     * 引用类型校验
     */
    private String refAlias;
    
    /**
     * 引用类型校验错误提示（保留属性，暂时不用）
     */
    private String refAliasMsg;
    
    /**
     * 当字段为 '引用型校验项' 时，该属性指定其校验属性是否首字母大写
     */
    private boolean abLetterUpcase;
    
    public CheckObj() {
		// TODO Auto-generated constructor stub
    	this.abLetterUpcase = false;
	}
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	StringBuilder builder = new StringBuilder("");
    	
    	builder.append("{checkObj:[");
    	builder.append("isRequired=" + this.isRequired + ";");
    	builder.append("requiredMsg=" + this.requiredMsg + ";");
    	builder.append("datatype=" + this.datatype + ";");
    	builder.append("datatypeMsg=" + this.datatypeMsg + ";");
    	builder.append("maxlength=" + this.maxlength + ";");
    	builder.append("maxlengthMsg=" + this.maxlengthMsg + ";");
    	builder.append("expression=" + this.expression + ";");
    	builder.append("expressionMsg=" + this.expressionMsg + ";");
    	
    	String refAlias = "refAlias=" + this.refAlias + ";";
    	builder.append((null != this.refAlias && !"".equals(this.refAlias))?refAlias:"");
    	
    	//当且仅当指定了 '引用型校验项' 时，'校验项首字母是否大写' 才有意义
    	String abLetterUpcase = "abLetterUpcase=" + this.abLetterUpcase;
    	builder.append((null != this.refAlias && !"".equals(this.refAlias))?abLetterUpcase:"");
    	
    	builder.append("]}");
    	return builder.toString();
    }
    
    
	public String getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

	public String getRequiredMsg() {
		return requiredMsg;
	}

	public void setRequiredMsg(String requiredMsg) {
		this.requiredMsg = requiredMsg;
	}

	public String getMaxlengthMsg() {
		return maxlengthMsg;
	}

	public void setMaxlengthMsg(String maxlengthMsg) {
		this.maxlengthMsg = maxlengthMsg;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getExpressionMsg() {
		return expressionMsg;
	}

	public void setExpressionMsg(String expressionMsg) {
		this.expressionMsg = expressionMsg;
	}

	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}


	public String getDatatype() {
		return datatype;
	}


	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}


	public String getDatatypeMsg() {
		return datatypeMsg;
	}


	public void setDatatypeMsg(String datatypeMsg) {
		this.datatypeMsg = datatypeMsg;
	}


	public String getRefAlias() {
		return refAlias;
	}


	public void setRefAlias(String refAlias) {
		this.refAlias = refAlias;
	}


	public String getRefAliasMsg() {
		return refAliasMsg;
	}


	public void setRefAliasMsg(String refAliasMsg) {
		this.refAliasMsg = refAliasMsg;
	}

	public boolean getAbLetterUpcase() {
		return abLetterUpcase;
	}

	public void setAbLetterUpcase(boolean abLetterUpcase) {
		this.abLetterUpcase = abLetterUpcase;
	}

}
