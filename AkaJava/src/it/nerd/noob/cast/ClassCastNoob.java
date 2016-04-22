package it.nerd.noob.cast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ClassCastNoob {
	
	 protected Integer integerFoo;
	 protected int intFoo;
	 protected Double doubleBar;
	 protected double douBar;
	
	public ClassCastNoob(){			
		init();
	}
	
	protected DecimalFormat getDecimalFormatIta(){
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.ITALIAN);
		DecimalFormat df = (DecimalFormat)nf;
		return df;
	}
	
	protected void init(){
		integerFoo = new Integer(100);
		intFoo = 50;
		doubleBar = new Double("20.1");
		douBar = 1.9;	
	}
	
	
	

}
