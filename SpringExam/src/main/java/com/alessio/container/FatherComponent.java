package com.alessio.container;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class FatherComponent {
	private SonComponent son;
	private PrototypeComponent prototype1;
	private PrototypeComponent prototype2;
	SonComponent son2;
	private final double id;
	
	public FatherComponent(@Qualifier("son") SonComponent son, PrototypeComponent prototype1, 
			PrototypeComponent prototype2) {
		this.id = Math.ceil(Math.random()*9999999);
		this.son = son;
		this.prototype1 = prototype1;
		this.prototype2 = prototype2;
		System.out.println("Father craeted with id: "+getId());
		System.out.println("Son dependency imported with id: "+son.getId());
		System.out.println("NOTA: I 2 prototype bean hanno id diversi");
		System.out.println("prototype1 dependency imported with id: "+prototype1.getId());
		System.out.println("prototype2 dependency imported with id: "+prototype2.getId());
	}

	public double getId() {
		return id;
	}
}
