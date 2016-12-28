package com.one.tools.system.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.one.tools.system.SystemInfo;
import com.one.tools.system.SystemInitialor;

public class InitSystemListener implements ServletContextListener {

	private Logger logger = Logger.getLogger(InitSystemListener.class);
	
	public InitSystemListener() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		logger.info("**************************************");
		logger.info("init system start !");
		
		ServletContext servletContext = servletContextEvent.getServletContext();
		SystemInitialor.init(servletContext);
		logger.info(""+SystemInfo.getInstance().toString());
		
		logger.info("init system end !");
		logger.info("**************************************");
	}

}
