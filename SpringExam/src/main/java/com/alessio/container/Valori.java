package com.alessio.container;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Valori {
	@Value("${test.nodefault}")
	private String testProperies;
	
	@Value("${test.withdefault:10}")
	private int testProperiesDefault;
	
	@Value("#{{1, 2, 3}}")
	private List<Integer> testSpelList;
	
	@Value("#{3 > 2 ? 'conditionTrue': 'conditionFalse'}")
	private String testSpelCondition;
	
	public Valori(@Value("${test.withdefault:10}") int valueInConstructor,
			TestProperties testProperties) {
		System.out.println("Valori component: costruttore...");
		System.out.println(testProperies);
		System.out.println(testProperiesDefault);
		System.out.println("Valori component ->  valueInConstructor: "+valueInConstructor);
		System.out.println("testproperties, name: "+testProperties.getName());
		System.out.println("testproperties, surname: "+testProperties.getSurname());
	}
	
	@PostConstruct
	public void postConstructor() {
		System.out.println("Valori component -> @PostConstruct...");
		System.out.println("Valori component -> testProperies: "+testProperies);
		System.out.println("Valori component -> testProperiesDefault: "+testProperiesDefault);
		System.out.println("Valori component -> testSpelList: "+testSpelList);
		System.out.println("Valori component -> testSpelCondition: "+testSpelCondition);
	}
}
