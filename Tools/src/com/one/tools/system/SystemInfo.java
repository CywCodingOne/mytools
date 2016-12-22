package com.one.tools.system;

public class SystemInfo {
	
	private String userDir;
	/**
	 * 
	 */
	private String systemName;
	
	/**
	 * 
	 */
	private String configPath;
	
	/**
	 * 
	 */
	private String configFile;
	
	/**
	 * 
	 */
	private String logFile;
	
	public SystemInfo(){
		
	}
	
	public SystemInfo(String systemName, String configPath, String configFile, String logFile,String userDir){
		this.systemName = systemName;
		this.configPath = configPath;
		this.configFile = configFile;
		this.logFile = logFile;
		this.userDir = userDir;
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

	
	public String getUserDir() {
		return userDir;
	}

	public void setUserDir(String userDir) {
		this.userDir = userDir;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder("{systemInfo:{");
		builder.append("systemName="+this.systemName+",");
		builder.append("configPath="+this.configPath+",");
		builder.append("configFile="+this.configFile+",");
		builder.append("logFile="+this.logFile+",");
		builder.append("UserDir="+this.userDir+"}}");
		
		return builder.toString();
	}
}
