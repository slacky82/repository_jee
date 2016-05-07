package it.acme.nerdlittleproject.itineraries;

import java.util.ArrayList;
import java.util.List;

import it.acme.nerdlittleproject.connections.Connection;
import it.acme.nerdlittleproject.connections.Expressway;
import it.acme.nerdlittleproject.connections.MainRoad;
import it.acme.nerdlittleproject.connections.Motorway;
import it.acme.nerdlittleproject.exception.InvalidItinerary;

public abstract class Itinerary {
	//check if is right that this is there????
	protected List<ItineraryStep> steps;
	
	public Itinerary(){
	}
	
	
	//un metodo statico makeEmpty che restituisce un itinerario vuoto;
	public static EmptyItinerary makeEmpty(){
		return new EmptyItinerary();		
	}
	
	public Itinerary add(Connection c) throws InvalidItinerary{				
		checkItinerary(c);
		ItineraryStep stepDummy = new ItineraryStep();
		stepDummy.setConnectionStep(c);
		steps.add(stepDummy);
		return stepDummy;
	}
	
	public float getKilometer(){
		Float km = new Float(0);
		for (ItineraryStep itineraryStep : steps) {
			km = km + itineraryStep.getConnectionStep().getKm();
		}
		return km;
	}
	
	public Float getPrice(){
		Float price = new Float(0);		
		for (ItineraryStep itineraryStep : steps) {		
			
			if ( itineraryStep.getConnectionStep() instanceof Motorway){
				Motorway connDummy = (Motorway) itineraryStep.getConnectionStep();
				price = price + connDummy.getPrice();
			}
		}
		return price;
	}
	
	public int getTime(){
		int time = 0;
		for (ItineraryStep itineraryStep : steps) {
			time = time + itineraryStep.getConnectionStep().getTime();
		}
		return time;
	}
	
	private void checkItinerary(Connection newConn) throws InvalidItinerary{
		//passa due volte nella stessa città
		containsCity(newConn);
		
		//itinerario non continuo
		if(steps.size() > 1){
			Connection lastConnection = steps.get(steps.size()-1).getConnectionStep();
			if(!lastConnection.getTo().equalsIgnoreCase(newConn.getFrom())){
				throw new InvalidItinerary("itinerary does not linked");
			}
		}	
	}	
	
	private void containsCity(Connection conn) throws InvalidItinerary{
		for (ItineraryStep currStep : steps) {
			if(currStep.getConnectionStep().getTo().equalsIgnoreCase(conn.getTo())){
				throw new InvalidItinerary("itinerary goes two times in the same city");
			}
		}
	}


	public List<ItineraryStep> getSteps() {
		return steps;
	}


	public void setSteps(List<ItineraryStep> steps) {
		this.steps = steps;
	}
	
	public String toString(){
		StringBuffer mySB = new StringBuffer();
		for (ItineraryStep currStep : steps) {
			mySB = mySB.append(currStep.getConnectionStep().toString());
		}
		mySB.append("TOT. TIME: ");
		mySB.append(getTime());
		mySB.append("\n");
		mySB.append("TOT. KM: ");
		mySB.append(getKilometer());
		mySB.append("\n");
		mySB.append("TOT. PRICE: ");
		mySB.append(getPrice());
		mySB.append("\n");
		return mySB.toString();
	}
	
	
	

}
