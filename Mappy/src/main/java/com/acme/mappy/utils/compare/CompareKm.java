package com.acme.mappy.utils.compare;

import com.acme.mappy.itineraries.Itinerary;

public class CompareKm implements Compare { 
	
	@Override
	public boolean isBetter(Itinerary i1, Itinerary i2) {
		if(i1.getKilometer() < i2.getKilometer()){
			return true;
		}
		else{
			return false;
		}
	}

}
