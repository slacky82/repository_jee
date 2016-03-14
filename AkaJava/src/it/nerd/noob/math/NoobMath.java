package it.nerd.noob.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NoobMath {
	
	public static void main(String [] ergs){
		BigDecimal bf = new BigDecimal("2");
		BigDecimal correctedQty = new BigDecimal("4");
		BigDecimal weight = new BigDecimal("2");
		bf = bf.multiply(correctedQty).divide(weight, 9, RoundingMode.HALF_UP);
		
		System.out.println("BF: "+bf);
	}

}
