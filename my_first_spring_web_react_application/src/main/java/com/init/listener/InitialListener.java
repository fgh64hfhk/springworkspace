package com.init.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.init.SystemConstant;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class InitialListener implements ServletContextListener{
	
	private static Logger log = LoggerFactory.getLogger(InitialListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		log.info("Servlet context destroyed...");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		sce.getServletContext().setAttribute("system_constant", new SystemConstant());
		log.info("InitialListener Context initialized() is running...");
	}
	
	
}
