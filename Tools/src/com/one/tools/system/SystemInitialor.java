package com.one.tools.system;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.one.tools.str.StringUtils;
import com.one.tools.system.log.Log4jInitializer;
import com.sun.org.apache.xml.internal.security.Init;

public class SystemInitialor {
	private static SystemInfo systemInfo = null;
	
	public static void init(ServletContext context){
		String systemName = context.getInitParameter(SystemConstants.SYSTEM_NAME_KEY);
		String configPath = context.getInitParameter(SystemConstants.CONFIG_PATH_KEY);
		String configFile = context.getInitParameter(SystemConstants.CONFIG_FILE_KEY);
		String logFile = context.getInitParameter(SystemConstants.LOG_CONFIG_FILE);
		String logInterval = context.getInitParameter(SystemConstants.LOG_REFRESH_INTALVAL_KEY);
		String userDir = System.getProperty("user.dir");
		
		systemInfo = new SystemInfo(systemName, configPath, configFile, logFile, userDir);
		
		initLog4j(systemName, configPath, logFile, logInterval);
	}
	
	public static void initLog4j(String systemName, String confPath, String logfile, String interval){
		if (StringUtils.isEmpty(systemName)) {
			System.out.println("......the config path is illegal, please check the configuration named \""+SystemConstants.SYSTEM_NAME_KEY+"\" ......");
			System.exit(1);
		}
		if (StringUtils.isEmpty(confPath)) {
			System.out.println("......the config path is illegal, please check the configuration named \""+SystemConstants.CONFIG_PATH_KEY+"\" ......");
			System.exit(1);
		}
		if (StringUtils.isEmpty(logfile)) {
			System.out.println("......the logParam file is illegal, please check the configuration named \""+SystemConstants.LOG_CONFIG_FILE+"\" ......");
			System.exit(1);
		}
		
//		String path = new StringBuilder(userDir).append(FS).append(systemName).append(FS).append(confPath).append(FS).append(logfile).toString();
		
		try {
			int logInterval = Integer.parseInt(interval);
//			Log4jInitializer.init(path, logInterval);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("......parse log refresh interval failed, so default value is used: "+SystemConstants.LOG_REFRESH_INTALVAL_DEFAULT+", please check configParam named \""+SystemConstants.LOG_REFRESH_INTALVAL_KEY+"\"......");
//			Log4jInitializer.init(path);
		}
	}

	public static SystemInfo getSystemInfo() {
		return systemInfo;
	}

	public static void setSystemInfo(SystemInfo systemInfo) {
		systemInfo = systemInfo;
	}
	
}
