package com.hs.demos.effectiveJava;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

public class CopyBeanToAnother {

	public static void main(String[] args) {
//		copyProperties()

	}

/**
 * copies properties from one object to another
 * 
 * @param src
 *            the source object
 * @param dest
 *            the destination object
 * @param properties
 *            a list of property names that are to be copied. Each value has
 *            the format "srcProperty destProperty". For example,
 *            "name fullName" indicates that you want to copy the src.name
 *            value to dest.fullName. If both the srcProperty and
 *            destProperty property have the same name, you can omit the
 *            destProperty. For example, "name" indicates that you want to
 *            copy src.name to dest.name.
 * 
 * @throws IllegalAccessException
 * @throws InvocationTargetException
 * @throws NoSuchMethodException
 */
public static void copyProperties(Object src, Object dest,
                String... properties) throws IllegalAccessException,
                InvocationTargetException, NoSuchMethodException {
        for (String property : properties) {
                String[] arr = property.split(" ");
                String srcProperty;
                String destProperty;
                if (arr.length == 2) {
                        srcProperty = arr[0];
                        destProperty = arr[1];
                } else {
                        srcProperty = property;
                        destProperty = property;
                }
                BeanUtils.setProperty(dest, destProperty, BeanUtils.getProperty(
                                src, srcProperty));
        }
}

}

class FromBean {
	
	private Ref ref;

	public Ref getRef() {
		return ref;
	}

	public void setRef(Ref ref) {
		this.ref = ref;
	}
	
	
	
}

class Ref {
private String refVariable;
	

	public String getRefVariable() {
		return refVariable;
	}

	public void setRefVariable(String refVariable) {
		this.refVariable = refVariable;
	}
}

class ToBean {
	
}
