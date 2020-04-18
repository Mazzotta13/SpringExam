package com.alessio;

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
	
	public Valori(@Value("${test.withdefault:10}") int valueInConstructor) {
		System.out.println("costruttore...");
		System.out.println(testProperies);
		System.out.println(testProperiesDefault);
		System.out.println("valueInConstructor: "+valueInConstructor);
	}
	
	@PostConstruct
	public void postConstructor() {
		System.out.println("@PostConstruct...");
		System.out.println(testProperies);
		System.out.println(testProperiesDefault);
		System.out.println("testSpel: "+testSpelList);
		System.out.println("testSpel: "+testSpelCondition);
	}
}
