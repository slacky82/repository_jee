package it.acme.nerdlittleproject;

import java.util.ArrayList;
import java.util.List;

import it.acme.nerdlittleproject.connections.Connection;
import it.acme.nerdlittleproject.connections.Expressway;
import it.acme.nerdlittleproject.connections.MainRoad;
import it.acme.nerdlittleproject.connections.Motorway;
import it.acme.nerdlittleproject.exception.InvalidItinerary;
import it.acme.nerdlittleproject.itineraries.EmptyItinerary;
import it.acme.nerdlittleproject.itineraries.Itinerary;
import it.acme.nerdlittleproject.itineraries.ItineraryStep;

public class Mappy {
	
	public  EmptyItinerary myItinerary = new EmptyItinerary();
	
	public Mappy(){
	}

	public void add(Connection c) throws InvalidItinerary {
		// TODO metodo add che prende una nuova connessione e restituisce void,
		// in modo tale che la nuova connessione può essere utilizzata per
		// costruire itinerari.
		// Se una connessione dello stesso tipo fra le stesse città esiste già,
		// l'aggiunta corrisponde ad un aggiornamento,
		// ovvero la nuova connessione sostituisce la precedente.
		myItinerary.add(c);
	}

	public Itinerary getItinerary(String cityFrom, String cityTo){
		//TODO un metodo getItinerary che è un overloading del metodo precedente 
		//che prende solamente le due città. 
		//In tal caso restituisce qualsiasi itinerario che connetta le due città. 
		//Se tale itinerario non esiste solleva un'eccezione NoSuchItinerary.
		return null;
	}
	
	public void printItinerary(){
		
		List<ItineraryStep> steps =  myItinerary.getSteps();
		for (ItineraryStep currStep : steps) {
			System.out.println("TYPE: " + currStep.getConnectionStep().getClass().getTypeName());
			System.out.println("FROM: " + currStep.getConnectionStep().getFrom());
			System.out.println("TO: " + currStep.getConnectionStep().getTo());
			System.out.println("TIME: " + currStep.getConnectionStep().getTime());
			System.out.println("KM : " + currStep.getConnectionStep().getKm());
			if ( currStep.getConnectionStep() instanceof Expressway){
				Expressway conn = (Expressway) currStep.getConnectionStep();
				System.out.println("NAME: " + conn.getName());
				System.out.println("SAFE: " + conn.getSafe());
			}
			if ( currStep.getConnectionStep() instanceof MainRoad){
				MainRoad conn = (MainRoad) currStep.getConnectionStep();
				System.out.println("NUMBER: " + conn.getNumber());
				System.out.println("TRAFFIC LIGHT:" + conn.isTrafficLight());
			}
			if ( currStep.getConnectionStep() instanceof Motorway){
				Motorway conn = (Motorway) currStep.getConnectionStep();
				System.out.println("NUMBER: " + conn.getNumber());
				System.out.println("PRICE: " + conn.getPrice());
			}
			System.out.println("#############\n");
			
			
		}
		
	}


}
