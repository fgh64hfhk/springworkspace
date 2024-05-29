package com.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.config.RootAppConfig;
import com.config.WebAppConfig;
import com.init.listener.InitialListener;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private static Logger log = LoggerFactory.getLogger(WebAppInitializer.class);

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("準備建立RootApplicationContext物件");
		return new Class[] {RootAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("準備建立WebApplicationContext物件");
		return new Class[] {WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		log.info("定義DispatcherServlet物件所要設定的選項");
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		log.info("準備添加Servlet Filters物件");
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return new Filter[] {encodingFilter};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		log.info("準備添加Servlet Listener物件");
		servletContext.addListener(InitialListener.class);
		log.info("*************************");
		
		String inFileLocation = "";
		if (SystemConstant.DB_TYPE == SystemConstant.MYSQL) {
			inFileLocation = "/WEB-INF/db_MySQL.properties";
			
		} else if (SystemConstant.DB_TYPE == SystemConstant.SQL_SERVER) {
			inFileLocation = "/WEB-INF/db_SQLServer.properties";
		}
		
		String realPath = servletContext.getRealPath("/WEB-INF/classes");
		System.out.println("real path: " + realPath);
//		String realPath2 = "C:\\Users\\user\\eclipse-springworkspace\\my_first_spring_web_react_application\\src\\main\\resource";
		File folder = new File(realPath); 
		File outFile = new File(folder, "db.properties");
		
		try (	FileOutputStream fos = new FileOutputStream(outFile);
				InputStream is = servletContext.getResourceAsStream(inFileLocation);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(fos));
			){
			String line = "";
			while ((line = br.readLine()) != null) {
				out.println(line);
				System.out.println("buffered reader: " + line);
			}
			System.out.println("File db.properties is been established...");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
