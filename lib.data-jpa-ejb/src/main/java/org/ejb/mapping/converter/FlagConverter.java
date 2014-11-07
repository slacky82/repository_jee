package org.ejb.mapping.converter;

import org.dozer.DozerConverter;

public class FlagConverter extends DozerConverter<String, Boolean> {

	public FlagConverter() {
		super(String.class, Boolean.class);
	}

	public Boolean convertTo(String source, Boolean destination) {
		if(source == null)
			return Boolean.FALSE;
		if ("S".equals(source)) {
			return Boolean.TRUE;
		} else if ("N".equals(source)) {
			return Boolean.FALSE;
		}
		throw new IllegalStateException("Unknown value!");
	}

	public String convertFrom(Boolean source, String destination) {
		if(source == null)
			return null;
		if (Boolean.TRUE.equals(source)) {
			return "S";
		} else if (Boolean.FALSE.equals(source)) {
			return "N";
		}
		throw new IllegalStateException("Unknown value!");
	}

}