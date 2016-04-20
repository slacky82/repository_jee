package it.acme.nerdlittleproject.itineraries;

import java.util.ArrayList;
import java.util.List;

import it.acme.nerdlittleproject.connections.Connection;
import it.acme.nerdlittleproject.exceptions.InvalidItineraryException;
//modify in fooBranch
public abstract class Itinerary {
	
	private List<Connection> connections;
	
	public Itinerary(){
		connections = new ArrayList<Connection>();
	} 
	
	/**	
 	1)un metodo statico makeEmpty che restituisce un itinerario vuoto;
   	2)un metodo add che prende una connessione c e restituisce un nuovo itinerario 
   	dove la connessione c è stata aggiunta alla fine. 
   	Se tale aggiunta crea un itinerario che passa due volte nella stessa città, 
   	o un itinerario non continuo, invece di ritornare il nuovo itinerario si solleva 
   	l'eccezione InvalidItinerary;
   	3)un metodo getKilometer che restituisce il numero di chilometri dell'itinerario;
   	4)un metodo getPrice che restituisce il costo dell'itinerario;
   	5)un metodo getTime che restituisce il tempo medio per percorrere l'itinerario.
	*/
	
	public static EmptyItinerary makeEmpty(){
		return new EmptyItinerary();		
	};
	
	protected Itinerary add(Connection c){
		Itinerary dummyEtinerary = makeEmpty();
		connections.add(c);
		//TODO un metodo add che prende una connessione c e restituisce un nuovo itinerario 
	   	//dove la connessione c è stata aggiunta alla fine.	   	
		return dummyEtinerary;	
	}
	
	private void checkItinerary(Connection newConn) throws InvalidItineraryException {
		//TODO Se tale aggiunta crea un itinerario che passa due volte nella stessa città, 
	   	//o un itinerario non continuo, invece di ritornare il nuovo itinerario si solleva 
	   	//l'eccezione InvalidItinerary;
		for (Connection currConn : connections) {
			if(currConn.getFrom().equalsIgnoreCase(newConn.getFrom()) || currConn.getTo().equalsIgnoreCase(newConn.getTo())){
				throw new InvalidItineraryException();
			}
		}		
		//itinerario non continuo
		
	}
	
	protected float getKilometer(){
		//TODO un metodo getKilometer che restituisce il numero di chilometri dell'itinerario;
		
		return 0;		
	}
	
	
	
	
	
	

}
