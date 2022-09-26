package com.java.restapi.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


import com.java.restapi.entity.Student;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.java.restapi.*")
public class SpringConfig {
	
	static {
		System.out.println("load Configuration");
	}
	@Bean
	public BasicDataSource getdataSource() {
		BasicDataSource bds=new BasicDataSource();
	    bds.setUsername("root");
	    bds.setPassword("414141");
	    bds.setUrl("jdbc:mysql://localhost:3306/spring_db");
	    bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return bds;
	}
	@Bean
	public LocalSessionFactoryBean getFactory() {

		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(getdataSource());
		bean.setAnnotatedClasses(Student.class);
		Properties prop=new Properties();
		prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		prop.put(Environment.HBM2DDL_AUTO,"update");
		prop.put(Environment.SHOW_SQL, true);
		bean.setHibernateProperties(prop);
		return bean;
		
	}
	@Bean
	public ViewResolver internalResourceViewResolver() {
		
		InternalResourceViewResolver view=new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);
		view.setPrefix("/WEB-INF/pages/");
		view.setSuffix(".jsp");
		return view;
		
	}


}
