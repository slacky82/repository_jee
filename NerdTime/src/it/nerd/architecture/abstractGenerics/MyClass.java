package it.nerd.architecture.abstractGenerics;

import java.util.List;

public class MyClass extends MyAbstractClass {

	public MyClass(List<String> fieldB){		
		super(fieldB);
	}
	
	

	@Override
	public void wrap(List<?> fieldB) {
		List<String> stringFieldB = (List<String>) fieldB;	
		for (String string : stringFieldB) {
			System.out.println(string);
		}
	}

}
