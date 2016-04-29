package it.acme.nerdlittleproject;

import java.util.ArrayList;
import java.util.List;

import it.acme.nerdlittleproject.connections.Connection;
import it.acme.nerdlittleproject.connections.Expressway;
import it.acme.nerdlittleproject.connections.MainRoad;
import it.acme.nerdlittleproject.connections.Motorway;
import it.acme.nerdlittleproject.exception.InvalidItinerary;
import it.acme.nerdlittleproject.exception.NoSuchItinerary;
import it.acme.nerdlittleproject.itineraries.EmptyItinerary;
import it.acme.nerdlittleproject.itineraries.Itinerary;
import it.acme.nerdlittleproject.itineraries.ItineraryStep;
import it.acme.nerdlittleproject.utils.Compare;

public class Mappy {
	
	//should be a list of itineraries???!?!?!ß
	private Itinerary myItinerary = new EmptyItinerary();
	
	public  List<Itinerary> itineraries;
	
	
	public Mappy(){
		itineraries = new ArrayList<Itinerary>();
	}
	

	/**
	 * prende una nuova connessione e restituisce void,
	 * in modo tale che la nuova connessione può essere utilizzata per
	 * costruire itinerari.
	 * Se una connessione dello stesso tipo fra le stesse città esiste già,
	 * l'aggiunta corrisponde ad un aggiornamento,
	 * ovvero la nuova connessione sostituisce la precedente.
	 * @param c
	 * @throws InvalidItinerary
	 */
	public void add(Connection c) throws InvalidItinerary {
		if(myItinerary.getSteps().isEmpty()){
			myItinerary.add(c);
		}
		else {
			int index = getIndexConnection(c);
			if(index != -1){
				//UPDATE
				myItinerary.getSteps().get(index).setConnectionStep(c);
			}
			else{
				//INSERT
				myItinerary.add(c);
			}
		}
	}
	
	public void addItinerary(){
		itineraries.add(myItinerary);
		myItinerary = new EmptyItinerary();
	}
	
	/**
	 * getItinerary che è un overloading del metodo precedente 
	 * che prende solamente le due città. 
	 * In tal caso restituisce qualsiasi itinerario che connetta le due città. 
	 * Se tale itinerario non esiste solleva un'eccezione NoSuchItinerary.
	 * @param cityFrom
	 * @param cityTo
	 * @return
	 * @throws NoSuchItinerary 
	 */
	public Itinerary getItinerary(String cityFrom, String cityTo) throws NoSuchItinerary{
		for (Itinerary currItinerary : itineraries) {
			if(!currItinerary.getSteps().isEmpty()){
				int indexLastConn = currItinerary.getSteps().size() - 1;
				Connection start = currItinerary.getSteps().get(0).getConnectionStep();
				Connection end = currItinerary.getSteps().get(indexLastConn).getConnectionStep();
				if(start.getFrom().equalsIgnoreCase(cityFrom) && end.getTo().equalsIgnoreCase(cityTo)){
					return currItinerary;
				}
			}
		}
		throw new NoSuchItinerary("this itinerary does not contains this step");
	}
	
	/**
	 * prende due città e un oggetto best che implementa Compare 
	 * e restituisce l'itinerario che connette questa due città rispetto al criterio best. 
	 * Se tale itinerario non esiste solleva un'eccezione NoSuchItinerary
	 * @param cityFrom
	 * @param cityTo
	 * @param best
	 * @return
	 */
	public Itinerary getItinerary (String cityFrom, String cityTo, Compare best){
		return null;		
	}
	
	
	private int getIndexConnection(Connection c){
		List<ItineraryStep> listIS = myItinerary.getSteps();
		for(int index = 0; index < listIS.size(); index++ ){
			Connection conn = listIS.get(index).getConnectionStep();
			if(conn.getFrom().equalsIgnoreCase(c.getFrom()) && conn.getTo().equalsIgnoreCase(c.getTo()) && 
					conn.getClass().getTypeName().equalsIgnoreCase(c.getClass().getTypeName())){
				return index;
			}			
		}
		return -1;		
	}
	
	
	public void printItinerary(){
		int i = 0;
		for (Itinerary currItinerary : itineraries) {
			System.out.println("ITINERARY N* " +  i++);
			List<ItineraryStep> steps =  currItinerary.getSteps();
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

}
