package main.java.com.jasson.util;

import org.dozer.CustomConverter;

public class SpecialConverter implements CustomConverter {
	public Object convert(Object destinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		Object returnVale = null;
		if (sourceFieldValue != null) {
			if (sourceFieldValue instanceof Integer) {
				if ((Integer) sourceFieldValue == 0) {
					returnVale = "NO";
				} else if ((Integer) sourceFieldValue == 1) {
					returnVale = "OK";
				}
			} else if (sourceFieldValue instanceof String) {
				if (sourceFieldValue.equals("NO")) {
					returnVale = 0;
				} else if (sourceFieldValue.equals("OK")) {
					returnVale = 1;
				}
			}
		}
		return returnVale;
	}
}
