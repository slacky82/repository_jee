package it.nerd.basic;
import org.apache.commons.lang3.StringUtils;

public class StringNerd {

	public static void main(String[] args) {
		String stringNull=null;
		String emptyString=new String();
		String spaceString=new String(" ");
		
		String jedi1 = "Obi-wan";  
		String jedi2 = "Obi-wan";		
		String jedi3 = "Obi-wan";  
		String jedi4 = new String("Obi-wan");  
		
		
		
		/*
		System.out.println(StringUtils.isEmpty(stringNull));
		System.out.println(StringUtils.isEmpty(emptyString));
		System.out.println(StringUtils.isEmpty(spaceString));
		*/
		
		
		System.out.println(jedi1==jedi2); //true  
		System.out.println(jedi1.equals(jedi2)); //true  
		System.out.println(System.identityHashCode(jedi1)); //they are  
		System.out.println(System.identityHashCode(jedi2)); //the same object  
		
		System.out.println(jedi3==jedi4); //false  
		System.out.println(jedi3.equals(jedi4)); //true  
		System.out.println(System.identityHashCode(jedi3)); //they are  
		System.out.println(System.identityHashCode(jedi4)); //different objects  


	}

}
