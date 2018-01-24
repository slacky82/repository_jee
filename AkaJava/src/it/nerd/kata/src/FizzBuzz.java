package it.nerd.kata.src;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FizzBuzz {
	
	/**
	 * Write a program that prints the numbers from 1 to 100. 
	 * But for multiples of three print "Fizz" instead of the number 
	 * and for the multiples of five print "Buzz". 
	 * For numbers which are multiples of both three and five print "FizzBuzz".
	 */
	
	public static int counter = 0;
	
	 private static final Logger _log = LogManager.getLogger(FizzBuzz.class);
	
	public static boolean isMultiplesOfThree(int number){
		counter ++;
		return number % 3 == 0;
	}	
	
	public static boolean isMultiplesOfFive(int number){
		counter ++;
		return number % 5 == 0;		
	} 
	/* score 60% to many if-else constructor :( */
	public static void coreDummy() {
		for (int number = 1; number <= 100; number++) {
			if (isMultiplesOfThree(number) && isMultiplesOfFive(number)) {
				_log.info("FizzBuz: " + number );
			} else if (isMultiplesOfThree(number)) {
				_log.info("Fizz: " + number);
			} else if (isMultiplesOfFive(number)) {
				_log.info("Buzz: " + number);
			} else {
				_log.info(String.valueOf(number));
			}
		}
	}
	
	//less divide operations
	public static void  coreOptimized(){
		for (int number=1 ; number <= 100; number++){
			//TODO
		}
	}

}
