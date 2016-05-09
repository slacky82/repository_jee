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
import it.acme.nerdlittleproject.utils.CompareKm;
import it.acme.nerdlittleproject.utils.ComparePrice;
import it.acme.nerdlittleproject.utils.CompareTime;

public class Mappy {
	
	private Itinerary currItinerary = new EmptyItinerary();
	private List<Itinerary> allItineraries;
	
	public Mappy(){
		allItineraries = new ArrayList<Itinerary>();
	}

	/**
	 * prende una nuova connessione e restituisce void,
	 * in modo tale che la nuova connessione puÚ essere utilizzata per
	 * costruire itinerari.
	 * Se una connessione dello stesso tipo fra le stesse citt‡† esiste gi‡†,
	 * l'aggiunta corrisponde ad un aggiornamento,
	 * ovvero la nuova connessione sostituisce la precedente.
	 * @param c
	 * @throws InvalidItinerary
	 */
	public void add(Connection c) throws InvalidItinerary {
		if(currItinerary.getSteps().isEmpty()){
			currItinerary.add(c);
		}
		else {
			int index = getIndexConnection(c);
			if(index != -1){
				//UPDATE
				currItinerary.getSteps().get(index).setConnectionStep(c);
			}
			else{
				//INSERT
				currItinerary.add(c);
			}
		}
	}
	
	public void addItinerary(){
		allItineraries.add(currItinerary);
		currItinerary = Itinerary.makeEmpty();
	}
	
	/**
	 * getItinerary che √® un overloading del metodo precedente 
	 * che prende solamente le due citt√†. 
	 * In tal caso restituisce qualsiasi itinerario che connetta le due citt√†. 
	 * Se tale itinerario non esiste solleva un'eccezione NoSuchItinerary.
	 * @param cityFrom
	 * @param cityTo
	 * @return
	 * @throws NoSuchItinerary 
	 */
	public Itinerary getItinerary(String cityFrom, String cityTo) throws NoSuchItinerary{
		for (Itinerary currItinerary : allItineraries) {
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
	 * prende due citt√† e un oggetto best che implementa Compare 
	 * e restituisce l'itinerario che connette questa due citt√† rispetto al criterio best. 
	 * Se tale itinerario non esiste solleva un'eccezione NoSuchItinerary
	 * @param cityFrom
	 * @param cityTo
	 * @param best
	 * @return
	 */
	public Itinerary getItinerary (String cityFrom, String cityTo, Compare best)throws NoSuchItinerary{
		Itinerary dummyItinerary = null;
		for (Itinerary currItinerary : allItineraries) {
			if(!currItinerary.getSteps().isEmpty()){
				int indexLastConn = currItinerary.getSteps().size() - 1;
				Connection start = currItinerary.getSteps().get(0).getConnectionStep();
				Connection end = currItinerary.getSteps().get(indexLastConn).getConnectionStep();
				if(start.getFrom().equalsIgnoreCase(cityFrom) && end.getTo().equalsIgnoreCase(cityTo)){
					//return currItinerary;
					if(dummyItinerary == null){
						dummyItinerary = currItinerary;
					}
					if(best instanceof CompareKm){
						if(best.isBetter(currItinerary, dummyItinerary)){
							dummyItinerary = currItinerary;
						}
					}
					if(best instanceof ComparePrice){
						if(best.isBetter(currItinerary, dummyItinerary)){
							dummyItinerary = currItinerary;
						}
					}
					if(best instanceof CompareTime){
						if(best.isBetter(currItinerary, dummyItinerary)){
							dummyItinerary = currItinerary;
						}
					}
				}
			}
		}
		if(dummyItinerary == null){
			throw new NoSuchItinerary("this itinerary does not contains this step");
		}
		else{
			return dummyItinerary;
		}
	}
	
	
	private int getIndexConnection(Connection c){
		List<ItineraryStep> listIS = currItinerary.getSteps();
		for(int index = 0; index < listIS.size(); index++ ){
			Connection conn = listIS.get(index).getConnectionStep();
			if(conn.getFrom().equalsIgnoreCase(c.getFrom()) && conn.getTo().equalsIgnoreCase(c.getTo()) && 
					conn.getClass().getTypeName().equalsIgnoreCase(c.getClass().getTypeName())){
				return index;
			}			
		}
		return -1;		
	}
	
	public void printItineraryDummy(){
		int i = 0;
		for (Itinerary currItinerary : allItineraries) {
			System.out.println("ITINERARY N* " +  i++);
			System.out.println(currItinerary.toString());
			System.out.println("---------------");
		}
	}
	
	public void printItinerary(){
		int i = 0;
		for (Itinerary currItinerary : allItineraries) {
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
				System.out.println("#############");
			}
			System.out.println("TOT. TIME: " +  currItinerary.getTime());
			System.out.println("TOT. KM: " +    currItinerary.getKilometer());
			System.out.println("TOT. PRICE: " + currItinerary.getPrice());
			System.out.println("\n\n--------------------");
		}
	}

}
