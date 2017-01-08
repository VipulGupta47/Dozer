package com.hs.demos.effectiveJava;

public class SingeltonInstanceBuilder {
	
	private static class InnerClass {
		private static final SingletonClass SINGLE = new SingletonClass();
	}
	
	public static SingletonClass getInstance() {
		return InnerClass.SINGLE;
	}

}
