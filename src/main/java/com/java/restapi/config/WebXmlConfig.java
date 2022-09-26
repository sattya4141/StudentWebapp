package com.java.restapi.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



  public class WebXmlConfig  implements WebApplicationInitializer{
	  
	  static {
		  System.out.println("load webxml file");
	  }

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		
		context.register(SpringConfig.class);
		context.setServletContext(servletContext);
		
		
		ServletRegistration.Dynamic dispatcher= servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		
		dispatcher.addMapping("/");
		
		
	}

		
	}


