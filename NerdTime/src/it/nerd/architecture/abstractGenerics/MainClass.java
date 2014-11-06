package it.nerd.architecture.abstractGenerics;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static List<String> myFieldB = new ArrayList<String>();

	public static void main(String[] args) {		
		myFieldB.add("AAA");
		myFieldB.add("BBB");
		myFieldB.add("CCC");
		MyClass myCls = new MyClass(myFieldB);		
		test(myCls);
	}
	
	private static void test(MyAbstractClass myAbsCls){		
		myAbsCls.wrap(myFieldB);				
	}

}
