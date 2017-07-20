package com.acme.utils;

public enum TypeParser {
	
	DOM_TYPE (1),
	TEXT_TYPE (2);
	
	private int value;
	
	TypeParser(int type){
		this.value=type;
	}

	public int getValue() {
		return value;
	}

	
	
	

}
