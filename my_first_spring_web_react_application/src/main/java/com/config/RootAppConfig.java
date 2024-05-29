package com.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class RootAppConfig {
	
	private static Logger log = LoggerFactory.getLogger(RootAppConfig.class);
	
	@Value("${spring.database.initialPoolSize}")
	Integer ips;
	
	@Value("${spring.database.maxPoolSize}")
	Integer mps;
	
	@Value("${spring.hibernate.dialect}")
	String className;
	
	@Autowired
	Environment env;
	
	@Autowired
	public RootAppConfig(Environment env) {
		this.env = env;
	}
	
	@Bean
	public DataSource dataSource() {
		log.info("=====> data source class name: " + this.className);
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setUser(env.getProperty("spring.database.user"));
		ds.setPassword(env.getProperty("spring.database.password"));
		try {
			ds.setDriverClass(env.getProperty("spring.database.driverclass"));
		} catch (PropertyVetoException e) {
			System.out.println(e);
		}
		ds.setJdbcUrl(env.getProperty("spring.database.url"));
		ds.setInitialPoolSize(ips);
		ds.setMaxPoolSize(mps);
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan(new String[] {
				"com.model"
		});
		factoryBean.setDataSource(dataSource());
		factoryBean.setHibernateProperties(additionalProperties());
		return factoryBean;
	}
	
	@Bean(name = "transactionManager")
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(factory);
		return tx;
	}
	
	@Bean Properties additionalProperties() {
		Properties properties = new Properties();
		try {
			properties.put("hibernate.dialect", Class.forName(className));
		} catch (Exception e) {
			System.out.println(e);
		}
		properties.put("hibernate.show_sql", Boolean.TRUE);
		properties.put("hibernate.format_sql", Boolean.TRUE);
		properties.put("default_batch_fetch_size", 10);
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
}
