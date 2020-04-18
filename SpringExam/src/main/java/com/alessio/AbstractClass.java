package com.alessio;

public abstract class AbstractClass {
	
	public abstract String method();
	private String test() {
		new Thread(() -> System.out.println("runnable test")).start();
		return "";
	}
}
