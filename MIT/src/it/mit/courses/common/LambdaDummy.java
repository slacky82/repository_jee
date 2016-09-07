package it.mit.courses.common;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class LambdaDummy {

	 public static void main(String[] args) {
		 
	      List<String> strings = Arrays.asList("Lambda ", "expressions ", "are ", "cool");
	      
	      //CON Iterazione Interna
	      strings.forEach(new Consumer<String>() {
	          public void accept(String s) {
	             System.out.print(s);
	          }
	       });
	 
	      //CON l'utilizzo della LAMBDA expression (funzione anonima)
	      strings.forEach((String s) -> System.out.print(s));
	 
	   }
}
