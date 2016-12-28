package com.one.tools.system;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.one.tools.str.StringUtils;
import com.one.tools.system.log.Log4jInitializer;
import com.sun.org.apache.xml.internal.security.Init;

public class SystemInitialor {
	
	public static void init(ServletContext context){
		String systemName = context.getInitParameter(SystemConstants.SYSTEM_NAME_KEY);
		String configPath = context.getInitParameter(SystemConstants.CONFIG_PATH_KEY);
		String configFile = context.getInitParameter(SystemConstants.CONFIG_FILE_KEY);
		String logFile = context.getInitParameter(SystemConstants.LOG_CONFIG_FILE);
		String logInterval = context.getInitParameter(SystemConstants.LOG_REFRESH_INTALVAL_KEY);
		
		SystemInfo.init(systemName, configPath, configFile, logFile);
		
		initLog4j(systemName, configPath, logFile, logInterval);
	}
	
	public static void initLog4j(String systemName, String confPath, String logfile, String interval){
		
		//如果log4j已经初始化过了（即调用系统监听器之前已经调用过log4j初始化监听器），则不再进行初始化，这么做的目的是为了将系统初始化与log4j初始化解耦
		String logInitialzed = SystemInfo.getInstance().getSysProps().getProperty(SystemConstants.IS_LOG_INITIALIZED, "false");
		if ("true".equalsIgnoreCase(logInitialzed)) {
			return;
		}
		if (null == systemName || "".equals(systemName)) {
			System.err.println("......the system name is illegal, please check the configuration named '"+SystemConstants.SYSTEM_NAME_KEY+"' ......");
			System.exit(1);
		}
		if (null == confPath || "".equals(confPath)) {
			System.out.println("......warn: the config path empty, please check the configuration named '"+SystemConstants.CONFIG_PATH_KEY+"' ......");
		}
		if (null == logfile || "".equals(logfile)) {
			System.err.println("......the logParam file is illegal, please check the configuration named '"+SystemConstants.LOG_CONFIG_FILE+"' ......");
			System.exit(1);
		}
		
		String userDir = System.getProperty(SystemConstants.USER_DIR_KEY);
		String fs = System.getProperty(SystemConstants.FILE_SEPARATOR_KEY);
		String path = new StringBuilder(userDir).append(fs).append(systemName).append(fs).append(confPath).append(fs).append(logfile).toString();
		
		try {
			int logInterval = Integer.parseInt(interval);
//			Log4jInitializer.init(path, logInterval);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("......parse log refresh interval failed, so default value is used: "+SystemConstants.LOG_REFRESH_INTALVAL_DEFAULT+", please check configuration named '"+SystemConstants.LOG_REFRESH_INTALVAL_KEY+"'......");
			Log4jInitializer.init(path);
		}
	}

}
