package com.one.tools.str;


import com.one.tools.exception.ParamNullException;

/**
 * @description 对 String 类型的一些判断和操作
 * @author one-coder
 * @date 2016年10月28日 上午1:02:21
 */
public class StringUtils {

	/**
	 * @description whether param string is null or length==0
	 * @param String
	 * @return true,if, is null or length()==0 
	 */
	public static boolean isEmpty(String string){
		if (null == string || "".equals(string)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether param string whose length>0
	 * @param 
	 * @return true,if, !=null and length()!=0
	 */
	public static boolean isNotEmpty(String string){
		if (null != string && !"".equals(string)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description wether param string consisted of pure English
	 * @param 
	 * @return true,if and only if, every char of param string is English letter
	 * @throws ParamNullException,when, param is null
	 */
	public static boolean isPureEnglish(String string) throws ParamNullException{
		if (null == string) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.str.StringUtils.isPureEnglish(String) : null param is illegal !");
		}
		if ("".equals(string)) {
			return true;
		}
		char [] temp = string.toCharArray();
		for(char c : temp){
			if (!isCase(c)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @description wether param string not consisted of pure English
	 * @param 
	 * @return true,if, param string is not empty and one char of it is not English letter
	 * @throws ParamNullException,when, param is null
	 */
	public static boolean isNotPureEnglish(String string) throws ParamNullException{
		boolean is = true;
		try {
			is = isPureEnglish(string);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ParamNullException("ParamNullException:\n	com.one.tools.str.StringUtils.isNotPureEnglish(String) : null param is illegal !");
		}
		return is;
	}
	
	/**
	 * @description wether param char is English case
	 * @param 
	 * @return true,if, is letter between 'a' and 'z',ignore case;
	 */
	public static boolean isCase(char c){
		if ((c>'a' && c <'z') || (c>'A' && c<'Z')) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description 
	 * @param 
	 * @return true,if, param char is not English case;
	 * @throws
	 */
	public static boolean isNotCase(char c){
		return ! isCase(c);
	}
	
	/**
	 * @description trim all blank characters such as  '\t','\n','\r','\f',etc.
	 * @param 
	 * @return a string made from param by delete its blank character such as '\t','\n','\r','\f',etc.
	 * @throws ParamNullException,when, param is null
	 */
	public static String trimBlank(String string) throws ParamNullException{
		if (null == string) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.str.StringUtils.trimBlank(String) : null param is illegal !");
		}
		return string.replaceAll("\\s", "");
	}
	
	/**
	 * @description whether former contains latter , case ignored
	 * @param 
	 * @return true,if former contains latter ,case ignored
	 * @throws ParamNullException,when, param is null
	 */
	public static boolean formerContainLatterIgnoreCase(String former, String latter) throws ParamNullException{
		if (null == former) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.str.StringUtils.formerContainLatterIgnoreCase(String former, String latter) : null param former is illegal !");
		}
		if (null == latter) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.str.StringUtils.formerContainLatterIgnoreCase(String former, String latter) : null param latter is illegal !");
		}
		String lowerFormer = former.toLowerCase();
		String lowerLatter = latter.toLowerCase();
		
		return lowerFormer.contains(lowerLatter);
	}
	
	/**
	 * @description split param string with en-comma(",") or ch-comma("，")
	 * @param 
	 * @return a string arry splited from param
	 * @throws ParamNullException,when, param is null
	 */
	public static String[] splitWithCommas(String string) throws ParamNullException{
		if (null == string) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.str.StringUtils.splitWithCommas(String string) : null param is illegal !");
		}
		String[] strings = string.split(",|，");
		return strings;
	}
	
	/**
	 * @description split param string with en-branch(";") or ch-branch("；")
	 * @param 
	 * @return a string arry splited from param
	 * @throws ParamNullException,when, param is null
	 */
	public static String[] splitWithBranchs(String string) throws ParamNullException{
		if (null == string) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.str.StringUtils.splitWithBranchs(String string) : null param is illegal !");
		}
		String[] strings = string.split(";|；");
		return strings;
	}
	
	/**
	 * @description split param string with en-branch(";") or ch-branch("；") or en-comma(",") or ch-comma("，")
	 * @param 
	 * @return a string arry splited from param
	 * @throws ParamNullException,when, param is null
	 */
	public static String[] splitWithBranchsOrCommas(String string) throws ParamNullException{
		if (null == string) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.str.StringUtils.splitWithBranchsOrCommas(String string) : null param is illegal !");
		}
		String[] strings = string.split(";|；|,|，");
		return strings;
	}
}
