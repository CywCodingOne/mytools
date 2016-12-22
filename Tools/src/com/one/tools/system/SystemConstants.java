package com.one.tools.system;

public class SystemConstants {
	
	/**
	 * 斜线“/”，文件路径分隔符
	 */
	public static final String FILE_SEPARATOR = "/";
	
	/**
	 * 点号
	 */
	public static final String DOT = ".";
	
	//软件名称配置项 Key ，用于在 web.xml 中配置 软件名
	public static final String SYSTEM_NAME_KEY = "one.tools.system.name";
	
	//配置文件路径配置项 Key ，用于在 web.xml 中配置 配置文件路径
	public static final String CONFIG_PATH_KEY = "one.tools.config.path";
	
	//配置文件名配置项 Key ,用于在 web,xml 中配置 配置文件名
	public static final String CONFIG_FILE_KEY = "one.tools.config.file";
	
	//log4j 日志打印配置文件 配置项 Key ，用于在 web.xml 中配置 log4j 配置文件
	public static final String LOG_CONFIG_FILE = "one.tools.log.file";
	
	//log4j 日志配置文件刷新刷新读取间隔
	public static final String LOG_REFRESH_INTALVAL_KEY = "one.tools.log.refreshInterval";
	
	
	public static final int LOG_REFRESH_INTALVAL_DEFAULT = 60000;
	
}
