package it.nerd.basic.pointer;

import java.math.BigDecimal;
import java.util.Date;

public class MainClass {

	public static void main(String[] args){
		/**
		 * Long String Boolean BigDecimal Sono IMMUTABILI
		 * Date è MUTABILE!!!!
		 */
		MyData myData= new MyData();
		Bar barRef = new Bar();		
		myData.property=100;
		Integer integerP=100;
		int intP=100;
		BigDecimal bigdecimalP= new BigDecimal("100.99");
		Date dateP = new Date();
				
		barRef.changeProperty(myData);		
		System.out.println("barRef.changeProperty(myData); "+myData.property);		
		changeProperty(myData);		
		System.out.println("changeProperty(myData); "+myData.property);
		changeProperty(integerP);
		System.out.println("changeProperty(integerP); "+integerP);
		
		 
	}
	
	public static void changeProperty(MyData myData){
		myData.property=2;
	}
	public static void changeProperty(Integer integerP){
		integerP=2;
	}	
	public static void changeProperty(int intP){
		intP=2;
	}
	public static void changeProperty(BigDecimal bigdecimalP){		
		bigdecimalP=new BigDecimal("2");
	}
	public static void changeProperty(Date dateP){		
		dateP=null;
	}
	
	
}
