package com.alessio.container;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


@Configuration
public class ConfigurationBean {
	@Bean
	@Qualifier("beanTest")
	//@Lazy // in questo modo non vediamo il bean instanziato perchè non è mai utilizzato
	public BeanTest beanTest() {
		return new BeanTest();
	}
}
