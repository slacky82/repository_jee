package com.acme.mappy.itineraries;

import java.util.ArrayList;

public class EmptyItinerary extends Itinerary {
	
	public EmptyItinerary(){
		steps =  new ArrayList<ItineraryStep>();
	}
	
//	private ItineraryStep step;
//
//	public ItineraryStep getStep() {
//		return step;
//	}
//
//	public void setStep(ItineraryStep step) {
//		this.step = step;
//	}	
}
