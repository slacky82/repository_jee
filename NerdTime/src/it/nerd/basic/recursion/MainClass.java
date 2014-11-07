package it.nerd.basic.recursion;


import java.util.ArrayList;
import java.util.List;

public class MainClass {
	

	public static void main(String[] args) {
		char[] myArray = new char[4];
		myArray[0]='a';
		myArray[1]='b';
		myArray[2]='c';
		myArray[3]='d';
		System.out.println(recursion(myArray, 0));
		
	}
	
	public static int recursion(char[] myArray,int index){		
		if(myArray[index]=='a'){
			return index; 
		}
		else{
			return recursion(myArray,++index);
		}
	}	
		
		

}
