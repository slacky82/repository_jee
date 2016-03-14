package it.nerd.kata.test;

import static org.junit.Assert.*;
import it.nerd.kata.src.StringCalculator;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testAdd() {
		assertEquals(0, StringCalculator.Add(""));
		
		assertEquals(1, StringCalculator.Add("1"));
		assertEquals(8, StringCalculator.Add("8"));
		assertEquals(20, StringCalculator.Add("20"));
		
		assertEquals(1, StringCalculator.Add(",1"));
		assertEquals(8, StringCalculator.Add(",8"));
		assertEquals(20, StringCalculator.Add(",20"));
		
		assertEquals(1, StringCalculator.Add("1,"));
		assertEquals(8, StringCalculator.Add("8,"));
		assertEquals(20, StringCalculator.Add("20,"));
		
		assertEquals(0, StringCalculator.Add("20,A"));
		assertEquals(0, StringCalculator.Add("A,0"));
		assertEquals(0, StringCalculator.Add("A,A"));
		
		assertEquals(2, StringCalculator.Add("1,1"));
		assertEquals(9, StringCalculator.Add("1,8"));
		assertEquals(21, StringCalculator.Add("1,20"));
		
		assertEquals(2, StringCalculator.Add("1,1,9,10"));
		assertEquals(9, StringCalculator.Add("1,8,3,"));
	}

}
