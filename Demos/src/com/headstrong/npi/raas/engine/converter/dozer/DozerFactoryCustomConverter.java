package com.headstrong.npi.raas.engine.converter.dozer;

import org.dozer.MappingException;


/**
 * This is a Factory class which will delegates call to specific converter.
 * @author 400219569
 *
 */
final public class DozerFactoryCustomConverter {
	// Does not require Instance
	private DozerFactoryCustomConverter(){}
	
	/**
	 * method delegates it call to Converters.
	 * 
	 * @param from
	 * @param to
	 * @return Converted Object
	 */
	public static Object convert(Object from , Class<?> to) throws MappingException {
			
		
		if(to.isEnum()) {
			return  StringEnumCustomConverter.checkSourceInDestinationClass(to, from);
		} else if(from instanceof Enum) {
			return StringEnumCustomConverter.getValue(from.getClass(), from);
		} else if(to.isAssignableFrom(String.class)){
			return StringCustomConverter.getValue(from.getClass(), from);
		} else {
			return StringCustomConverter.setValueInDestinationObject(to, from);
		}
	}

}
