package it.nerd.noob.cast;

public class Main {

	public static void main(String[] args) {
		Animal animal = new Animal();
		Dog dog = new Dog();
		
		//UPCAST is always allowed 
		((Animal) dog).run();
				
		//DOWNCAST is allowed because obj references a String
		Object obj = "a string";
		String foo = (String) obj;
		
		//DOWNCAST is allowed because fooDog references a Dog
		Animal fooDog = new Dog();
		((Dog) fooDog).bark();
		
		
		
		//DOWNCAST is not allowed;
		try {
			//classCastException
			((Dog) animal).bark();
		}catch(ClassCastException e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
