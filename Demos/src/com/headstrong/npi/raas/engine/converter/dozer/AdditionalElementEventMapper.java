package com.headstrong.npi.raas.engine.converter.dozer;

import org.dozer.DozerEventListener;
import org.dozer.classmap.ClassMap;
import org.dozer.event.DozerEvent;
import org.dozer.event.DozerEventType;
import org.dozer.fieldmap.FieldMap;

import com.headstrong.npi.raas.cobs.xml.pojo.Attribute;
import com.headstrong.npi.raas.xml.pojo.CmAttribute;


public class AdditionalElementEventMapper implements DozerEventListener {

	@Override
	public void mappingStarted(DozerEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preWritingDestinationValue(DozerEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postWritingDestinationValue(DozerEvent event) {
		
//		Object dest = event.getDestinationValue();
//		System.out.println(event.getClassMap().getFieldMaps().get(0).getSrc);
//		if(dest instanceof CmAttribute) {
//			System.out.println("CmAttribute : "+dest);
//		} else if (dest instanceof Attribute) {
//			System.out.println("Attribute : "+dest);
//		}
//		System.out.println(event.getDestinationValue());
//		System.out.println(event.getDestinationObject());
		
	}

	@Override
	public void mappingFinished(DozerEvent event) {
		// TODO Auto-generated method stub
		
	}

	

}
