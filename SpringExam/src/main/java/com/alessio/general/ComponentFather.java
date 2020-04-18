package com.alessio.general;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ComponentFather {
	private ComponentSon son;
	public ComponentFather(@Qualifier("componentSon") ComponentSon son) {
		this.son = son;
		System.out.println("Done");
	}
}
