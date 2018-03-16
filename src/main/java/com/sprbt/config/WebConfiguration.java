package com.sprbt.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {       //配置过滤链

	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}
	
	@Bean
	public FilterRegistrationBean testFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("key1", "value1");
		registration.setName("myFilter");
		registration.setOrder(1);
		return registration;
	}
	
	
	public class MyFilter implements Filter{

		public void destroy() {
			// TODO Auto-generated method stub
			
		}

		public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
				throws IOException, ServletException {
			// TODO Auto-generated method stub
			
			HttpServletRequest request = (HttpServletRequest) arg0;
			System.out.println("this is myFilter url : " + request.getRequestURI());
			arg2.doFilter(arg0, arg1);
			
		}

		public void init(FilterConfig arg0) throws ServletException {
			// TODO Auto-generated method stub
			
		}

		
		
	}
	
}
