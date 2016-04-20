package it.nerd.noob;

public class Reference {
	
		
	public static void main(String[] args){
		Bar bar = new Bar();
		bar.setFooProperty(666);
		changeBar(bar);
		System.out.println(bar.getFooProperty());	
	}
	private static void changeBar(Bar bar){
		bar.setFooProperty(555);
	}
}

