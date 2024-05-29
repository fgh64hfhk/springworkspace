package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({ "com" })
public class WebAppConfig implements WebMvcConfigurer {

	private static Logger log = LoggerFactory.getLogger(WebAppConfig.class);

	public WebAppConfig() {
		log.info("Web application configuration class is constructed...");
	}

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setPrefix("/WEB-INF/views/");
		r.setSuffix(".jsp");
		return r;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("static file location and resource handler setting...");
		registry.addResourceHandler("/css/**")
				.addResourceLocations("/WEB-INF/views/css/");
		registry.addResourceHandler("/image/**")
				.addResourceLocations("/WEB-INF/views/images/");
	}

}
