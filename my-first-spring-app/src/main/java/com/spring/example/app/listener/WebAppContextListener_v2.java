package com.spring.example.app.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.spring.example.app.initializer.Initializer;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WebAppContextListener_v2 implements ServletContextListener {
	
	@Autowired
	private Initializer initializer;

	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("================ WebAppContextListener =================");
		
    	System.out.println("================ 1. start create factory =================");
    	
    	System.out.println("================ 2. finish create factory =================");

    	System.out.println("================ 3. start Initializer =================");
		initializer.initialize_product();
    	System.out.println("================ 4. finish Initializer =================");
    	
		System.out.println("================ WebAppContextListener End =================");

	}

	@Override
    public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("================ 3 start close factory =================");

    	System.out.println("================ 4. finish close factory =================");

    	Enumeration<Driver> drivers = DriverManager.getDrivers();
    	Driver driver = null;
    	while (drivers.hasMoreElements()) {
    		try {
				driver = drivers.nextElement();
				DriverManager.deregisterDriver(driver);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
    	AbandonedConnectionCleanupThread.checkedShutdown();
    }

}
