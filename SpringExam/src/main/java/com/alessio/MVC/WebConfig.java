package com.alessio.MVC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.alessio.MVC" })
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/")
			.setViewName("index");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new LoggerInterceptor())
			.addPathPatterns("/*")
			.excludePathPatterns("/rest/*", "/rest", "/error");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
	}
}
