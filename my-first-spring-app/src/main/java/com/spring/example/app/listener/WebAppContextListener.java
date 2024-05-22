package com.spring.example.app.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.spring.example.app.initializer.Initializer;

import jakarta.annotation.PreDestroy;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WebAppContextListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("================ WebAppContextListener =================");
		Initializer initializer = new Initializer();
		initializer.initialize_product();
		System.out.println("================ WebAppContextListener End =================");
	}

	@PreDestroy
	public void cleanup() {
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
		try {
			AbandonedConnectionCleanupThread.checkedShutdown();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
