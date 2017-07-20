package com.acme.mappy.itineraries;

import com.acme.mappy.connections.Connection;

public class ItineraryStep extends Itinerary {
	
	private Connection connectionStep;
	//what does it do?
	private Itinerary itinerary;
	
	//getter setter
	public Connection getConnectionStep() {
		return connectionStep;
	}
	public void setConnectionStep(Connection connectionStep) {
		this.connectionStep = connectionStep;
	}
	public Itinerary getItinerary() {
		return itinerary;
	}
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
}
