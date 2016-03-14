package it.nerd.kata.test;

import static org.junit.Assert.*;

import java.util.BitSet;

import it.nerd.kata.src.BinaryChop;
import it.nerd.kata.src.FirstChar;

import org.junit.Test;

public class BinaryChopTestCases {

	@Test
	public void test() {
		int mySortedArr[] = new int[]{1,2,5,7,9};
		assertEquals(2,  BinaryChop.searchIt(mySortedArr, 5)  );
	}

}
