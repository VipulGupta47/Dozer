package com.hs.demos.effectiveJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExceptionDemos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int i= 0;
			List l = new ArrayList();
			l.add("Nitin");
			Iterator it = l.iterator();
			
			while(true) 
				System.out.println(it.next());
//				System.out.println(args[i++]);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
//			System.out.println("Exception : "+e.getMessage());
			
		}

	}
	
	public int check() throws Exception{
		throw new Exception();
	}

}
