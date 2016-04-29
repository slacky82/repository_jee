package it.acme.nerdlittleproject.utils;

import it.acme.nerdlittleproject.itineraries.Itinerary;

public class CompareTime implements Compare {

	@Override
	public boolean isBetter(Itinerary i1, Itinerary i2) {
		if(i1.getTime() < i2.getTime()){
			return true;
		}
		else{
			return false;
		}
	}

}
