package com.one.tools.system.log;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import com.one.tools.str.ELResolver;
import com.one.tools.system.SystemConstants;
import com.one.tools.system.SystemInfo;

public abstract class Log4jInitializer {
	public static void init(){
		
	}
	public static void init(String path){
		
		System.out.println("********************************* logPath: " + path);
		init(path, SystemConstants.LOG_REFRESH_INTALVAL_DEFAULT);
	}
	public static void init(String path, int interval){
		System.out.println("********************************* logPath=" + path + "; interval=" + interval);
		String resolvedPath = elResolvePath(path);
		
		System.out.println("********************************* resolvedPath=" + path + "; interval=" + interval);
		File logFile = getLogFile(resolvedPath);
		if (null == logFile || false == logFile.exists() || true == logFile.isDirectory()) {
			System.err.println("......the file not found for log4j ConfigFile, please check the configuration named '"+SystemConstants.LOG_CONFIG_FILE+"' ,'" + SystemConstants.CONFIG_PATH_KEY + "', '" + SystemConstants.SYSTEM_NAME_KEY + "' ......");
			System.exit(1);
		}
		
		if(resolvedPath.toLowerCase().endsWith(".xml")){
			DOMConfigurator.configureAndWatch(logFile.getAbsolutePath(), interval);
			SystemInfo.getInstance().addSysProps(SystemConstants.IS_LOG_INITIALIZED, "true");
		}else {
			PropertyConfigurator.configureAndWatch(logFile.getAbsolutePath(), interval);
			SystemInfo.getInstance().addSysProps(SystemConstants.IS_LOG_INITIALIZED, "true");
		}
	}
	
	public static String elResolvePath(String path){
		String resolvedPath = "";
		
		int start = path.indexOf(ELResolver.OPEN);
		int end = path.lastIndexOf(ELResolver.CLOSE);
		
		if (start >= 0 && end > start) {
			String placeString = path.substring(start, end + ELResolver.CLOSE.length());
			String propString = SystemInfo.getInstance().getSysProps().getProperty(placeString);
			if (null == propString) {
				propString = System.getProperty(placeString);
			}
			if (null != propString) {
				resolvedPath = path.replace(placeString, propString);
			}else {
				System.out.println("......no property named '" + path.substring(start+ELResolver.OPEN.length(), end) + "' found ......");
				resolvedPath = path;
			}
		}
		resolvedPath = resolvedPath.trim();
		try {
			resolvedPath = URLDecoder.decode(resolvedPath, SystemConstants.CHARSET_UTF8);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return resolvedPath;
	}
	
	public static String getPropString(){
		String propString = "";
		
		return propString;
	}
	
	private static File getLogFile(String path){
		File logFile = null;
		
		if (null == path) {
			System.err.println("......the file not found for log4j ConfigFile, please check the configuration named '"+SystemConstants.LOG_CONFIG_FILE+"' ,'" + SystemConstants.CONFIG_PATH_KEY + "', '" + SystemConstants.SYSTEM_NAME_KEY + "' ......");
			System.exit(1);
		}
		
		logFile = new File(path);
		
		return logFile;
	}
}
