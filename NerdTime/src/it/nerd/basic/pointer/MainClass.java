package it.nerd.basic.pointer;

public class MainClass {

	public static void main(String[] args){
		MyData myData= new MyData();
		Bar barRef = new Bar();
		
		myData.propertyFoo=1;
		barRef.methodBar(myData);
		
		System.out.println(myData.propertyFoo);
		
	}
	
}
