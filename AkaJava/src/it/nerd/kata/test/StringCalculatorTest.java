package it.nerd.kata.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import it.nerd.kata.src.StringCalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testAdd() {
		StringCalculator sc = new StringCalculator();
		assertEquals(0, sc.Add2(""));
		
		assertEquals(1, sc.Add2("1"));
		assertEquals(20, sc.Add2("20"));
		assertEquals(1, sc.Add2(",1"));
		assertEquals(20, sc.Add2(",20"));
		assertEquals(1, sc.Add2("1,"));
		assertEquals(20, sc.Add2("20,"));
		assertEquals(20, sc.Add2("20,A"));
		assertEquals(0, sc.Add2("A,0"));
		assertEquals(0, sc.Add2("A,A"));
		assertEquals(2, sc.Add2("1,1"));
		assertEquals(21, sc.Add2("1,20,"));
		
		assertEquals(3, sc.Add2("//;\n1;2"));
		assertEquals(1, sc.Add2("1,\n"));
	}
	
	@Test
	public void unknownAmountNumbers(){
		StringCalculator sc = new StringCalculator();
		assertEquals(9, sc.Add2("1,1,1,1,5"));
	}
	
	@Test
	public void newLine(){
		StringCalculator sc = new StringCalculator();
		assertEquals(6, sc.Add2("1\n2,3"));
		assertEquals(5, sc.Add2("\n2,3"));
		assertEquals(5, sc.Add2("2,3\n"));
	}
	
	@Test
	public void negativeValue(){
		thrown.expect(IllegalArgumentException.class);
		//thrown.expectMessage("negatives not allowed");
		StringCalculator sc = new StringCalculator();
		sc.Add2(new String("//;\n-1;2; -3"));
	}
}
