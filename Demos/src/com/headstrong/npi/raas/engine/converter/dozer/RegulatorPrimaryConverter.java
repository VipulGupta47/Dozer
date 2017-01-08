package com.headstrong.npi.raas.engine.converter.dozer;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.headstrong.npi.raas.xml.pojo.Option;

public class RegulatorPrimaryConverter  implements CustomConverter {


	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
			
		if( source == null ) {
			return null;
		} 
		if(source instanceof Boolean) {
			if((Boolean)source ) {
				return Option.YES;
			} else return Option.NO;
			
		} else if( source instanceof Option){
			if(((Option)source).value().equalsIgnoreCase("yes")){
				return true;
			} else return false;
		} 
//		else {
//			throw new MappingException("Converter RegulatorPrimaryConverter "
//					+ "used incorrectly. Arguments passed in were:"
//					+ destination + " and " + source);
//		}
		return null;	
		
	}
}
