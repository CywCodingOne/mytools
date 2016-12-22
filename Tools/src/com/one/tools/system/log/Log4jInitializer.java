package com.one.tools.system.log;

import com.one.tools.system.SystemConstants;

public abstract class Log4jInitializer {
	public static void init(){
		
	}
	public static void init(String path){
		init(path, SystemConstants.LOG_REFRESH_INTALVAL_DEFAULT);
	}
	public static void init(String path, int interval){
		if (false == isLogFileExist(path)) {
			System.out.println("......");
		}
	}
	
	public static boolean isLogFileExist(String path){
		return false;
	}
}
