package com.one.tools.common;

/**
 * @description 对一些常规数据结构进行其值是否有效的判断
 * @author one-coder
 * @date 2016年10月30日 下午2:16:54
 */
public class ValuableUtils {
	
	/**
	 * @description whether the param named value is valuable
	 * @param value:validated param, noValue:not valuable status flag,which may be an initial definition,depending on business
	 * @return true,if and only if, null!=value and value not valued noValue
	 * @throws
	 */
	public static boolean isValuable(Integer value, int noValue){
		if (null == value || value.intValue() == noValue) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether the param named value is not valuable
	 * @param value:validated param, noValue:not valuable status flag,which may be an initial definition,depending on business
	 * @return true,if, null==value or value valued noValue
	 * @throws
	 */
	public static boolean isNotValuable(Integer value, int noValue){
		if (null == value || value.intValue() == noValue) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether the param named value is valuable
	 * @param value:validated param, noValue:not valuable status flag,which may be an initial definition,depending on business
	 * @return true,if and only if, null!=value and value not valued noValue
	 * @throws
	 */
	public static boolean isValuable(Long value, long noValue){
		if (null == value || value.longValue() == noValue) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether the param named value is not valuable
	 * @param value:validated param, noValue:not valuable status flag,which may be an initial definition,depending on business
	 * @return true,if, null==value or value valued noValue
	 * @throws
	 */
	public static boolean isNotValuable(Long value, long noValue){
		if (null == value || value.longValue() == noValue) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether the param named value is valuable
	 * @param value:validated param, noValue:not valuable status flag,which may be an initial definition,depending on business
	 * @return true,if and only if, null!=value and value not valued noValue
	 * @throws
	 */
	public static boolean isValuable(Float value, float noValue){
		if (null == value || value.floatValue() == noValue) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether the param named value is not valuable
	 * @param value:validated param, noValue:not valuable status flag,which may be an initial definition,depending on business
	 * @return true,if, null==value or value valued noValue
	 * @throws
	 */
	public static boolean isNotValuable(Float value, float noValue){
		if (null == value || value.floatValue() == noValue) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description whether the param named value is valuable
	 * @param value:validated param, noValue:not valuable status flag,which may be an initial definition,depending on business
	 * @return true,if and only if, null!=value and value not valued noValue
	 * @throws
	 */
	public static boolean isValuable(Double value, double noValue){
		if (null == value || value.doubleValue() == noValue) {
			return false;
		}
		return true;
	}
	
	/**
	 * @description whether the param named value is not valuable
	 * @param value:validated param, noValue:not valuable status flag,which may be an initial definition,depending on business
	 * @return true,if, null==value or value valued noValue
	 * @throws
	 */
	public static boolean isNotValuable(Double value, double noValue){
		if (null == value || value.doubleValue() == noValue) {
			return true;
		}
		return false;
	}
}
