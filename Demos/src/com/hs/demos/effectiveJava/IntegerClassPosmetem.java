package com.hs.demos.effectiveJava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unchecked")
public class IntegerClassPosmetem {
	
	private static final Map primitiveWrapperTypeMap = new HashMap(8);
	private static final Map primitiveTypeNameMap = new HashMap(16);

	static {

 		primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
		primitiveWrapperTypeMap.put(Byte.class, byte.class);
		primitiveWrapperTypeMap.put(Character.class, char.class);
		primitiveWrapperTypeMap.put(Double.class, double.class);
		primitiveWrapperTypeMap.put(Float.class, float.class);
		primitiveWrapperTypeMap.put(Integer.class, int.class);
		primitiveWrapperTypeMap.put(Long.class, long.class);
		primitiveWrapperTypeMap.put(Short.class, short.class);


	Set primitiveTypeNames = new HashSet(16);
	primitiveTypeNames.addAll(primitiveWrapperTypeMap.values());
	primitiveTypeNames.addAll(Arrays.asList(new Class[] {
 				boolean[].class, byte[].class, char[].class, double[].class,
 				float[].class, int[].class, long[].class, short[].class}));

 		for (Iterator it = primitiveTypeNames.iterator(); it.hasNext();) {
			Class primitiveClass = (Class) it.next();
			primitiveTypeNameMap.put(primitiveClass.getName(), primitiveClass);
		}

	}

	public static void main(String[] args) 
	{
//		System.out.println(Class.getPrimitiveClass("int"));
	}
}
