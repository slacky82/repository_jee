package com.acme.mappy.utils.compare;

import it.acme.nerdlittleproject.itineraries.Itinerary;

public interface Compare {	
	
	/**
	 * return true if i1 is better of it2
	 * @param i1
	 * @param i2
	 * @return 
	 */
	boolean isBetter(Itinerary i1, Itinerary i2);

}
