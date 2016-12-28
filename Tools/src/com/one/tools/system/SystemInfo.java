package com.one.tools.system;

import java.util.Properties;

public class SystemInfo {
	
	private static SystemInfo sysInfo;
	
	/**
	 * 配置的系统名称
	 */
	private String systemName;
	
	/**
	 * 指定的系统配置文件路径
	 */
	private String configPath;
	
	/**
	 * 指定的系统配置文件
	 */
	private String configFile;
	
	/**
	 * 指定的 日志配置文件，目前默认为 log4j 配置文件
	 */
	private String logFile;
	
	/**
	 * 用来保存一些系统级的配置参数或者初始化参数
	 */
	private Properties sysProps;
	
	public SystemInfo(){
		
	}
	
	public static synchronized SystemInfo getInstance(){
		if (null == SystemInfo.sysInfo) {
			SystemInfo.init("", "", "", "");
		}
		return SystemInfo.sysInfo;
	}
	
	public static synchronized void init(String systemName, String configPath, String configFile, String logFile){
		if (null == sysInfo) {
			sysInfo = new SystemInfo();
			sysInfo.setSystemName(systemName);
			sysInfo.setConfigPath(configPath);
			sysInfo.setConfigFile(configFile);
			sysInfo.setLogFile(logFile);
		}
	}
	
	public void initSysProps(String systemName, String configPath){
		if (null == this.sysProps) {
			this.sysProps = new Properties();
		}
	}
	
	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getConfigPath() {
		return configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	public String getLogFile() {
		return logFile;
	}

	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}

	public Properties getSysProps() {
		if (null == this.sysProps) {
			this.initSysProps(this.systemName, this.configPath);
		}
		return this.sysProps;
	}

	public void addSysProps(String key, String value){
		Properties props = this.getSysProps();
		if (null == key || "".equals(key)) {
			return;
		}
		props.setProperty(key, value);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder("{systemInfo:{");
		builder.append("systemName="+this.systemName+",");
		builder.append("configPath="+this.configPath+",");
		builder.append("configFile="+this.configFile+",");
		builder.append("logFile="+this.logFile+"}}");
		
		return builder.toString();
	}
}
