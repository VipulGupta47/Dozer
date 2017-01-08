package com.hs.demos.effectiveJava;

public class SingletonCreationPOC {

	public static void main(String[] args) {
		SingletonCreationPOC p = new SingletonCreationPOC();
		SingletonClass sc1 = SingeltonInstanceBuilder.getInstance();
		p.createSingletonInMethod();
		System.out.println(sc1);
		sc1.setFirstname("NRS ");
//		System.out.println(sc1.getFirstname());
		System.out.println("after : "+sc1.getFirstname());
		p.createSingletonInMethod();

	}
	
	public void createSingletonInMethod() {
		
		SingletonClass sc = SingeltonInstanceBuilder.getInstance();
		sc.setFirstname("Nitin");
		sc.setLastname("Kumar");
		System.out.println("In Method : "+sc.getFirstname());
		
	}

}
