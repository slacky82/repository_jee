package it.acme.nerdlittleproject.utils;

import it.acme.nerdlittleproject.itineraries.Itinerary;

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
