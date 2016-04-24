package it.acme.nerdlittleproject.itineraries;

import it.acme.nerdlittleproject.connections.Connection;

public class ItineraryStep extends Itinerary {
	
	private Connection connectionStep;
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
