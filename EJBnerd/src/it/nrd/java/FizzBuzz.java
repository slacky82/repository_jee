package it.nrd.java;

public class FizzBuzz {
	
	/**
	 * Write a program that prints the numbers from 1 to 100. 
	 * But for multiples of three print "Fizz" instead of the number 
	 * and for the multiples of five print "Buzz". 
	 * For numbers which are multiples of both three and five print "FizzBuzz".
	 */
	
	public static int counter = 0;
	
	public static boolean isMultiplesOfThree(int number){
		counter ++;
		return number % 3 == 0;
	}	
	
	public static boolean isMultiplesOfFive(int number){
		counter ++;
		return number % 5 == 0;		
	} 
	
	public static void coreDummy() {
		for (int number = 1; number <= 100; number++) {
			if (isMultiplesOfThree(number) && isMultiplesOfFive(number)) {
				System.out.println("FizzBuz");
			} else if (isMultiplesOfThree(number)) {
				System.out.println("Fizz");
			} else if (isMultiplesOfFive(number)) {
				System.out.println("Buzz");
			} else {
				System.out.println(String.valueOf(number));
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
