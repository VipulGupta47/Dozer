package com.headstrong.npi.raas.cobs.converter.dozer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.Utils;

/**
 * Convert String to Object which contain 'value' as a field and vice versa
 * @author 400219569
 *
 */
public class StringCustomConverter implements CustomConverter {

	private static final String REVERSE_MAPPING = "getValue";
	private static final String PRIMITIVE_WRAPPER_CONVERSION = "valueOf";

	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
			
		
		if (destClass != null) {
			
			if(destClass.getSimpleName().equalsIgnoreCase("String")) {
				return getValue(sourceClass , source);
			} else {	// don`t need to check as Object are Independent
				
				return setValueInDestinationObject(destClass, source);
			} 
			/*throw new MappingException("Converter StringToEnumCustomConverter "
					+ "used incorrectly. Arguments passed in were:"
					+ source + " and " + destination);*/
		}
		
		return null;
		
	}
	
	/**
	 * Reverse Mapping.
	 * 
	 * @param sourceClass This class is from cobs
	 * @param source This is element value
	 * @return Object
	 */
	public static Object getValue(Class<?> sourceClass, Object source) {
		Object obj = null;
		try {
			Method m = null;
			m = sourceClass.getDeclaredMethod(REVERSE_MAPPING);	// Every Class should have Common method.
			obj = m.invoke(source,null);
			// If obj is primitive or wrapper then convert into String.
			return typeCast(obj, String.class);
			
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} 
		return obj;
	
}

	/**
	 * Method dynamically create Object of destination class through Reflection.
	 * Set the value in it`s <em>value</em> state through calling setValue method dynamically.
	 * 
	 * @param destClass Destination class to which source need to be changed.
	 * @param source	Source which need to converted
	 * @return Custom data type Object like {@code CmAttributeString} etc.
	 */
	
	
	public static <T> T setValueInDestinationObject(Class<T> destClass, Object source) {
		T cls  =  null;
			try {
				Method m = null;
				String methodName = "setValue";		// Every Custom data type has 'value' as state
				cls  =  destClass.newInstance();	// create dest. object
				Class params[] = new Class[1];
				
				Method [] mth = destClass.getMethods();

				for(Method m1 : mth) {				
					if(m1.getName().equalsIgnoreCase(methodName)) {
						params[0] = m1.getParameterTypes()[0];	// Parameter setValue require 
						break;
					}
				}
				m = destClass.getDeclaredMethod(methodName, params);
				// Cast source into setValue method parameter.
				m.invoke(cls,typeCast(source,params[0]));
				
				return cls;
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				System.out.println("error in illegal : "+e1.getMessage());
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} 
			return cls;
		
	}
	
	/**
	 * Primitive or Wrapper conversion
	 *  
	 * @param source
	 * @param cls	class in which source into to convert
	 * @return Object of Bound type parameter.
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	private static <T> T typeCast(Object source , Class<T> cls) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		T t = null;
//		If Any of the parameter is from String class then need convert into Primitive or wrapper.
		
		if(!(cls.getSimpleName().equalsIgnoreCase("String") && source.getClass().getSimpleName().equalsIgnoreCase("String"))) {
			@SuppressWarnings("rawtypes")
			Class[] c = new Class[1];
			if(!(source.getClass().getSimpleName().equalsIgnoreCase("String"))) {
				c[0] = source.getClass().isPrimitive() ? source.getClass() : ClassUtils.wrapperToPrimitive(source.getClass());
			} else {
				c[0] = source.getClass();
			}
			Class<?> wrapperClass = cls.isPrimitive() ? ClassUtils.primitiveToWrapper(cls) : cls;
			Method m = wrapperClass.getDeclaredMethod(PRIMITIVE_WRAPPER_CONVERSION, c);
			t = (T) m.invoke(wrapperClass.getClass(), source);	// checked casting
//			System.out.println("value get : "+t);
			return t;
		} else {
			return ((T)source); 
		}
	}
	
}
