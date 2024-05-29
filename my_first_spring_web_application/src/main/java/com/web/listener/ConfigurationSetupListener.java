package com.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.utils.GlobalService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ConfigurationSetupListener implements ServletContextListener {
	private static Logger logger = LoggerFactory.getLogger(ConfigurationSetupListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		ServletContextListener.super.contextDestroyed(sce);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("================ ConfigurationSetupListener =================");
		ServletContext sc = sce.getServletContext();
		
		sc.setAttribute("database_type", GlobalService.getDatabase_type());
		logger.info("資料庫類型: " + GlobalService.getDatabase_type() + ", db.properties / hibernate.cfg.xml 設定成功");
	}
	
}
