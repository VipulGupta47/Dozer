package com.headstrong.npi.raas.cobs.converter.dozer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

/**
 * This class uses <em>Reflection Class</em> for converting from String to Specific Enum Class and vice-versa.
 *  
 * @author 400219569
 *
 */
public class StringEnumCustomConverter  implements CustomConverter {


	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
			
		
		if (destClass != null) {
			try {
				if(destClass.getSimpleName().equalsIgnoreCase("String")) {
					return getValue(sourceClass , source);
				} else if(destClass.isEnum()) {
					return checkSourceInDestinationClass(destClass, source);
				} else {
					throw new MappingException("Converter StringEnumCustomConverter "
							+ "used incorrectly. Arguments passed in were:"
							+ source + " and " + destination);
				}
			} catch (Exception e) {
				throw new MappingException("Converter StringEnumCustomConverter "
						+ "unable to convert propeties data. Arguments passed in were:"
						+ source + " and " + destination + " : "+ e.getMessage());
			}
		}
		
		return null;
		
	}
	
	public static Object getValue(Class<?> sourceClass, Object source) {
		Object value = null;
		Method m = null;
		try {
			m = sourceClass.getDeclaredMethod("value");
			value = m.invoke(source, null);
			
		} catch (Exception e) {
			throw new MappingException("Unable to get source  "
					+ source + " in source class " + sourceClass + " : "+ e.getMessage());
		}
		return value; 
}

	public static Object checkSourceInDestinationClass(Class<?> destClass, Object source) {
		
		Object e = null;
		for (Method method :  destClass.getMethods()) {
			if(method.getName().equalsIgnoreCase("fromValue")) {
				try {
					e = method.invoke(destClass.getClass(), (String)source);
					break;
				} catch (Exception e1) {
					throw new MappingException("Unable to find source  "
							+ source + " in Destination class " + destClass + " : "+ e1.getCause());
				} 
			}
		}
	return e;
		
	}
	
}