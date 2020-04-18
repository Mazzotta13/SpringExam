package com.alessio.container;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("son")
public class SonComponent implements InitializingBean, DisposableBean {
	private final double id;
	public SonComponent() {
		this.id = Math.ceil(Math.random()*9999999);
		System.out.println("son: instantiated with id "+getId());
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("son: postConstruct()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("son: afterPropertiesSet()");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("son: preDestroy()");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("son: destroy()");
	}
	
	public double getId() {
		return id;
	}
}
