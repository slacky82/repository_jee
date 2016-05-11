package it.nerd.kata.test;

import static org.junit.Assert.*;

import java.util.Arrays;

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
		
		//
		assertEquals(0, StringCalculator.Add2(""));
		
		assertEquals(1, StringCalculator.Add2("1"));
		assertEquals(8, StringCalculator.Add2("8"));
		assertEquals(20, StringCalculator.Add2("20"));
		
		assertEquals(1, StringCalculator.Add2(",1"));
		assertEquals(8, StringCalculator.Add2(",8"));
		assertEquals(20, StringCalculator.Add2(",20"));
		
		assertEquals(1, StringCalculator.Add2("1,"));
		assertEquals(8, StringCalculator.Add2("8,"));
		assertEquals(20, StringCalculator.Add2("20,"));
		
		assertEquals(20, StringCalculator.Add2("20,A"));
		assertEquals(0, StringCalculator.Add2("A,0"));
		assertEquals(0, StringCalculator.Add2("A,A"));
		
		assertEquals(2, StringCalculator.Add2("1,1"));
		assertEquals(9, StringCalculator.Add2("1,8"));
		assertEquals(21, StringCalculator.Add2("1,20,"));
		
		assertEquals(21, StringCalculator.Add2("1,1,9,10"));
		assertEquals(6, StringCalculator.Add2("1\n2,3"));
		
		assertEquals(3, StringCalculator.Add2("//;\n1;2"));
		assertEquals(1, StringCalculator.Add2("1,\n"));
		
		assertEquals(3, StringCalculator.Add2("//;\n-1;2"));
	}
}
