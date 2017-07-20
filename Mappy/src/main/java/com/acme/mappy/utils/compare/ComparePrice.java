package com.acme.mappy.utils.compare;

import com.acme.mappy.itineraries.Itinerary;

public class ComparePrice implements Compare { 
	
	@Override
	public boolean isBetter(Itinerary i1, Itinerary i2) {
		if(i1.getPrice() < i2.getPrice()){
			return true;
		}
		else{
			return false;
		}
	}

}
