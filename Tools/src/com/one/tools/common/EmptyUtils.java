package com.one.tools.common;

import java.util.List;
import java.util.Map;

/**
 * @description 对一些常规数据结构进行是否为空的判断
 * @author one-coder
 * @date 2016年10月30日 下午12:41:18
 */
public class EmptyUtils {
	
	/**
	 * @description whether is param string is empty
	 * @param 
	 * @return true,if, null==string or string.length==0
	 * @throws
	 */
	public static boolean isEmpty(String string){
		if (null == string || "".equals(string)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param string is not empty
	 * @param 
	 * @return true,if and only if, null != string and string.length != 0
	 * @throws
	 */
	public static boolean isNotEmpty(String string){
		if (null != string && ! "".equals(string)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param array is empty
	 * @param 
	 * @return true,if and only if, null == array or array.length == 0
	 * @throws
	 */
	public static boolean isEmpty(Object [] array){
		if (null == array || 0 == array.length) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param array is not empty
	 * @param 
	 * @return true,if and only if, null != array and array.length != 0
	 * @throws
	 */
	public static boolean isNotEmpty(Object [] array){
		if (null == array || 0 == array.length) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether is param array is empty
	 * @param 
	 * @return true,if and only if, null == array or array.length == 0
	 * @throws
	 */
	public static boolean isEmpty(int [] array){
		if (null == array || 0 == array.length) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param array is not empty
	 * @param 
	 * @return true,if and only if, null != array and array.length != 0
	 * @throws
	 */
	public static boolean isNotEmpty(int [] array){
		if (null == array || 0 == array.length) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether is param array is empty
	 * @param 
	 * @return true,if and only if, null == array or array.length == 0
	 * @throws
	 */
	public static boolean isEmpty(long [] array){
		if (null == array || 0 == array.length) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param array is not empty
	 * @param 
	 * @return true,if and only if, null != array and array.length != 0
	 * @throws
	 */
	public static boolean isNotEmpty(long [] array){
		if (null == array || 0 == array.length) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether is param array is empty
	 * @param 
	 * @return true,if and only if, null == array or array.length == 0
	 * @throws
	 */
	public static boolean isEmpty(float [] array){
		if (null == array || 0 == array.length) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param array is not empty
	 * @param 
	 * @return true,if and only if, null != array and array.length != 0
	 * @throws
	 */
	public static boolean isNotEmpty(float [] array){
		if (null == array || 0 == array.length) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether is param array is empty
	 * @param 
	 * @return true,if and only if, null == array or array.length == 0
	 * @throws
	 */
	public static boolean isEmpty(double [] array){
		if (null == array || 0 == array.length) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param array is not empty
	 * @param 
	 * @return true,if and only if, null != array and array.length != 0
	 * @throws
	 */
	public static boolean isNotEmpty(double [] array){
		if (null == array || 0 == array.length) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether is param array is empty
	 * @param 
	 * @return true,if and only if, null == array or array.length == 0
	 * @throws
	 */
	public static boolean isEmpty(char [] array){
		if (null == array || 0 == array.length) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param array is not empty
	 * @param 
	 * @return true,if and only if, null != array and array.length != 0
	 * @throws
	 */
	public static boolean isNotEmpty(char [] array){
		if (null == array || 0 == array.length) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether is param map is empty
	 * @param 
	 * @return true,if and only if, null == map or map.size() == 0
	 * @throws
	 */
	public static boolean isEmpty(Map map){
		if (null == map || 0 == map.size()) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param map is not empty
	 * @param 
	 * @return true,if and only if, null != map and map.size() != 0
	 * @throws
	 */
	public static boolean isNotEmpty(Map map){
		if (null == map || 0 == map.size()) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether is param list is empty
	 * @param 
	 * @return true,if and only if, null == list or list.size() == 0
	 * @throws
	 */
	public static boolean isEmpty(List list){
		if (null == list || 0 == list.size()) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether is param list is not empty
	 * @param 
	 * @return true,if and only if, null != list and list.size() != 0
	 * @throws
	 */
	public static boolean isNotEmpty(List list){
		if (null == list || 0 == list.size()) {
			return false;
		}
		return true;
	}
	
}
