package it.nerd.noob.generics;

public class Main {

	public static void main(String[] args) {
		
		//we have control at compile time
		BoxGeneric<String> boxG = new BoxGeneric<String>();
		boxG.set(new String("dummy"));
		
		//we haven't control at compile time
		Box box = new Box();
		box.set(new String("dummy"));

	}

}
