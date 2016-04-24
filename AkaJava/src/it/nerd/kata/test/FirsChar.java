package it.nerd.kata.test;

import static org.junit.Assert.*;
import it.nerd.kata.src.FirstChar;

import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.Test;

public class FirsChar {
	//Find first non repeating character in a String
	//input : "abcdxyzabc"
	//output : d
	@Test
	public void test() {
		assertNotNull(FirstChar.getFirstCharWithOccurrence("abcdxyzabc"));
		assertEquals('d', FirstChar.getFirstCharWithOccurrence("abcdxyzabc"));
		assertEquals('d', FirstChar.getFirstCharWithOccurrence("abcabcdef"));
		
		assertEquals('d',FirstChar.firstNonRepeatingChar("abcdxyzabc"));
		
		

	}

}
