package com.alessio.general;

public abstract class AbstractClass {
	
	public abstract String method();
	private String test() {
		new Thread(() -> System.out.println("runnable test")).start();
		return "";
	}
}
