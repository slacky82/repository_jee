package it.nerd.pattern.decorator;

public class CaffeZero extends Bevanda {
	
	public CaffeZero(){
		nome="Caffe Zero";
	}
	

	@Override
	public double getPrezzo() {
		return 1.50;
	}

}
