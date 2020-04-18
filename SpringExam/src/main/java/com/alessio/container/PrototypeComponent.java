package com.alessio.container;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeComponent {
	private final double id;
	public PrototypeComponent() {
		this.id = Math.ceil(Math.random()*9999999);
		System.out.println("PrototypeComponent instantiated with id: "+getId());
	}
	
	public double getId() {
		return id;
	}
}
