package test.java;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.nerd.noob.cast.Animal;
import it.nerd.noob.cast.Dog;

public class TestGeneric {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testDummyCast() {
		Animal animal = new Animal();
		Dog dog = new Dog();
		
		//UPCAST is always allowed 
		((Animal) dog).run();
				
		//DOWNCAST is allowed because obj references a String
		Object obj = "a string";
		String foo = (String) obj;
		
		//DOWNCAST is allowed because fooDog references a Dog
		Animal fooDog = new Dog();
		((Dog) fooDog).bark();
		
		//DOWNCAST is not allowed;
		//classCastException
		exception.expect(ClassCastException.class);
	    ((Dog) animal).bark();
		
	}
	
	@Test
	public void testBigDecimalLong() {
		long foo = 0;
		new BigDecimal((Long)foo);
		
	}
	
	

}
