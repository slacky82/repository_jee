package it.mit.courses.lecture3;

import javax.swing.JOptionPane;

public class VelocityTest {

	//checkin 1
	//checkin 2
	
	
	public static void main(String[] args) {
		//exerciseOne();
		exerciseTwo();
	}
	
	public static void exerciseOne(){
		double distance = 100; //km
		String input = 	JOptionPane.showInputDialog("Enter Time (hours)");
		if(input == null){
			return;
		} 
		int time = Integer.parseInt(input);
		distance = distance - 25;
		//V = S/T
		double v = distance / time;
		if(v > 60){
			System.out.println("v > 60 v= "+ v + " Km/h");
		}
	} 
	
	public static void exerciseTwo(){
		double d = 100;
		//double s = 50;
		double p = 10;
		double a = .1;
		double b = .2;
		
		String input = 	JOptionPane.showInputDialog("Enter Time (hours)");
		if(input == null){
			return;
		} 
		double s = Double.parseDouble(input);
		
		if(d == s){
			return;
		}
		if(d > s){
			p = p + a*(d-s);
		}		
		if(d < s){
			p = p - b*(s-d);
		}
	}
}
