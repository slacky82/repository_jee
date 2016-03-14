package it.nerd.kata.src;

import java.util.List;

public class StringCalculator {
	/*TEST_GIT*/
	/**
	 * The method can take 0, 1 or 2 numbers, 
	 * and will return their sum (for an empty string it will return 0) 
	 * for example “” or “1” or “1,2”
	 */
	public static int Add(String text){
		int numberOne;
		int numberTwo;
		if(text.isEmpty()){
			return 0;
		}
		try{
			String[] numbers = text.split(",");
			if(numbers.length == 0){
				return 0;
			}
			if(numbers.length == 1){
				return new Integer(Integer.valueOf(numbers[0]));
			}
			if(!numbers[0].isEmpty() && !numbers[1].isEmpty()){
				 numberOne = new Integer(Integer.valueOf(numbers[0]));
				 numberTwo = new Integer(Integer.valueOf(numbers[1]));
				 return numberOne + numberTwo;
			}else if(!numbers[0].isEmpty()){
				return  Integer.valueOf(numbers[0]);
			}else {
				return  Integer.valueOf(numbers[1]);
			}			
		}catch(NumberFormatException ex){
			return 0;
		}
	}	

}
