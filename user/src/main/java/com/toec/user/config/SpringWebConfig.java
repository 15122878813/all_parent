package com.toec.user.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

@Configuration
public class SpringWebConfig {


	//	 //配置spring mvc 拦截器
	//	 @Override
	//	 public void addInterceptors(InterceptorRegistry registry) {
	//		 registry.addInterceptor(new TimeAccessInterceptor())
	//		         .addPathPatterns("/user/doLogin");
	//	 }
	@Bean
	public FilterRegistrationBean<Filter> newFilterRegistrationBean() {
		//创建过滤器注册器
		FilterRegistrationBean<Filter> rBean=
				new FilterRegistrationBean<>();
		//创建过滤器对象
		DelegatingFilterProxy filterProxy=
				new DelegatingFilterProxy("shiroFilterFactory");
		rBean.setFilter(filterProxy);
		//配置过滤器映射路径
		rBean.addUrlPatterns("/*");
		return rBean;
	}
}

