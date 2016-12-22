package com.one.tools.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.one.tools.exception.ParamIllegalException;
import com.one.tools.exception.ParamNullException;

/**
 * @description 对不同时间格式进行转换
 * @author one-coder
 * @date 2016年10月30日 下午7:40:16
 */
public class DateUtils {
	
	private static final Logger logger = Logger.getLogger(DateUtils.class);
	
	//标准时间格式
	public static String SIMPLE_DATE = "yyyy-MM-dd HH:mm:ss";
	
	//标准时间格式，12小时制
	public static String SIMPLE_DATE_12 = "yyyy-MM-dd hh:mm:ss aa.";
	
	//纯数字串时间格式
	public static String PURE_NUM_DATE = "yyyyMMddHHmmss";
	
	//以 点号（“.”） 分隔的时间格式
	public static String DOT_DATE = "yyyy.MM.dd HH:mm:ss";
	
	//以 点号（“.”） 分隔的时间格式，12小时制
	public static String DOT_DATE_12 = "yyyy.MM.dd hh:mm:ss aa.";
	
	//标准时间格式，带星期数
	public static String SIMPLE_DATE_WEEKDAY = "yyyy-MM-dd HH:mm:ss EEE";
	
	//带中文单位的时间格式：xxxx年xx月xx日 xx时xx分xx秒
	public static String CHZN_DATE = "yyyy年MM月 dd日 HH时mm分ss秒";
	
	//时间戳格式时间，即从格林威治时间1970年01月01日00时00分00秒起至现在的总毫秒数
	public static String STAMP_DATE = "stamp";
	
	/**
	 * @description parse String into Date, which formated "yyyy-MM-dd HH:mm:ss",for example "2016-10-30 23:27:00"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null 
	 */
	public static Date simpleDate(String date) throws ParamNullException{
		if (null == date) {
			logger.error("parse date failed! \n caused by: param null...");
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
			logger.error("format date failed! \n caused by: param null...");
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
			logger.error("parse date failed! \n caused by: param null...");
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
			logger.error("format date failed! \n caused by: param null...");
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
			logger.error("parse date failed! \n caused by: param null...");
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
			logger.error("format date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.simpleWithWeekDate(Date) : null param is illegal !");
		}
		String temp = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_WEEKDAY);
		temp = simpleDateFormat.format(date);
		return temp;
	}
	
	/**
	 * @description parse String into Date, which formated "yyyy-MM-dd HH:mm:ss EEE",for example "2016-11-01 00:30:15 Tue"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static Date simple12Date(String date) throws ParamNullException{
		if (null == date) {
			logger.error("parse date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.simple12Date(String) : null param is illegal !");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_12);
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
	public static String simple12Date(Date date) throws ParamNullException{
		if (null == date) {
			logger.error("format date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.simple12Date(Date) : null param is illegal !");
		}
		String temp = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_12);
		temp = simpleDateFormat.format(date);
		return temp;
	}
	
	/**
	 * @description parse String into Date, which formated "yyyy-MM-dd HH:mm:ss EEE",for example "2016-11-01 00:30:15 Tue"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static Date dotDate(String date) throws ParamNullException{
		if (null == date) {
			logger.error("parse date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.dotDate(String) : null param is illegal !");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DOT_DATE);
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
	public static String dotDate(Date date) throws ParamNullException{
		if (null == date) {
			logger.error("format date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.dotDate(Date) : null param is illegal !");
		}
		String temp = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DOT_DATE);
		temp = simpleDateFormat.format(date);
		return temp;
	}
	
	/**
	 * @description parse String into Date, which formated "yyyy-MM-dd HH:mm:ss EEE",for example "2016-11-01 00:30:15 Tue"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static Date dot12Date(String date) throws ParamNullException{
		if (null == date) {
			logger.error("parse date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.dot12Date(String) : null param is illegal !");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DOT_DATE_12);
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
	 * @description format Date into String, which formated "yyyy.MM.dd hh:mm:ss aa.",for example "2016.11.20 23:30:55 "
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static String dot12Date(Date date) throws ParamNullException{
		if (null == date) {
			logger.error("format date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.dot12Date(Date) : null param is illegal !");
		}
		String temp = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DOT_DATE_12);
		temp = simpleDateFormat.format(date);
		return temp;
	}
	
	/**
	 * @description parse String into Date, which formated "yyyy年MM月dd日 HH时mm分ss秒",for example "2016年11月20日 23时27分12秒"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static Date chznDate(String date) throws ParamNullException{
		if (null == date) {
			logger.error("parse date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.chznDate(String) : null param is illegal !");
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CHZN_DATE);
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
	 * @description format Date into String, which formated "yyyy年MM月dd日 HH时mm分ss秒",for example "2016年11月20日 23时27分12秒"
	 * @param 
	 * @return 
	 * @throws ParamNullException,when param null
	 */
	public static String chznDate(Date date) throws ParamNullException{
		if (null == date) {
			logger.error("format date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.chznDate(Date) : null param is illegal !");
		}
		String temp = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CHZN_DATE);
		temp = simpleDateFormat.format(date);
		return temp;
	}
	
	/**
	 * @description parse String into Date, which formated stampDate,for example "1479662462715"
	 * @param 
	 * @return 
	 * @throws
	 */
	/*public static Date stampDate(String date) throws ParamNullException, ParamIllegalException{
		if (null == date) {
			logger.error("parse date failed! \n caused by: param null...");
			throw new ParamNullException("ParamNullException:\n	com.one.tools.datetime.DateUtils.stampDate(String) : null param is illegal !");
		}
		Long tempLong = Long.parseLong(date);
		if (null == tempLong) {
			throw new ParamIllegalException("com.one.tools.datetime.DateUtils.stampDate(String):", ParamIllegalException.STRING);
		}
		
		Date temp = null;
		temp = new Date(tempLong.longValue());
		return temp;
	}*/
	
}