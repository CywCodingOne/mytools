package com.one.tools.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.one.tools.exception.ParamNullException;

/**
 * @description 对不同时间格式进行转换
 * @author one-coder
 * @date 2016年10月30日 下午7:40:16
 */
public class DateUtils {
	
	//标准时间格式
	public static String SIMPLE_DATE = "yyyy-MM-dd HH:mm:ss";
	
	//标准时间格式，12小时制
	public static String SIMPLE_DATE_12 = "yyyy-MM-dd hh:mm:ss aa.";
	
	//纯数字串时间格式
	public static String PURE_NUM_DATE = "yyyyMMddHHmmss";
	
	//以 点号（“.”） 分隔的时间格式
	public static String DOT_DATE = "yyyy.MM.dd HH.mm.ss";
	
	//以 点号（“.”） 分隔的时间格式，12小时制
	public static String DOT_DATE_12 = "yyyy.MM.dd hh.mm.ss aa.";
	
	//标准时间格式，带星期数
	public static String SIMPLE_DATE_WEEKDAY = "yyyy-MM-dd HH:mm:ss EEE";
	
	
	
	/**
	 * @description parse String into Date, which formated "yyyy-MM-dd HH:mm:ss",for example "2016-10-30 23:27:00"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null 
	 */
	public static Date simpleDate(String date) throws ParamNullException{
		if (null == date) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.simpleDate(String) : null param is illegal !");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE);
		Date temp = null;
		try {
			temp = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return temp;
	}
	
	/**
	 * @description format Date into String, which formated "yyyy-MM-dd HH:mm:ss",for example "2016-10-30 23:27:00"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null 
	 */
	public static String simpleDate(Date date) throws ParamNullException{
		if (null == date) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.simpleDate(Date) : null param is illegal !");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE);
		String temp = null;
		temp = simpleDateFormat.format(date);
		return temp;
	}
	
	/**
	 * @description parse String into Date, which formated "yyyyMMddHHmmss",for example "20161030232700"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static Date pureNumDate(String date) throws ParamNullException{
		if (null == date) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.pureNumDate(String) : null param is illegal !");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PURE_NUM_DATE);
		Date temp = null;
		try {
			temp = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return temp;
	}
	
	/**
	 * @description format Date into String, which formated "yyyyMMddHHmmss",for example "20161030232700"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static String pureNumDate(Date date) throws ParamNullException{
		if (null == date) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.pureNumDate(Date) : null param is illegal !");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PURE_NUM_DATE);
		String temp = null;
		temp = simpleDateFormat.format(date);
		return temp;
	}
	
	/**
	 * @description parse String into Date, which formated "yyyy-MM-dd HH:mm:ss EEE",for example "2016-11-01 00:30:15 Tue"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static Date simpleWithWeekDate(String date) throws ParamNullException{
		if (null == date) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.simpleWithWeekDate(String) : null param is illegal !");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_WEEKDAY);
		Date temp = null;
		try {
			temp = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return temp;
	}
	
	/**
	 * @description format Date into String, which formated "yyyy-MM-dd HH:mm:ss EEE",for example "2016-11-01 00:30:15 Tue"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static String simpleWithWeekDate(Date date) throws ParamNullException{
		if (null == date) {
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.simpleWithWeekDate(Date) : null param is illegal !");
		}
		String temp = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_WEEKDAY);
		temp = simpleDateFormat.format(date);
		return temp;
	}
	
}