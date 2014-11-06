package it.nerd.architecture.abstractGenerics;

import java.util.List;

public abstract class MyAbstractClass {
	
	protected Integer fieldA;
	protected List<?> fieldB;
	
	public MyAbstractClass(List<?> fieldB){
		this.fieldB=fieldB;
	}
	
	public abstract void wrap(List<?> fieldB);

}
