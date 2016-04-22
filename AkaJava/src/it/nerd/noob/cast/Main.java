package it.nerd.noob.cast;

import java.text.ParseException;

public class Main {
	
	public static void main(String artgs[]){
		
		ClassCastNoob castNoob = new ClassCastNoob();
		Double dummyDouble = null;
		Double dummyDoubleErr;
		
		try {
			 dummyDouble = new Double(castNoob.getDecimalFormatIta().parse("20,0").doubleValue());
			 dummyDoubleErr = new Double("20,0");			
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Finally!!!");
		}
		//DOUBLE -> INT BOXED/UNBOXED
		castNoob.integerFoo = dummyDouble.intValue();
		castNoob.intFoo = (int) castNoob.douBar;
		
		System.out.println(dummyDouble);
		System.out.println(castNoob.intFoo);
		System.out.println(Integer.toBinaryString(castNoob.integerFoo));
		
	}

}
