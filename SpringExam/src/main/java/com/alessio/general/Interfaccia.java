package com.alessio.general;

public interface Interfaccia {
	String test = "test";
	
	default void methodTest() {
		System.out.println("test default method");
	}
}
