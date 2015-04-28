package main.java.com.jasson.util;

import main.java.com.jasson.mode.GenderType;

import org.dozer.CustomConverter;


public class EnumConverter implements CustomConverter {
	public Object convert(Object destinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		Object returnVale = null;
		if (sourceFieldValue != null) {
			if (sourceFieldValue instanceof Integer) {
				if ((Integer) sourceFieldValue == 0) {
					returnVale = GenderType.male;
				} else if ((Integer) sourceFieldValue == 1) {
					returnVale = GenderType.female;
				}
			} else if (sourceFieldValue instanceof Enum) {
				if (sourceFieldValue == GenderType.male) {
					returnVale = 0;
				} else if (sourceFieldValue == GenderType.female) {
					returnVale = 1;
				}
			}
		}
		return returnVale;
	}
}
